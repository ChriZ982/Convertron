package converter.io;

import converter.util.Logger;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Mit dieser Klasse können, hauptsächlic Textdateien, gelesen und geschrieben werden.
 */
public class FileIO
{
    private Path path;

    /**
     * Erstellt einen FileHandler.
     *
     * @param path Pfad zur Datei inklusive Dateiname
     */
    public FileIO(String path)
    {
        try
        {
            this.path = Paths.get(path);
        }
        catch(InvalidPathException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path + " konnte nicht initialisiert werden", Logger.INVALIDPATH_EXCEPTION);
        }
    }

    /**
     * Erstellt eine neue Datei.
     *
     *
     * @throws java.io.IOException
     */
    public void create()
    {
        try
        {
            if(isRealFile())
                return;
            Files.createDirectories(path.getParent());
            Files.createFile(path);

        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht erstellt werden", Logger.SECURITY_EXCEPTION);
        }
        catch(IOException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht erstellt werden", Logger.IO_EXCEPTION);
        }
    }

    /**
     * Löscht eine bestehende Datei.
     *
     *
     */
    public void remove()
    {
        try
        {
            if(!isRealFile())
                return;
            Files.delete(path);
        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht gelöscht werden", Logger.SECURITY_EXCEPTION);
        }
        catch(IOException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht gelöscht werden", Logger.IO_EXCEPTION);
        }
    }

    /**
     * Prüft ob die Datei existiert.
     *
     * @return Existiert die Datei?
     *
     *
     */
    public boolean isRealFile()
    {
        return Files.isRegularFile(path) && Files.exists(path);
    }

    /**
     * Kopiert eine Datei zu einem Pfad.
     *
     * @param destination Zielpfad
     *
     * @throws java.io.IOException
     *
     *
     */
    public void copy(String destination)
    {
        try
        {
            if(!isRealFile())
                return;
            Path dest = Paths.get(destination + "/" + path.getFileName().toString());
            Files.createDirectories(dest.getParent());
            Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING);

        }
        catch(InvalidPathException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht nach " + destination + " kopiert werden", Logger.INVALIDPATH_EXCEPTION);
        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht nach " + destination + " kopiert werden", Logger.SECURITY_EXCEPTION);
        }
        catch(IOException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht nach " + destination + " kopiert werden", Logger.IO_EXCEPTION);
        }
    }

    /**
     * Kopiert Dateien aus dem Java-Package der Facharbeit.
     *
     * @param destination
     *
     *
     */
    public void copyFromPackage(String destination)
    {
        try
        {
            Path dest = Paths.get(destination + "/" + path.getFileName().toString());
            Files.createDirectories(dest.getParent());
            if(Files.exists(dest))
                return;
            String pathInvertedSlash = path.toString().replace("\\", "/");
            Files.copy(getClass().getResourceAsStream(pathInvertedSlash), dest, StandardCopyOption.REPLACE_EXISTING);
        }
        catch(InvalidPathException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht nach " + destination + " kopiert werden", "Ein Pfad ist fehlerhaft", "Bitte überprüfen Sie die vorangegangenen Angaben");
        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht nach " + destination + " kopiert werden", Logger.SECURITY_EXCEPTION);
        }
        catch(IOException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht nach " + destination + " kopiert werden", Logger.IO_EXCEPTION);
        }
    }

    /**
     * Gibt die Zeilenanzahl von Textdateien zurück.
     *
     * @return Anzahl der Zeilen
     *
     * @throws java.io.IOException
     *
     *
     */
    public int lineCount()
    {
        return readAllArray().length;
    }

    /**
     * Liest eine Zeile der Datei.
     *
     * @param lineNumber Zeile, die gelesen werden soll
     *
     * @return Inhalt dieser Zeile
     *
     * @throws java.io.IOException
     *
     *
     */
    public String readLine(int lineNumber)
    {
        return readAllArray()[lineNumber];
    }

    /**
     * Liest die ganze Datei aus.
     *
     * @return Ganze Datei als String Array
     *
     * @throws java.io.IOException
     *
     *
     */
    public String[] readAllArray()
    {
        try
        {
            return Files.readAllLines(path, Charset.forName("ISO-8859-1")).toArray(new String[0]);
        }
        catch(OutOfMemoryError ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht gelesen werden", "Die Datei ist zu groß", "Verkleinern oder Löschen Sie die Datei");
        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht gelesen werden", Logger.SECURITY_EXCEPTION);
        }
        catch(IOException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht gelesen werden", Logger.IO_EXCEPTION);
        }
        return new String[0];
    }

    /**
     * Konvertiert die Datei in einen einzelnen String.
     *
     * @return Ganze Datei als String
     *
     * @throws java.io.IOException
     *
     *
     */
    public String readAllString()
    {
        return String.join("\n", readAllArray());
    }

    /**
     * Schreibt eine ganze Datei neu.
     *
     * @param text Daten, die in die Datei geschrieben werder sollen
     *
     * @throws java.io.UnsupportedEncodingException
     * @throws java.io.FileNotFoundException
     *
     *
     */
    public void writeLines(String... text)
    {
        try
        {
            Files.write(path, Arrays.asList(text));
        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht geschrieben werden", Logger.SECURITY_EXCEPTION);
        }
        catch(IOException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht geschrieben werden", Logger.IO_EXCEPTION);
        }
    }

    /**
     * Schreibt nur eine Zeile einer Datei neu.
     *
     * @param lineNumber Zeile, die neu geschrieben werden soll
     * @param newText    Text, der geschrieben werden soll
     *
     * @throws java.io.IOException
     *
     *
     */
    public void writeLine(int lineNumber, String newText)
    {
        String[] oldText = readAllArray();
        oldText[lineNumber] = newText;
        writeLines(oldText);
    }

    public void appendLines(String... text)
    {
        try
        {
            Files.write(path, Arrays.asList(text), StandardOpenOption.APPEND);
        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht erweitert werden", Logger.SECURITY_EXCEPTION);
        }
        catch(IOException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht erweitert werden", Logger.IO_EXCEPTION);
        }
    }
}
