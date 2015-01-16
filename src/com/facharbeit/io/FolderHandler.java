package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.io.File;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Mit dieser Klasse werden Ordner verwaltet.
 */
public class FolderHandler
{
    /**
     * File das den Ordner enthält.
     */
    private File file;

    /**
     * Erstellt einen FolderHandler.
     *
     * @param path Pfad des Ordners.
     */
    public FolderHandler(String path)
    {
        this(new File(path));
    }

    /**
     * Erstellt einen FolderHandler.
     *
     * @param file File, das genutzt werden soll
     */
    public FolderHandler(File file)
    {
        this.file = file;
    }

    /**
     * Kopiert den Inhalt des Ordners.
     *
     * @param dest Zielpfad
     */
    public void copyContent(String dest)
    {
        try
        {
            Iterator it = Files.list(Paths.get(file.getPath())).iterator();
            Logger.setLogging(false);
            while(it.hasNext())
                new FileHandler(String.valueOf(it.next())).copy(dest);
            Logger.setLogging(true);
            Logger.log("\"" + file.getName() + "\" kopiert", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Konnte \"" + file.getName() + "\" nicht kopieren!", 2);
            Logger.error(ex);
        }
    }

    /**
     * Löscht den Inhalt des Ordners.
     */
    public void deleteContent()
    {
        try
        {
            if(!exists())
                return;
            Iterator it = Files.list(Paths.get(file.getPath())).iterator();
            while(it.hasNext())
                new FileHandler(String.valueOf(it.next())).delete();
            Logger.log("\"" + file.getName() + "\" gelöscht", 0);
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht gelöscht werden!", 2);
            Logger.error(ex);
        }
    }

    /**
     * Prüft ob der Ordner existiert.
     *
     * @return Existiert er?
     */
    public boolean exists()
    {
        try
        {
            return file.isDirectory() && file.exists();
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht geprüft werden", 2);
            Logger.error(ex);
            return false;
        }
    }

    /**
     * Prüft ob der Ordner leer ist.
     *
     * @return Ist er leer?
     */
    public boolean isEmpty()
    {
        try
        {
            return !exists() || !Files.list(Paths.get(file.getPath())).iterator().hasNext();
        }
        catch(Exception ex)
        {
            Logger.log("Konnte \"" + file.getName() + "\" nicht auf Inhalt prüfen!", 2);
            Logger.error(ex);
            return true;
        }
    }
}
