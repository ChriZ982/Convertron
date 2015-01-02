package com.facharbeit.io;

import com.facharbeit.io.FileReader;
import com.facharbeit.tools.Logger;
import java.io.*;

/**
 * Klasse zum Schreiben von Dateien.
 */
public class FileWriter
{
    /**
     * Datei, die von dem Writer verwendet wird.
     */
    File file;

    /**
     * Erstellt einen neuen Writer.
     *
     * @param path Pfad der Datei
     * @param name Name der Datei
     */
    public FileWriter(String path, String name)
    {
        try
        {
            file = new File(path, name);
            if(!new FileReader(file).exists())
                create();
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Erstellt einen neuen Writer.
     *
     * @param file Datei, die verwendet werden soll
     */
    public FileWriter(File file)
    {
        try
        {
            this.file = file;
            if(!new FileReader(file).exists())
                create();
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Schreibt eine ganze Datei neu.
     *
     * @param text Daten, die in die Datei geschrieben werder sollen
     */
    public void write(String[] text)
    {
        try
        {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "ISO-8859-1"));
            for(int i = 0; i < text.length; i++)
                if(i + 1 < text.length)
                    writer.println(text[i]);
                else
                    writer.print(text[i]);
            writer.close();
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geschrieben werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Schreibt nur eine Zeile einer Datei neu.
     *
     * @param lineNumber Zeile, die neu geschrieben werden soll
     * @param text       Text, der geschrieben werden soll
     */
    public void write(int lineNumber, String text)
    {
        try
        {
            FileReader reader = new FileReader(file);
            String[] oldText = reader.read();
            String[] newText;

            if(lineNumber + 1 > oldText.length)
                newText = new String[lineNumber + 1];
            else
                newText = new String[oldText.length];

            for(int i = 0; i < newText.length; i++)
                if(i < oldText.length)
                    newText[i] = oldText[i];
                else
                    newText[i] = "";

            newText[lineNumber] = text;
            write(newText);
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geschrieben werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Erstellt eine neue Datei.
     */
    public void create()
    {
        try
        {
            new File(file.getParent()).mkdirs();
            if(file.createNewFile())
                Logger.log("\"" + file.getName() + "\" wurde erstellt.", 0);
        } catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht erstellt werden", 2);
            Logger.error(ex);
        }

    }
}
