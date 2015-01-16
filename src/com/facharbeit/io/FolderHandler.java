package com.facharbeit.io;

import com.facharbeit.tools.Logger;
import java.io.File;
import java.nio.file.*;
import java.util.Iterator;

public class FolderHandler
{
    private File file;

    public FolderHandler(String path)
    {
        this(new File(path));
    }

    public FolderHandler(File file)
    {
        this.file = file;
    }

    public void copyContent(String dest)
    {
        try
        {
            Iterator it = Files.list(Paths.get(file.getPath())).iterator();
            while(it.hasNext())
            {
                new FileHandler(String.valueOf(it.next())).copy(dest, false);
            }
            Logger.log("\"" + file.getName() + "\" kopiert", 0);
        }
        catch(Exception ex)
        {
            Logger.log("Konnte \"" + file.getName() + "\" nicht kopieren!", 2);
            Logger.error(ex);
        }
    }

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

    public void delete()
    {
        try
        {
            if(!exists())
                return;

            Iterator it = Files.list(Paths.get(file.getPath())).iterator();
            while(it.hasNext())
            {
                new FileHandler(String.valueOf(it.next())).delete();
            }
            Logger.log("\"" + file.getName() + "\" gelöscht", 0);
        }
        catch(Exception ex)
        {
            Logger.log("\"" + file.getName() + "\" konnte nicht gelöscht werden!", 2);
            Logger.error(ex);
        }
    }
}
