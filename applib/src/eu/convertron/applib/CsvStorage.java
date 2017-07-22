package eu.convertron.applib;

import eu.convertron.interlib.Lesson;
import eu.convertron.interlib.config.DesiredLocation;
import eu.convertron.interlib.config.GeneralConfigFile;
import eu.convertron.interlib.config.ModuleConfiguration;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;

/**
 * Die Klasse zum Zwischenspeichern von Stunden-Array und Laufschrift mithilfe von Csv-Dateien.
 */
public class CsvStorage extends GeneralConfigFile
{
    public CsvStorage(ModuleConfiguration config, String configName)
    {
        super(config, configName, DesiredLocation.ForceGlobalAndDiscardLocal);
    }

    public void saveLessons(Lesson[] lessons)
    {
        try
        {
            String serialzation = new CsvLessonSerializer().serializeMultiple(lessons);
            save(serialzation);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim speichern der Vertretungplaninformationen.", ex);
        }
    }

    public Lesson[] loadLessons()
    {
        try
        {
            String serialzation = loadString().trim();
            return new CsvLessonSerializer().deserializeMultiple(serialzation);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim laden der Vertretungplaninformationen.", ex);
            return new Lesson[0];
        }
    }
}
