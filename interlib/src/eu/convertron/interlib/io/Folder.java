package eu.convertron.interlib.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/** Verwaltet, Erstellt und Löscht Ordner. */
public class Folder extends GeneralData
{
    /**
     * Kontruktor.
     * @param path Pfad zum Ordner
     */
    public Folder(File path)
    {
        super(path);
    }

    /**
     * Kontruktor.
     * @param path Pfad zum Ordner
     */
    public Folder(URI path)
    {
        super(path);
    }

    /**
     * Kontruktor.
     * @param path Pfad zum Ordner
     */
    public Folder(String path)
    {
        super(path);
    }

    /**
     * Kontruktor.
     * @param path Pfad zum Ordner
     */
    public Folder(Path path)
    {
        super(path);
    }

    /**
     * Erstellt den Ordner, wenn er nicht vorhanden ist.
     */
    public void createIfNotExists()
    {
        try
        {
            if(exists())
                return;

            Files.createDirectories(getPath());
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The folder '" + getPathString() + "' could not be created", ex);
        }
    }

    /**
     * Löscht den Ordner und erstellt ihn neu.
     */
    public void create()
    {
        delete();
        createIfNotExists();
    }

    /**
     * Löscht den Ordner.
     */
    public void delete()
    {
        try
        {
            if(!exists())
                return;

            deleteContent();
            Files.delete(getPath());
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The folder '" + getPathString() + "' could not be deleted", ex);
        }
    }

    /**
     * Kopiert den Inhalt des Ordners.
     * @param destination Zielpfad
     */
    public void copyContent(String destination)
    {
        try
        {
            if(!exists())
                return;

            for(GeneralFile file : getContent())
                file.copy(destination);
        }
        catch(Exception ex)
        {
            throw new RuntimeException("The folder '" + getPathString() + "' could not be copied to '" + destination + "'", ex);
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

            for(GeneralFile file : getContent())
                file.delete();
        }
        catch(Exception ex)
        {
            throw new RuntimeException("The folder '" + getPathString() + "' could not be deleted", ex);
        }
    }

    /**
     * Prüft ob der Ordner existiert.
     * @return Existier der Ordner?
     */
    public boolean exists()
    {
        return Files.isDirectory(getPath()) && Files.exists(getPath());
    }

    /**
     * Gibt alle Dateien des Ordners zurück.
     * @return Alle Dateien des Ordners
     */
    public ArrayList<GeneralFile> getContent()
    {
        try
        {
            Object[] pathObjects = Files.list(getPath()).toArray();
            ArrayList<GeneralFile> paths = new ArrayList<GeneralFile>();

            for(Object pathObject : pathObjects)
                paths.add(new GeneralFile((Path)pathObject));

            return paths;
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The content of the folder '" + getPath().toString() + "' could not be found", ex);
        }
    }

    /**
     * Gibt den übergeordneten Ordner zurück.
     * @return Parent Folder
     */
    public Folder getParent()
    {
        return new Folder(getPath().getParent());
    }

    /**
     * Erstellt einen Unterordner.
     * @param name Name des Unterordners
     * @return Den Unterordner
     */
    public Folder createChild(String name)
    {
        Folder child = new Folder(getPath().getFileName() + "/" + name);
        child.createIfNotExists();
        return child;
    }
}
