package converter.io;

import converter.util.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Mit dieser Klasse werden Ordner verwaltet.
 */
public class Folder
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
    public Folder(String path)
    {
        this(new File(path));
    }

    /**
     * Erstellt einen FolderHandler.
     *
     * @param file File, das genutzt werden soll
     */
    public Folder(File file)
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
        while(it.hasNext())
            new FileTMP(String.valueOf(it.next())).copy(dest);
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
        while(it.hasNext())
            new File(String.valueOf(it.next())).delete();
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
