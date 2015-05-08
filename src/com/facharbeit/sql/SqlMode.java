package com.facharbeit.sql;

/**
 * Die verschiedenen SQL-Modi.
 */
public enum SqlMode
{
    READ,
    ADD,
    OVERWRITE;

    /**
     * Prüft ob der Modus der aktuelle Modus ist.
     *
     * @return Ist dieser Modus gerade aktiv?
     *
     * @throws Exception
     */
    public boolean isActive() throws Exception
    {
        return com.facharbeit.io.Settings.load("sqlMode").equals(this.toString());
    }
}
