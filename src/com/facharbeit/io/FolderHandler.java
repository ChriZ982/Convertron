package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.io.File;
import java.io.IOException;
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
     *
     * @throws java.io.IOException
     *
     *
     */
    public void copyContent(String dest) throws IOException
    {
        Iterator it = Files.list(Paths.get(file.getPath())).iterator();
        Logger.enable(false);
        while(it.hasNext())
            new FileHandler(String.valueOf(it.next())).copy(dest);
        Logger.enable(true);
        Logger.log("\"" + file.getName() + "\" kopiert", 0);
    }

    /**
     * Löscht den Inhalt des Ordners.
     *
     *
     * @throws java.io.IOException
     */
    public void deleteContent() throws IOException
    {
        if(!exists())
            return;
        Iterator it = Files.list(Paths.get(file.getPath())).iterator();
        Logger.enable(false);
        while(it.hasNext())
            new FileHandler(String.valueOf(it.next())).delete();
        Logger.enable(true);
        Logger.log("\"" + file.getName() + "\" gelöscht", 0);
    }

    /**
     * Prüft ob der Ordner existiert.
     *
     * @return Existiert er?
     *
     *
     */
    public boolean exists()
    {
        return file.isDirectory() && file.exists();
    }

    /**
     * Prüft ob der Ordner leer ist.
     *
     * @return Ist er leer?
     *
     * @throws java.io.IOException
     *
     *
     */
    public boolean isEmpty() throws IOException
    {
        return !exists() || !Files.list(Paths.get(file.getPath())).iterator().hasNext();
    }
}
