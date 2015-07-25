package converter.io;

import converter.util.Logger;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.logging.Level;

/**
 * Mit dieser Klasse können, hauptsächlic Textdateien, gelesen und geschrieben werden.
 */
public class FileIO
{
    Path path;

    /**
     * Erstellt einen FileHandler.
     *
     * @param path Pfad zur Datei inklusive Dateiname
     */
    public FileIO(String path)
    {
        this.path = Paths.get(path);
    }

    /**
     * Erstellt eine neue Datei.
     *
     *
     * @throws java.io.IOException
     */
    public void create()
    {
        if(isFileAndExists())
            return;

        try
        {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        }
        catch(SecurityException ex)
        {
            Logger.log(Logger.ERROR, "Die Datei " + path.toString() + " konnte nicht erstellt werden",
                       "Eine Sicherheitseinstellung wurde verletzt",
                       "Prüfen Sie die Sicherteitseinstellungen");
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
            Files.delete(path);
        }
        catch(IOException ex)
        {
            java.util.logging.Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Prüft ob die Datei existiert.
     *
     * @return Existiert die Datei?
     *
     *
     */
    public boolean isFileAndExists()
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
            if(!isFileAndExists())
                return;

            Path dest = Paths.get(destination + "\\" + path.getFileName().toString());
            Files.createDirectories(dest.getParent());
            Files.copy(path, dest, StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException ex)
        {
            java.util.logging.Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Kopiert Dateien aus dem Java-Package der Facharbeit.
     *
     * @param dest Zielpfad
     *
     * @throws java.io.IOException
     *
     *
     */
    public void copyFromRes(String dest)
    {
//        FileIO f = new FileIO(dest + getName());
//        f.getParentFile().mkdirs();
//        if(!f.exists())
//        {
//            InputStream in = getClass().getResourceAsStream(getPath().replaceAll("\\\\", "/"));
//            FileOutputStream out = new FileOutputStream(f);
//
//            for(int read; (read = in.read()) != -1;)
//                out.write(read);
//            out.flush();
//
//            Logger.log(f.getName() + " wurde kopiert", 0);
//        }
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
        catch(IOException ex)
        {
            java.util.logging.Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        catch(IOException ex)
        {
            java.util.logging.Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
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
        catch(IOException ex)
        {
            java.util.logging.Logger.getLogger(FileIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
