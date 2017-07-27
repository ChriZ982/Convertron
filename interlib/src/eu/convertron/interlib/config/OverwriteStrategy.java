package eu.convertron.interlib.config;

public enum OverwriteStrategy
{
    /**
     * Die globale Config-File wird von der lokalen überschrieben.
     */
    OverwriteGlobal,

    /**
     * Die lokale Config-File wird verworfen, es sei denn es gibt noch keine globale Config-File.
     * In diesem Fall wird die lokale Config-File global übernommen
     */
    DiscardLocal
}
