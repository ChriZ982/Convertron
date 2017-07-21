package eu.convertron.applib;

import eu.convertron.interlib.Lesson;
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
        csvFile.createIfNotExists();
        this.csvFile = csvFile;
    }

    @Override
    public void save(Lesson[] lessons)
    {
        try
        {
            String serialzation = new CsvLessonSerializer().serializeMultiple(lessons);
            System.out.println(serialzation);
            csvFile.writeText(serialzation);
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
