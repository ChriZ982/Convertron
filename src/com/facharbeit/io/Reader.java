package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lies ganze Text-Dateien aus.
 */
public class Reader
{
    /**
     * Name der Datei.
     */
    private String filename;

    /**
     * Erstellt einen neuen Reader.
     * @param pFilename Name der Datei
     */
    public Reader(String pFilename)
    {
        filename = pFilename;
    }

    /**
     * Liest eine Zeile der Datei.
     * @param line Zeile, die gelesen werden soll
     * @return Inhalt dieser Zeile
     */
    public String read(int line)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("Data/" + filename)))
        {
            for(int i = 0; i < line; i++) //Läuft Zeilen durch bis die gewünschte Zeile erreicht ist.
                reader.readLine();

            return reader.readLine();
        } catch(IOException e)
        {
            Logger.log("\"" + filename + "\" konnte nicht geladen werden.", 2);
            return "";
        }
    }

    /**
     * Liest ganze Datei aus.
     * @return Ganze Datei als String Array
     */
    public String[] readAll()
    {
        int length = getLines();
        String[] data = new String[length];

        try(BufferedReader reader = new BufferedReader(new FileReader("Data/" + filename)))
        {
            for(int i = 0; i < length; i++)
                data[i] = reader.readLine();

            reader.close();
            return data;
        } catch(IOException ex)
        {
            Logger.log("\"" + filename + "\" konnte nicht geladen werden.", 2);
            data[0] = "";
            return data;
        }
    }

    /**
     * Konvertiert das Array in einen einzelnen String.
     * @return Ganze Datei als String
     */
    @Override
    public String toString()
    {
        String data = "";
        String[] file = readAll();

        for(int i = 0; i < file.length - 1; i++)
            data += "\n" + file[i];

        return data;
    }

    /**
     * Liest eine Zeile als Zahl.
     * @param line Zeile, die gelesen werden soll
     * @return Zahl, die die angegebene Zeile repräsentiert
     */
    public int readAsNumber(int line)
    {
        try
        {
            return Integer.parseInt(read(line));
        } catch(NumberFormatException ex)
        {
            System.out.println("ZEILE AUS \"" + filename + "\" KONNTE NICHT ALS ZAHL GELESEN WERDEN!");
            return -1;
        }
    }

    /**
     * Prüft ob die Datei existiert.
     * @return Existiert die Datei?
     */
    public boolean exists()
    {
        File file = new File("Data/" + filename);
        return file.exists();
    }

    /**
     * Gibt die Zeilenanzahl zurück.
     * @return Anzahl der Zeilen
     */
    public int getLines()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader("Data/" + filename)))
        {
            int lines = 0;
            while(reader.readLine() != null)
                lines++;

            reader.close();
            return lines;
        } catch(IOException ex)
        {
            Logger.log("\"" + filename + "\" konnte nicht geladen werden.", 2);
            return -1;
        }
    }
}
