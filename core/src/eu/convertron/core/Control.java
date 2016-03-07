package eu.convertron.core;

import eu.convertron.applib.storage.CsvStorage;
import eu.convertron.applib.storage.Storage;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.io.Folder;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.settings.SettingLocation;
import javax.swing.Timer;

/**
 * Verwaltet alle Aktionen, die im Programm geschehen sollen.
 */
public class Control
{
    private final Storage storage;
    private final ModuleManager moduleManager;
    private final Timer autoTimer;

    public Control()
    {
        copyFilesFromPackage();

        moduleManager = new ModuleManager();

        storage = new CsvStorage(CoreSettings.pathData.load() + "/data.csv");

        autoTimer = new Timer(60000, (e) -> timerTick());
        autoTimer.start();

        Logger.logMessage(LogPriority.HINT, "Anwendung gestartet");
    }

    private void timerTick()
    {
        if(CoreSettings.autoMode.load().equals("true"))
            genAll();
    }

    /**
     * Initialisiert den Data-Ordner.
     */
    private void copyFilesFromPackage()
    {
        String destPath = CoreSettings.pathData.load();
        Resources.copyRes("stdData/antonianumLogo.png", destPath);
        Resources.copyRes("stdData/template - style.txt", destPath);
        Resources.copyRes("stdData/VERTRETUNGSPLAN.html", destPath);
        Resources.copyRes("stdData/template - motd.txt", destPath);
        Resources.copyRes("stdData/template - day.txt", destPath);
        Resources.copyRes("stdData/template - class.txt", destPath);
        Resources.copyRes("stdData/template - lesson.txt", destPath);
        Resources.copyRes("stdData/design.xml", destPath);

        Logger.logMessage(LogPriority.INFO, "Alle Dateien wurden erstellt oder überprüft");
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
            //Flush Storage when needed, etc

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
            storage.save(TableOptions.compress(in));
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
        moduleManager.exportMotd(CoreSettings.motdText.load());

        Logger.logMessage(LogPriority.HINT, "Exportieren abgeschlossen");
    }

    public void createBackup()
    {
        try
        {
            String backupPath = CoreSettings.pathBackup.load();
            new Folder(CoreSettings.pathData.load()).copyContent(backupPath);
            SettingLocation.LOCAL.getFile().copy(backupPath);
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
}
