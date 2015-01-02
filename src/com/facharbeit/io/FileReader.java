package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.io.*;

/**
 * Liest Dateien aus.
 */
public class FileReader
{
    /**
     * Datei, die von dem Reader verwendet wird.
     */
    private File file;

    /**
     * Erstellt einen neuen Reader.
     *
     * @param path Pfad der Datei
     * @param name Name der Datei
     */
    public FileReader(String path, String name)
    {
        try
        {
            file = new File(path, name);
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Erstellt einen neuen Reader
     *
     * @param file Die Datei, die gelesen werden soll.
     */
    public FileReader(File file)
    {
        try
        {
            this.file = file;
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Liest eine Zeile der Datei.
     *
     * @param lineNumber Zeile, die gelesen werden soll
     *
     * @return Inhalt dieser Zeile
     */
    public String read(int lineNumber)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
            for(int i = 0; i < lineNumber; i++)
                reader.readLine();
            String line = reader.readLine();

            reader.close();
            return line;
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht gelesen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Liest ganze Datei aus.
     *
     * @return Ganze Datei als String Array
     */
    public String[] read()
    {
        try
        {
            int length = length();
            String[] text = new String[length];

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));

            for(int i = 0; i < length; i++)
                text[i] = reader.readLine();

            reader.close();
            return text;
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht gelesen werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Konvertiert die Datei in einen einzelnen String.
     *
     * @return Ganze Datei als String
     */
    @Override
    public String toString()
    {
        try
        {
            String asString = "";
            String[] text = read();

            for(int i = 0; i < text.length - 1; i++)
                asString += "\n" + text[i];

            return asString;
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht zum String konvertiert werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Prüft ob die Datei existiert.
     *
     * @return Existiert die Datei?
     */
    public boolean exists()
    {
        try
        {
            return file.isFile() && file.exists();
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geprüft werden", 2);
            Logger.error(ex);
            return false;
        }
    }

    /**
     * Gibt die Zeilenanzahl zurück.
     *
     * @return Anzahl der Zeilen
     */
    public int length()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
            int lines = 0;
            while(reader.readLine() != null)
                lines++;

            reader.close();
            return lines;
        } catch(Exception ex)
        {
            Logger.log("Zeilenanzahl von \"" + file.getName() + "\" konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return -1;
        }
    }
}
