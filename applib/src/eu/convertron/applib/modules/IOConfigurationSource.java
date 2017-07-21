package eu.convertron.applib.modules;

import eu.convertron.interlib.config.ConfigurationSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class IOConfigurationSource extends ConfigurationSource
{
    private final File folder;

    public IOConfigurationSource(File folder)
    {
        super(getChilds(folder));
        this.folder = folder;
    }

    @Override
    protected byte[] load(String name) throws IOException
    {
        File f = getFile(name);
        return Files.readAllBytes(f.toPath());
    }

    @Override
    protected void remove(String name) throws IOException
    {
        File f = getFile(name);
        Files.delete(f.toPath());
    }

    @Override
    protected void save(String name, byte[] value) throws IOException
    {
        File f = getFile(name);
        Files.write(f.toPath(), value);
    }

    private File getFile(String name) throws IOException
    {
        File f = new File(folder, name);
        if(!f.exists())
            f.createNewFile();
        return f;
    }

    private static ArrayList<String> getChilds(File f)
    {
        if(!f.isDirectory())
            throw new IllegalArgumentException("You can't initialize an IOConfiguration on a file");

        ArrayList<String> result = new ArrayList<>();
        for(File child : f.listFiles())
        {
            if(child.isFile())
                result.add(child.getName());
        }
        return result;
    }
}
