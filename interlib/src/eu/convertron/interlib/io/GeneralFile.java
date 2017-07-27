package eu.convertron.interlib.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/** Verwaltet, Erstellt und Löscht alle Dateien. */
public class GeneralFile extends GeneralData
{
    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public GeneralFile(File path)
    {
        super(path);
    }

    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public GeneralFile(URI path)
    {
        super(path);
    }

    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public GeneralFile(String path)
    {
        super(path);
    }

    /**
     * Kontruktor.
     * @param folder   Ordner der Daten
     * @param fileName Dateiname der Daten
     */
    public GeneralFile(String folder, String fileName)
    {
        super(folder, fileName);
    }

    /**
     * Kontruktor.
     * @param path Pfad zur Datei
     */
    public GeneralFile(Path path)
    {
        super(path);
    }

    /** Löscht die Datei und erstellt sie neu. */
    public void create()
    {
        delete();
        createIfNotExists();
    }

    /** Löscht die Datei. */
    public void delete()
    {
        try
        {
            Files.deleteIfExists(getPath());
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be deleted", ex);
        }
    }

    /** Erstellt die Ordner zur Datei. */
    public void createDirectories()
    {
        try
        {
            Files.createDirectories(getPath().getParent());
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The directories for the file '" + getPathString() + "' could not be created", ex);
        }
    }

    /** Erstellt die Datei, falls sie nicht existiert. */
    public void createIfNotExists()
    {
        try
        {
            if(exists())
                return;

            createDirectories();
            Files.createFile(getPath());
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be created", ex);
        }
    }

    /**
     * Prüft ob die Datei existiert.
     * @return Existiert sie?
     */
    public boolean exists()
    {
        return Files.isRegularFile(getPath()) && Files.exists(getPath());
    }

    /**
     * Kopiert die Datei zum Zielpfad.
     * @param destination Zielpfad
     */
    public void copy(String destination)
    {
        try
        {
            if(!exists())
                return;

            GeneralFile destinationFile = new GeneralFile(destination, getFileName());
            destinationFile.createDirectories();

            Files.copy(getPath(), destinationFile.getPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be copied to '" + destination + "'", ex);
        }
    }

    /**
     * Gibt den Ordner, in dem sich die Datei befindet.
     * @return Ordner
     */
    public Folder getFolder()
    {
        return new Folder(getPath().getParent());
    }
}
