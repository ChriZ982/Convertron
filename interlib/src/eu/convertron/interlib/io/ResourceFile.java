package eu.convertron.interlib.io;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/** Bildet Daten aus dem Java Archiv ab. */
public class ResourceFile extends GeneralData
{
    private Class<?> parentObject;

    /**
     * Kontruktor.
     * @param path         Pfad zur Datei
     * @param parentObject Objekt das zum lokaliesieren der Ressource genutzt werden soll
     */
    public ResourceFile(File path, Class<?> parentObject)
    {
        super(path);
        this.parentObject = parentObject;
    }

    /**
     * Kontruktor.
     * @param path         Pfad zur Datei
     * @param parentObject Objekt das zum lokaliesieren der Ressource genutzt werden soll
     */
    public ResourceFile(URI path, Class<?> parentObject)
    {
        super(path);
        this.parentObject = parentObject;
    }

    /**
     * Kontruktor.
     * @param path         Pfad zur Datei
     * @param parentObject Objekt das zum lokaliesieren der Ressource genutzt werden soll
     */
    public ResourceFile(String path, Class<?> parentObject)
    {
        super(path);
        this.parentObject = parentObject;
    }

    /**
     * Kontruktor.
     * @param folder       Ordner der Datei
     * @param fileName     Dateiname der Datei
     * @param parentObject Objekt das zum lokaliesieren der Ressource genutzt werden soll
     */
    public ResourceFile(String folder, String fileName, Class<?> parentObject)
    {
        super(folder, fileName);
        this.parentObject = parentObject;
    }

    /**
     * Kopiert die Datei, wenn sie nicht bereits im Zielverzeichnis existiert.
     * @param destination Zielpfad
     */
    public void copyIfNotExists(String destination)
    {
        try
        {
            GeneralFile destinationFile = new GeneralFile(destination, getFileName());
            if(destinationFile.exists())
                return;

            destinationFile.createDirectories();

            Files.copy(parentObject.getResourceAsStream(getNormalizedPath(getPath())),
                       destinationFile.getPath(),
                       StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException ex)
        {
            throw new RuntimeException("The file '" + getPathString() + "' could not be copied to '" + destination + "'", ex);
        }
    }
}
