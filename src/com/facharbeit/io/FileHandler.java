package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.io.*;
import java.nio.file.*;

public class FileHandler
{
    private File file;

    public FileHandler(String path)
    {
        this(new File(path));
    }

    public FileHandler(File file)
    {
        this.file = file;
    }

    /**
     * Erstellt eine neue Datei.
     */
    public void create()
    {
        try
        {
            file.getParentFile().mkdirs();
            if(file.createNewFile())
                Logger.log("\"" + file.getName() + "\" wurde erstellt.", 0);
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht erstellt werden", 2);
            Logger.error(ex);
        }
    }

    public void delete()
    {
        try
        {
            if(file.delete())
                Logger.log("\"" + file.getName() + "\" wurde gelöscht.", 0);
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht gelöscht werden", 2);
            Logger.error(ex);
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
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geprüft werden", 2);
            Logger.error(ex);
            return false;
        }
    }

    /**
     * Kopiert eine Datei zu einem Pfad.
     *
     * @param dest
     * @param log
     */
    public void copy(String dest, boolean log)
    {
        try
        {
            if(exists())
            {
                new File(dest).mkdirs();
                Files.copy(Paths.get(file.getPath()), Paths.get(dest + file.getName()), StandardCopyOption.REPLACE_EXISTING);
                if(log)
                    Logger.log(file.getName() + " wurde kopiert", 0);
            }
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht kopiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Kopiert Dateien.
     *
     * @param dest
     */
    public void copyFromRes(String dest)
    {
        try
        {
            File f = new File(dest + file.getName());
            f.getParentFile().mkdirs();
            if(!f.exists())
            {
                InputStream in = getClass().getResourceAsStream(file.getPath().replaceAll("\\\\", "/"));
                FileOutputStream out = new FileOutputStream(f);

                for(int read; (read = in.read()) != -1;)
                    out.write(read);
                out.flush();

                Logger.log(f.getName() + " wurde kopiert", 0);
            }
        }
        catch(Exception ex)
        {
            Logger.log("Datei konnte nicht kopiert werden", 2);
            Logger.error(ex);
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
        }
        catch(Exception ex)
        {
            Logger.log("Zeilenanzahl von \"" + file.getName() + "\" konnte nicht ermittelt werden", 2);
            Logger.error(ex);
            return -1;
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
        }
        catch(Exception ex)
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
        }
        catch(Exception ex)
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
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht zum String konvertiert werden", 2);
            Logger.error(ex);
            return null;
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
        }
        catch(Exception ex)
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
            String[] oldText = read();
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
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geschrieben werden", 2);
            Logger.error(ex);
        }
    }
}
