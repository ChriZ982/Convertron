package eu.convertron.core;

import eu.convertron.applib.modules.ConfigurationProvider;
import eu.convertron.applib.modules.IOConfigurationProvider;
import eu.convertron.applib.storage.CsvStorage;
import eu.convertron.applib.storage.Storage;
import eu.convertron.client.ServerConnection;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.io.Folder;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.settings.Settings;
import eu.convertron.interlib.util.Bundle;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import javax.swing.Timer;

/**
 * Verwaltet alle Aktionen, die im Programm geschehen sollen.
 */
public class Control
{
    public static final String MOTD_SAVEFILE = "motd.txt";

    private final Storage storage;
    private final ModuleManager moduleManager;
    private final Timer autoTimer;

    private final ConfigurationProvider provider;
    private final Configuration coreConfig;

    public Control()
    {
        Bundle<ConfigurationProvider, Storage> bundle = initializeConfigAndStorage();
        provider = bundle.getA();
        storage = bundle.getB();

        coreConfig = provider.getOrCreateConfiguration(TableOptions.class);

        TableOptions.getInstance().setConfiguration(coreConfig);

        moduleManager = new ModuleManager(provider);

        autoTimer = new Timer(60000, (e) -> timerTick());
        autoTimer.start();

        Logger.logMessage(LogPriority.HINT, "Anwendung gestartet");
    }

    private Bundle<ConfigurationProvider, Storage> initializeConfigAndStorage()
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
                return new Bundle<>(con, con);
            }
            catch(Throwable t)
            {
                if(con != null)
                    con.close();
                Logger.logError(LogPriority.ERROR, "Fehler beim starten im Remote Modus, versuche im Normalmodus zu starten", t);
            }
        }
        String data = CoreSettings.pathData.load();
        return new Bundle<>(new IOConfigurationProvider(data + "/config"),
                            new CsvStorage(data + "/data.csv"));
    }

    private void timerTick()
    {
        if(CoreSettings.autoMode.load().equals("true"))
            genAll();
    }

    /**
     * Beendet die Logic des Programms.
     * @return success
     */
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
            storage.save(TableOptions.getInstance().compress(in));
            Logger.logMessage(LogPriority.HINT, "Vertretungseinträge aktualisiert");
        }
        else
        {
            Logger.logMessage(LogPriority.INFO, "Import lieferte keine neuen Vertretungeinträge, keine Änderungen vorgenommen");
        }
    }

    public void exportLessonsAndMotd()
    {
        moduleManager.exportLessons(storage.load());
        moduleManager.exportMotd(new String(coreConfig.getOrCreateConfig(MOTD_SAVEFILE), StandardCharsets.UTF_8));

        Logger.logMessage(LogPriority.HINT, "Exportieren abgeschlossen");
    }

    public void createBackup()
    {
        try
        {
            String backupPath = CoreSettings.pathBackup.load();
            new Folder(CoreSettings.pathData.load()).copyContent(backupPath);
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

    public Configuration getCoreConfig()
    {
        return coreConfig;
    }
}
