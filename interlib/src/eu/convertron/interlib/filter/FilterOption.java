package eu.convertron.interlib.filter;

import eu.convertron.interlib.data.Lesson;

/**
 * Die Optionen für die Filter-Klasse.
 */
public interface FilterOption
{
    /**
     * Prüft ob der Vertretungseintrag den Anforderungen des Filters entspricht.
     * @param lesson Der zu prüfende Vertretungseintrag
     * @return <code>true</code>, wenn der Filter die lesson akzeptiert, <code>false</code> wenn nicht
     */
    public boolean accept(Lesson lesson);
}
