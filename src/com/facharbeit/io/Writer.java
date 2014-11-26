package com.facharbeit.io;

import com.facharbeit.io.Reader;
import com.facharbeit.tools.*;
import java.io.*;

/**
 * Klasse zum schreiben ganzer Text-Dateien.
 */
public class Writer
{

    /**
     * Name der Datei.
     */
    private String filename;

    /**
     * Erstellt einen neuen Schreiber.
     *
     * @param pFilename Name der Datei
     */
    public Writer(String pFilename)
    {
        filename = pFilename;
    }

    /**
     * Schreibt eine ganze Datei neu.
     *
     * @param data Daten, die in die Datei geschrieben werder sollen
     */
    public void writeAll(String[] data)
    {
        try(PrintWriter writer = new PrintWriter(new FileOutputStream("Data/" + filename)))
        {
            for(int i = 0; i < data.length; i++)
                if(i + 1 < data.length)
                    writer.println(data[i]);
                else
                    writer.print(data[i]);
        } catch(IOException ex)
        {
            Logger.log("\"" + filename + "\" konnte nicht geladen werden.", 2);
        }
    }

    /**
     * Schreibt nur eine Zeile einer Datei neu.
     *
     * @param line    Zeile, die neu geschrieben werden soll
     * @param content Text, der geschrieben werden soll
     */
    public void write(int line, String content)
    {
        Reader reader = new Reader(filename);
        String[] temp = reader.readAll();
        String[] data = new String[line + 1];

        for(int i = 0; i < data.length; i++)
            if(i < temp.length)
                data[i] = temp[i];
            else
                data[i] = "";

        data[line] = content;

        writeAll(data);
    }

    public void copy(String path)
    {
        Reader reader = new Reader(filename);
        String[] data = reader.readAll();

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(path + filename)))
        {
            for(int i = 0; i < data.length; i++)
                if(i + 1 < data.length)
                    writer.println(data[i]);
                else
                    writer.print(data[i]);
        } catch(IOException ex)
        {
            Logger.log("\"" + filename + "\" konnte nicht geladen werden.", 2);
        }
    }

    /**
     * Erstellt eine neue Datei.
     */
    public void create()
    {
//        try
//        {
//            PrintWriter writer = new PrintWriter(new FileOutputStream("Data/" + filename));
//            writer.close();
//
//            Logger.log("\"" + filename + "\" wurde erstellt.", 0);
//        } catch(IOException ex)
//        {
//            Logger.log("\"" + filename + "\" konnte nicht erstellt werden.", 2);
//        }

        File thisFile = new File("Data/");

        thisFile.mkdirs();

        thisFile = new File("Data/" + filename);

        try
        {
            if(thisFile.createNewFile())
                Logger.log("\"" + filename + "\" wurde erstellt.", 0);
        } catch(IOException ex)
        {
            Logger.log("\"" + filename + "\" konnte nicht erstellt werden.", 2);
        }

    }
}
