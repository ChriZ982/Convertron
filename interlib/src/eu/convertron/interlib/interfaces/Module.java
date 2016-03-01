package eu.convertron.interlib.interfaces;

public interface Module
{
    /**
     * Gibt die Einstellungsseite des Modules zurück. Dieses wird automatisch den Tabs im Fenster hinzugefügt.
     * Wenn <code>null</code> zurückgegeben wird, wird kein Fenster hinzugefügt
     * @return Einstellungsseite oder <code>null</code> wenn es keine gibt
     */
    public View getView();

    /**
     * Gibt den Namen des Modules. Dieser wird dann im Module aktivieren/deaktivieren Tab angezeigt.
     * @return Name des Modules
     */
    public String getName();
}
