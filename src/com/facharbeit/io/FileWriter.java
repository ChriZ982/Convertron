package com.facharbeit.io;

import com.facharbeit.io.FileReader;
import com.facharbeit.io.FileWriter;
import com.facharbeit.tools.*;
import java.io.*;

/**
 * Klasse zum schreiben ganzer Text-Dateien.
 */
public class FileWriter
{

    /**
     * Name der Datei.
     */
    private String filename;
    private String path;

    /**
     * Erstellt einen neuen Schreiber.
     *
     * @param pPath
     * @param pFilename Name der Datei
     */
    public FileWriter(String pPath, String pFilename)
    {
        filename = pFilename;
        path = pPath;

        FileReader reader = new FileReader(pPath, pFilename);

        if(!reader.exists())
            create();
    }

    /**
     * Schreibt eine ganze Datei neu.
     *
     * @param data Daten, die in die Datei geschrieben werder sollen
     */
    public void writeAll(String[] data)
    {
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
     * Schreibt nur eine Zeile einer Datei neu.
     *
     * @param line    Zeile, die neu geschrieben werden soll
     * @param content Text, der geschrieben werden soll
     */
    public void write(int line, String content)
    {
        FileReader reader = new FileReader(path, filename);
        String[] temp = reader.readAll();
        String[] data;

        if(line + 1 > temp.length)
            data = new String[line + 1];
        else
            data = new String[temp.length];

        for(int i = 0; i < data.length; i++)
            if(i < temp.length)
                data[i] = temp[i];
            else
                data[i] = "";

        data[line] = content;

        writeAll(data);
    }

    public void copy(String pPath)
    {
        FileReader reader = new FileReader(path, filename);
        FileWriter writer = new FileWriter(pPath, filename);

        String[] data = reader.readAll();

        if(!new FileReader(pPath, filename).exists())
            writer.create();

        writer.writeAll(data);
    }

    /**
     * Erstellt eine neue Datei.
     */
    public void create()
    {
        File thisFile = new File(path);

        thisFile.mkdirs();

        thisFile = new File(path + filename);

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
