package eu.convertron.applib.storage;

import eu.convertron.applib.etc.CsvLessonSerializer;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;

/**
 * Die Klasse zum Zwischenspeichern von Stunden-Array und Laufschrift mithilfe von Csv-Dateien.
 */
public class CsvStorage implements Storage
{
    private TextFile csvFile;

    public CsvStorage(String path)
    {
        this(new TextFile(path));
    }

    public CsvStorage(TextFile csvFile)
    {
        this.csvFile = csvFile;
    }

    @Override
    public void save(Lesson[] lessons)
    {
        try
        {
            String serialzation = new CsvLessonSerializer().serializeMultiple(lessons);
            csvFile.writeLines(serialzation);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim speichern der Vertretungplaninformationen.", ex);
        }
    }

    @Override
    public Lesson[] load()
    {
        try
        {
            String serialzation = csvFile.readAllToString().trim();
            return new CsvLessonSerializer().deserializeMultiple(serialzation);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim laden der Vertretungplaninformationen.", ex);
            return new Lesson[0];
        }
    }
}