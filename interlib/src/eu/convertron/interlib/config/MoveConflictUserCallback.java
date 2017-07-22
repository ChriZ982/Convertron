package eu.convertron.interlib.config;

public interface MoveConflictUserCallback
{
    public byte[] resolveConflict(String module, String configName, byte[] localVersion, byte[] globalVersion);
}
