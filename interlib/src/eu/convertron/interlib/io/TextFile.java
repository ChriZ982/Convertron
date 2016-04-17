package eu.convertron.interlib.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.nio.charset.StandardCharsets.UTF_8;

/** Verwaltet, Erstellt und Löscht Textdateien. */
public class TextFile extends GeneralFile
{
    private Charset charset;

    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public TextFile(File path)
    {
        this(path, UTF_8);
    }

    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public TextFile(URI path)
    {
        this(path, UTF_8);
    }

    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public TextFile(String path)
    {
        this(path, UTF_8);
    }

    /**
     * Kontruktor.
     * @param folder   Ordner der Daten
     * @param fileName Dateiname der Daten
     */
    public TextFile(String folder, String fileName)
    {
        this(folder, fileName, UTF_8);
    }

    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public TextFile(Path path)
    {
        this(path, UTF_8);
    }

    /**
     * Kontruktor.
     * @param path    Pfad zur Datei
     * @param charset
     */
    public TextFile(File path, Charset charset)
    {
        super(path);
        this.charset = charset;
    }

    /**
     * Kontruktor.
     * @param path    Pfad zur Datei
     * @param charset
     */
    public TextFile(URI path, Charset charset)
    {
        super(path);
        this.charset = charset;
    }

    /**
     * Kontruktor.
     * @param path    Pfad zur Datei
     * @param charset
     */
    public TextFile(String path, Charset charset)
    {
        super(path);
        this.charset = charset;
    }

    /**
     * Kontruktor.
     * @param folder   Ordner der Daten
     * @param fileName Dateiname der Daten
     * @param charset
     */
    public TextFile(String folder, String fileName, Charset charset)
    {
        super(folder, fileName);
        this.charset = charset;
    }

    /**
     * Kontruktor.
     * @param path    Pfad zur Datei
     * @param charset
     */
    public TextFile(Path path, Charset charset)
    {
        super(path);
        this.charset = charset;
    }

    /**
     * Gibt die Zeilenanzahl des Dokuments.
     * @return Zeilenanzahl
     */
    public int getLineCount()
    {
        return readAllToArray().length;
    }

    /**
     * Liest eine bestimmte Zeile.
     * @param lineNumber Zeilennummer
     * @return Zeileninhalt
     */
    public String readLine(int lineNumber)
    {
        return readAllToArray()[lineNumber];
    }

    /**
     * Liest alle Zeilen als Array ein.
     * @return Alle Zeilen als Array
     */
    public String[] readAllToArray()
    {
        List<String> result = readAllToList();
        return result.toArray(new String[result.size()]);
    }

    public List<String> readAllToList()
    {
        try
        {
            return Files.readAllLines(getPath(), charset);
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be read", ex);
        }
    }

    public void deleteLine(int lineNumber)
    {
        List<String> fileLines = readAllToList();
        fileLines.remove(lineNumber);
        writeLines(fileLines.toArray(new String[fileLines.size()]));
    }

    /**
     * Liest alle Zeilen als String ein.
     * @return Alle Zeilen als String
     */
    public String readAllToString()
    {
        return String.join("\n", readAllToArray());
    }

    /**
     * Uberschreibt alle Zeilen des Dokuments.
     * @param text Zeilen, die geschrieben werden
     */
    public void writeLines(String... text)
    {
        try
        {
            Files.createDirectories(getPath().getParent());
            Files.write(getPath(), Arrays.asList(text), StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be written", ex);
        }
    }

    /**
     * Schreibt den Text in das Dokument.
     * @param text Inhalt der Datei
     */
    public void writeText(String text)
    {
        writeBytes(text.getBytes(charset));
    }

    /**
     * Schreibt die bytes in das Dokument.
     * @param bytes Inhalt der Datei
     */
    public void writeBytes(byte[] bytes)
    {
        try
        {
            Files.createDirectories(getPath().getParent());
            Files.write(getPath(), bytes, StandardOpenOption.TRUNCATE_EXISTING);
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be written", ex);
        }
    }

    /**
     * Verändert eine Zeile.
     * @param lineNumber Zeilennummer
     * @param newText    Neuer Inhalt
     */
    public void writeLine(int lineNumber, String newText)
    {
        String[] oldText = readAllToArray();
        oldText[lineNumber] = newText;
        writeLines(oldText);
    }

    /**
     * Fügt Zeilen an das Dokument an.
     * @param text Neue Zeilen
     */
    public void appendLines(String... text)
    {
        try
        {
            Files.createDirectories(getPath().getParent());
            Files.write(getPath(), Arrays.asList(text), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be extended", ex);
        }
    }

    /**
     * Gibt die Zeilennummern einer Zeile, die mit einer festgelegten Zeichenfolge beginnt.
     * @param prefix Zeichenfolge, die am Anfang stehen soll
     * @return Zeilennummer
     */
    public int getNumberOfLineStartingWith(String prefix)
    {
        String[] fileLines = readAllToArray();
        for(int i = 0; i < fileLines.length; i++)
        {
            if(fileLines[i].startsWith(prefix))
                return i;
        }
        return -1;
    }

    /**
     * Schreibt in die Zeile, die mit einer festgelegten Zeichenfolge beginnt.
     * @param prefix  Zeichenfolge, die am Anfang stehen soll
     * @param newText Neuer Inhalt
     */
    public void writeLineStartingWith(String prefix, String newText)
    {
        writeLine(getNumberOfLineStartingWith(prefix), newText);
    }

    /**
     * Prüft ob es eine Zeile gibt, die mit einer festgelegten Zeichenfolge beginnt.
     * @param prefix Zeichenfolge, die am Anfang stehen soll
     * @return Beginnt die Zeile mit einer festgelegten Zeichenfolge?
     */
    public boolean containsLineStartingWith(String prefix)
    {
        return -1 != getNumberOfLineStartingWith(prefix);
    }

    /**
     * Liest eine Zeile, die mit einer festgelegten Zeichenfolge beginnt.
     * @param prefix Zeichenfolge, die am Anfang stehen soll
     * @return Ganze Zeile
     */
    public String readLineStartingWith(String prefix)
    {
        String[] fileLines = readAllToArray();
        for(String line : fileLines)
        {
            if(line.startsWith(prefix))
                return line;
        }
        return null;
    }

    /**
     * Liest alle Zeilen, die mit einer festgelegten Zeichenfolge beginnen.
     * @param prefix Zeichenfolge, die am Anfang stehen soll
     * @return Ganze Zeilen
     */
    public String[] readLinesStartingWith(String prefix)
    {
        ArrayList<String> lines = new ArrayList<String>();
        String[] fileLines = readAllToArray();
        for(String line : fileLines)
        {
            if(line.startsWith(prefix))
                lines.add(line);
        }
        return lines.toArray(new String[lines.size()]);
    }
}
