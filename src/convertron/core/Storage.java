/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.core;

import interlib.data.Lesson;

/**
 * Das Interface für Storage-Klassen, welche für das Zwischenspeichern von Vertretungsplan-Informationen zuständig ist.
 */
public interface Storage
{
    /**
     * Speichert das Stunden-Array global zwischen.
     * @param lessons Das Stunden-Array, welches gespeichert werden soll
     */
    public void save(Lesson[] lessons);

    /**
     * Speichert der Laufschrift global zwischen.
     * @param motd Die Laufschrift, welche gespeichert werden soll
     */
    public void saveMotd(String motd);

    /**
     * Lädt das Stunden-Array aus dem globalem Zwischenspeicher.
     * @return Das Stunden-Array, welches aus dem Zwischenspeicher geladen wurde
     */
    public Lesson[] load();

    /**
     * Lädt die Laufschrift aus dem globalem Zwischenspeicher.
     * @return Die Laufschrift, welche aus dem Zwischenspeicher geladen wurde
     */
    public String loadMotd();
}
