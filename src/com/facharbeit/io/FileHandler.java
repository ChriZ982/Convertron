package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.io.*;
import java.nio.file.*;

/**
 * Mit dieser Klasse werden Datiene verwaltet.
 */
public class FileHandler
{
    /**
     * Die Datei zum lesen und schreiben.
     */
    private File file;

    /**
     * Erstellt einen FileHandler.
     *
     * @param path Pfad zur Datei inklusive Dateiname
     */
    public FileHandler(String path)
    {
        this(new File(path));
    }

    /**
     * Erstellt einen FileHandler.
     *
     * @param file Datei, die genutzt werden soll
     */
    public FileHandler(File file)
    {
        this.file = file;
    }

    /**
     * Erstellt eine neue Datei.
     *
     * @throws java.lang.Exception Fehler
     */
    public void create() throws Exception
    {
        file.getParentFile().mkdirs();
        if(file.createNewFile())
            Logger.log("\"" + file.getName() + "\" wurde erstellt.", 0);
    }

    /**
     * Löscht eine bestehende Datei.
     *
     * @throws java.lang.Exception Fehler
     */
    public void delete() throws Exception
    {
        if(file.delete())
            Logger.log("\"" + file.getName() + "\" wurde gelöscht.", 0);
    }

    /**
     * Prüft ob die Datei existiert.
     *
     * @return Existiert die Datei?
     *
     * @throws java.lang.Exception Fehler
     */
    public boolean exists() throws Exception
    {
        return file.isFile() && file.exists();
    }

    /**
     * Kopiert eine Datei zu einem Pfad.
     *
     * @param dest Ziel-Pfad
     *
     * @throws java.lang.Exception Fehler
     */
    public void copy(String dest) throws Exception
    {
        if(exists())
        {
            new File(dest).mkdirs();
            Files.copy(Paths.get(file.getPath()), Paths.get(dest + file.getName()), StandardCopyOption.REPLACE_EXISTING);
            Logger.log(file.getName() + " wurde kopiert", 0);
        }
    }

    /**
     * Kopiert Dateien aus dem Java-Package der Facharbeit.
     *
     * @param dest Ziel-Pfad
     *
     * @throws java.lang.Exception Fehler
     */
    public void copyFromRes(String dest) throws Exception
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

    /**
     * Gibt die Zeilenanzahl zurück.
     *
     * @return Anzahl der Zeilen
     *
     * @throws java.lang.Exception Fehler
     */
    public int length() throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
        int lines = 0;
        while(reader.readLine() != null)
            lines++;
        reader.close();
        return lines;
    }

    /**
     * Liest eine Zeile der Datei.
     *
     * @param lineNumber Zeile, die gelesen werden soll
     *
     * @return Inhalt dieser Zeile
     *
     * @throws java.lang.Exception Fehler
     */
    public String read(int lineNumber) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
        for(int i = 0; i < lineNumber; i++)
            reader.readLine();
        String line = reader.readLine();
        reader.close();
        return line;
    }

    /**
     * Liest ganze Datei aus.
     *
     * @return Ganze Datei als String Array
     *
     * @throws java.lang.Exception Fehler
     */
    public String[] read() throws Exception
    {
        int length = length();
        String[] text = new String[length];
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"));
        for(int i = 0; i < length; i++)
            text[i] = reader.readLine();
        reader.close();
        return text;
    }

    /**
     * Konvertiert die Datei in einen einzelnen String.
     *
     * @return Ganze Datei als String
     *
     * @throws java.lang.Exception Fehler
     */
    public String asString() throws Exception
    {
        String asString = "";
        String[] text = read();
        for(int i = 0; i < text.length - 1; i++)
            asString += text[i] + "\n";
        return asString.trim();
    }

    /**
     * Schreibt eine ganze Datei neu.
     *
     * @param text Daten, die in die Datei geschrieben werder sollen
     *
     * @throws java.lang.Exception Fehler
     */
    public void write(String[] text) throws Exception
    {
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "ISO-8859-1"));
        for(int i = 0; i < text.length; i++)
        {
            if(i + 1 < text.length)
                writer.println(text[i]);
            else
                writer.print(text[i]);
        }
        writer.close();
    }

    /**
     * Schreibt nur eine Zeile einer Datei neu.
     *
     * @param lineNumber Zeile, die neu geschrieben werden soll
     * @param text       Text, der geschrieben werden soll
     *
     * @throws java.lang.Exception Fehler
     */
    public void write(int lineNumber, String text) throws Exception
    {
        String[] oldText = read();
        String[] newText;
        if(lineNumber + 1 > oldText.length)
            newText = new String[lineNumber + 1];
        else
            newText = new String[oldText.length];

        for(int i = 0; i < newText.length; i++)
        {
            if(i < oldText.length)
                newText[i] = oldText[i];
            else
                newText[i] = "";
        }
        newText[lineNumber] = text;
        write(newText);
    }
}
