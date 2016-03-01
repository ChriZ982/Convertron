package eu.convertron.interlib.io;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;

/** Bildet das Grundgerüst für alle Datei- und Ordner-Operationen. */
public abstract class GeneralData
{
    /** Pfad zu den Daten. */
    private Path path;

    /**
     * Kontruktor.
     * @param path Pfad zu den Daten
     */
    protected GeneralData(File path)
    {
        this(path.toPath());
    }

    /**
     * Kontruktor.
     * @param path Pfad zu den Daten
     */
    protected GeneralData(URI path)
    {
        this(Paths.get(path));
    }

    /**
     * Kontruktor.
     * @param path Pfad zu den Daten
     */
    protected GeneralData(String path)
    {
        this(Paths.get(path));
    }

    /**
     * Kontruktor.
     * @param folder   Ordner der Daten
     * @param fileName Dateiname der Daten
     */
    protected GeneralData(String folder, String fileName)
    {
        this(Paths.get(folder + "/" + fileName));
    }

    /**
     * Kontruktor.
     * @param path Pfad zu den Daten
     */
    protected GeneralData(Path path)
    {
        this.path = Paths.get(getNormalizedPath(path));
    }

    /**
     * Sorgt dafür, dass der Pfad keine Logik- oder Tippfehler enthält.
     * @param pathToNormalize Pfad, der überarbeitet wird
     * @return Überarbeiteter Pfad
     */
    public String getNormalizedPath(Path pathToNormalize)
    {
        String pathAsString = pathToNormalize.toString();
        pathAsString = pathAsString.replaceAll("\\\\", "/");
        pathAsString = pathAsString.replaceAll("/+", "/");
        return pathAsString;
    }

    /**
     * Gets Filename.
     * @return Filename
     */
    public String getFileName()
    {
        return path.getFileName().toString();
    }

    /**
     * Gets Path.
     * @return Path
     */
    public Path getPath()
    {
        return path;
    }

    /**
     * Gets Path as String.
     * @return Path as String
     */
    public String getPathString()
    {
        return path.toString();
    }
}
