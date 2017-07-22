package eu.convertron.core;

import eu.convertron.applib.CsvStorage;
import eu.convertron.applib.modules.ConfigurationSourceProvider;
import eu.convertron.applib.modules.IOConfigurationProvider;
import eu.convertron.applib.modules.ModuleConfigurationProvider;
import eu.convertron.applib.settings.Settings;
import eu.convertron.client.ServerConnection;
import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.TableOptions;
import eu.convertron.interlib.config.DesiredLocation;
import eu.convertron.interlib.config.GeneralConfigFile;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.config.MoveConflictUserCallback;
import eu.convertron.interlib.io.Folder;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.net.URL;
import javax.swing.Timer;

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

    public Control()
    {
        provider = new ModuleConfigurationProvider(new IOConfigurationProvider(CoreSettings.pathLocalData.load()),
                                                   createGlobalConfigurationSourceProvider(),
                                                   createMoveConflictUserCallback());

        coreConfig = provider.provideConfig(Control.class);
        storage = new CsvStorage(coreConfig, "lessondata.csv");

        TableOptions.getInstance().setConfiguration(coreConfig);

        motdConfigFile = new GeneralConfigFile(coreConfig, "motd.txt", DesiredLocation.ForceGlobalAndDiscardLocal);

        moduleManager = new ModuleManager(provider);

        autoTimer = new Timer(60000, (e) -> timerTick());
        autoTimer.start();

        Logger.logMessage(LogPriority.HINT, "Anwendung gestartet");
    }

    private MoveConflictUserCallback createMoveConflictUserCallback()
    {
        //TODO
        return null;
    }

    private ConfigurationSourceProvider createGlobalConfigurationSourceProvider()
    {
        if(CoreSettings.useRemote.isTrue())
        {
            ServerConnection con = null;
            try
            {
                if(CoreSettings.useCustomWsdl.isTrue())
                    con = new ServerConnection(new URL(CoreSettings.remoteWsdl.load()), true);
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
                Logger.logError(LogPriority.ERROR, "Fehler beim starten im Remote Modus, versuche im Normalmodus zu starten", t);
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
            exportLessonsAndMotd();
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

    public void exportLessonsAndMotd()
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
}
