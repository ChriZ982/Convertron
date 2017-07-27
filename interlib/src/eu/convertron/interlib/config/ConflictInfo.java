package eu.convertron.interlib.config;

public class ConflictInfo
{
    private final String module;
    private final String configName;
    private final byte[] localVersion;
    private final byte[] globalVersion;

    public ConflictInfo(String module, String configName, byte[] localVersion, byte[] globalVersion)
    {
        this.module = module;
        this.configName = configName;
        this.localVersion = localVersion;
        this.globalVersion = globalVersion;
    }

    public String getModule()
    {
        return module;
    }

    public String getConfigName()
    {
        return configName;
    }

    public byte[] getLocalVersion()
    {
        return localVersion;
    }

    public byte[] getGlobalVersion()
    {
        return globalVersion;
    }
}
