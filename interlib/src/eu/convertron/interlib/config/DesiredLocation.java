package eu.convertron.interlib.config;

public enum DesiredLocation
{
    /**
     * Existiert die Config-File bereits, wird diese verwendet, ansonsten wird sie lokal erstellt.
     */
    Local,

    /**
     * Existiert die Config-File bereits, wird diese verwendet, ansonsten wird sie global erstellt.
     */
    Global,

    /**
     * Die Config-File wird lokal erstellt, existiert eine globale Config-File wird diese lokal übernommen.
     */
    ForceLocal,

    /**
     * Die Config-File wird global erstellt, existiert eine lokale Config-File wird diese global übernommen.
     */
    ForceGlobalAndOverrideExisting,

    /**
     * Die Config-File wird global erstellt, exisitert eine lokale Config-File wird diese verworfen.
     */
    ForceGlobalAndDiscardLocal
}
