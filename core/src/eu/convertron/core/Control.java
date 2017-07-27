package eu.convertron.core;

import eu.convertron.applib.CsvStorage;
import eu.convertron.applib.modules.ConfigurationSourceProvider;
import eu.convertron.applib.modules.IOConfigurationProvider;
import eu.convertron.applib.modules.ModuleConfigurationProvider;
import eu.convertron.applib.settings.Settings;
import eu.convertron.client.ServerConnection;
import eu.convertron.core.usercallback.UserCallback;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.TableOptions;
import eu.convertron.interlib.config.DesiredLocation;
import eu.convertron.interlib.config.GeneralConfigFile;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.io.Folder;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import javax.swing.Timer;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Verwaltet alle Aktionen, die im Programm geschehen sollen.
 */
public class Control
{
    private final GeneralConfigFile motdConfigFile;

    private final CsvStorage storage;
    private final ModuleManager moduleManager;
    private final Timer autoTimer;

    private final ModuleConfigurationProvider provider;
    private final ModuleConfiguration coreConfig;

    public Control(UserCallback callback)
    {
        provider = new ModuleConfigurationProvider(new IOConfigurationProvider(CoreSettings.pathLocalData.load()),
                                                   createGlobalConfigurationSourceProvider(),
                                                   callback);

        coreConfig = provider.provideConfig("core");
        storage = new CsvStorage(coreConfig, "lessondata.csv");
        storage.addConfigFileListener((newValue) -> exportLessons());

        TableOptions.getInstance().setConfiguration(coreConfig);

        motdConfigFile = new GeneralConfigFile(coreConfig, "motd.txt", DesiredLocation.ForceGlobalAndDiscardLocal);
        motdConfigFile.addConfigFileListener((newValue) -> exportMotd());

        moduleManager = new ModuleManager(provider);

        autoTimer = new Timer(60000, (e) -> timerTick());
        autoTimer.start();

        Logger.logMessage(LogPriority.HINT, "Anwendung gestartet");
    }

    private ConfigurationSourceProvider createGlobalConfigurationSourceProvider()
    {
        if(CoreSettings.useRemote.isTrue())
        {
            ServerConnection con = null;
            try
            {
                if(CoreSettings.useCustomWsdl.isTrue())
                    con = new ServerConnection(CoreSettings.remoteWsdl.load(), true);
                else
                    con = new ServerConnection(CoreSettings.remoteHost.load(),
                                               Integer.parseInt(CoreSettings.remotePort.load()), true);

                Logger.logMessage(LogPriority.HINT, "Erfolgreich mit Server verbunden");
                return con;
            }
            catch(Throwable t)
            {
                if(con != null)
                    con.close();
                Logger.logError(LogPriority.ERROR, "Fehler beim Starten im Remote Modus, versuche im Normalmodus zu starten", t);
            }
        }
        return new IOConfigurationProvider(CoreSettings.pathGlobalData.load());
    }

    private void timerTick()
    {
        if(CoreSettings.autoMode.load().equals("true"))
            genAll();
    }

    public boolean stop()
    {
        try
        {
            autoTimer.stop();
            Settings.flush();

            return true;
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Beenden", ex);
            return false;
        }
    }

    public void genAll()
    {
        if(CoreSettings.autoBackup.load().equals("true"))
            createBackup();

        if(CoreSettings.autoImport.load().equals("true"))
            importLessons();

        if(CoreSettings.autoExport.load().equals("true"))
            export();
    }

    public void importLessons()
    {
        Lesson[] in = moduleManager.importLessons();
        if(in != null)
        {
            storage.saveLessons(TableOptions.getInstance().compress(in));
            Logger.logMessage(LogPriority.HINT, "Vertretungseinträge aktualisiert");
        }
        else
        {
            Logger.logMessage(LogPriority.INFO, "Import lieferte keine neuen Vertretungeinträge, keine Änderungen vorgenommen");
        }
    }

    public void export()
    {
        exportLessons();
        exportMotd();
    }

    public void exportLessons()
    {
        moduleManager.exportLessons(storage.loadLessons());
        Logger.logMessage(LogPriority.HINT, "Exportieren der Vertretungseintraege abgeschlossen");
    }

    public void exportMotd()
    {
        moduleManager.exportMotd(motdConfigFile.loadString());
        Logger.logMessage(LogPriority.HINT, "Exportieren der Laufschrift abgeschlossen");
    }

    public void createBackup()
    {
        try
        {
            String backupPath = CoreSettings.pathBackup.load();
            new Folder(CoreSettings.pathGlobalData.load()).copyContent(backupPath);
            new TextFile(Settings.SETTING_FILE).copy(backupPath);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Fehler beim erstellen eines Backups", ex);
        }
    }

    public ModuleManager getModuleManager()
    {
        return moduleManager;
    }

    public ModuleConfiguration getCoreConfig()
    {
        return coreConfig;
    }

    public GeneralConfigFile getMotdConfigFile()
    {
        return motdConfigFile;
    }

    public TextFile startMeld(String file1Name, byte[] file1, String file2Name, byte[] file2)
    {
        final String resultFileName = "MERGE_RESULT";
        if(resultFileName.equals(file1Name) || resultFileName.equals(file2Name))
        {
            throw new IllegalArgumentException("Filename reserved.");
        }

        Folder folder = new Folder(System.getProperty("java.io.tmpdir"))
                .createChild(UUID.randomUUID().toString());

        TextFile f1 = new TextFile(folder, file1Name, UTF_8);
        f1.writeBytes(file1);

        TextFile f2 = new TextFile(folder, file2Name, UTF_8);
        f2.writeBytes(file2);

        TextFile result = new TextFile(folder, resultFileName, UTF_8);
        result.writeBytes(file1);

        startMeldProcess(f1.getFileName(), result.getFileName(), f2.getFileName());

        return result;
    }

    private void startMeldProcess(String... args)
    {
        try
        {
            ArrayList<String> arguments = new ArrayList<>(Arrays.asList(CoreSettings.pathMeld.load()));
            arguments.addAll(Arrays.asList(args));

            Process p = new ProcessBuilder(arguments).start();
        }
        catch(IOException ex)
        {
            throw new RuntimeException("Failed to start meld process.", ex);
        }
    }

    public byte[] finishMeld(TextFile mergeResult)
    {
        byte[] data = mergeResult.readAllBytes();
        mergeResult.getFolder().delete();
        return data;
    }
}
