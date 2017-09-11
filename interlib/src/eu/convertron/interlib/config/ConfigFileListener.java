package eu.convertron.interlib.config;

public interface ConfigFileListener
{
    public abstract void configFileChanged(ConfigFileChangeInfo changeInfo);
}
