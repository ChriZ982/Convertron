/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.convertron.applib.storage;

import eu.convertron.interlib.data.Lesson;

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
     * Lädt das Stunden-Array aus dem globalem Zwischenspeicher.
     * @return Das Stunden-Array, welches aus dem Zwischenspeicher geladen wurde
     */
    public Lesson[] load();
}
