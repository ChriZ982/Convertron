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
    File file;

    /**
     * Erstellt einen neuen Schreiber.
     *
     * @param pPath
     * @param pFilename Name der Datei
     */
    public FileWriter(String pPath, String pFilename)
    {
        file = new File(pPath + pFilename);

        FileReader reader = new FileReader(file);

        if(!reader.exists())
            create();
    }

    public FileWriter(File f)
    {
        file = f;

        FileReader reader = new FileReader(file);

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
        try(PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "ISO-8859-1")))
        {
            for(int i = 0; i < data.length; i++)
                if(i + 1 < data.length)
                    writer.println(data[i]);
                else
                    writer.print(data[i]);
        } catch(IOException ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geladen werden.", 2);
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
        FileReader reader = new FileReader(file);
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
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(file);

        String[] data = reader.readAll();

        if(!new FileReader(pPath, file.getName()).exists())
            writer.create();

        writer.writeAll(data);
    }

    /**
     * Erstellt eine neue Datei.
     */
    public void create()
    {
        File thisFile = new File(file.getParent());
        thisFile.mkdirs();
        try
        {
            if(file.createNewFile())
                Logger.log("\"" + file.getName() + "\" wurde erstellt.", 0);
        } catch(IOException ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht erstellt werden.", 2);
        }

    }
}
