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
    DiscardLocal,

    /**
     * Der Benutzer wird gefragt was passieren soll.
     * Wird dies nicht unterstützt (zB beim Server) wird OverwriteGlobal angewandt.
     */
    Ask_DefaultOverwriteGlobal,

    /**
     * Der Benutzer wird gefragt was passieren soll.
     * Wird dies nicht unterstützt (zB beim Server) wird DiscardLocal angewandt.
     */
    Ask_DefaultDiscardLocal
}
