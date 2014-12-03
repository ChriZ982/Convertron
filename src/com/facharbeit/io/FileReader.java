package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.io.*;

/**
 * Lies ganze Text-Dateien aus.
 */
public class FileReader
{
    private File file;

    /**
     * Erstellt einen neuen Reader.
     *
     * @param pPath
     * @param pFilename Name der Datei
     */
    public FileReader(String pPath, String pFilename)
    {
        file = new File(pPath + pFilename);
    }

    public FileReader(File f)
    {
        file = f;
    }

    /**
     * Liest eine Zeile der Datei.
     *
     * @param line Zeile, die gelesen werden soll
     *
     * @return Inhalt dieser Zeile
     */
    public String read(int line)
    {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1")))
        {
            for(int i = 0; i < line; i++)
                reader.readLine();

            return reader.readLine();
        } catch(IOException e)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geladen werden.", 2);
            return "";
        }
    }

    /**
     * Liest ganze Datei aus.
     *
     * @return Ganze Datei als String Array
     */
    public String[] readAll()
    {
        int length = getLines();
        String[] data = new String[length];

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1")))
        {
            for(int i = 0; i < length; i++)
                data[i] = reader.readLine();

            reader.close();
            return data;
        } catch(IOException ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geladen werden.", 2);
            data[0] = "";
            return data;
        }
    }

    /**
     * Konvertiert das Array in einen einzelnen String.
     *
     * @return Ganze Datei als String
     */
    @Override
    public String toString()
    {
        String data = "";
        String[] newFile = readAll();

        for(int i = 0; i < newFile.length - 1; i++)
            data += "\n" + newFile[i];

        return data;
    }

    /**
     * Liest eine Zeile als Zahl.
     *
     * @param line Zeile, die gelesen werden soll
     *
     * @return Zahl, die die angegebene Zeile repräsentiert
     */
    public int readAsNumber(int line)
    {
        try
        {
            return Integer.parseInt(read(line));
        } catch(NumberFormatException ex)
        {
            System.out.println("ZEILE AUS \"" + file.getName() + "\" KONNTE NICHT ALS ZAHL GELESEN WERDEN!");
            return -1;
        }
    }

    /**
     * Prüft ob die Datei existiert.
     *
     * @return Existiert die Datei?
     */
    public boolean exists()
    {
        return file.isFile() && file.exists();
    }

    /**
     * Gibt die Zeilenanzahl zurück.
     *
     * @return Anzahl der Zeilen
     */
    public int getLines()
    {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1")))
        {
            int lines = 0;
            while(reader.readLine() != null)
                lines++;

            reader.close();
            return lines;
        } catch(IOException ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geladen werden.", 2);
            return -1;
        }
    }
}
