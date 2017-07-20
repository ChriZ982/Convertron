package eu.convertron.interlib.interfaces;

import eu.convertron.interlib.Lesson;

public interface Input extends Module
{
    /**
     * Liest die Vertretungeinträge ein. Die eingelesen Vertretungeinträge überschreiben die Vorhandenen.
     * Wenn null zurückgegeben wird, bleiben die vorhandenen Vertretungeinträge unangestastet.
     * @return Die neuen Vertretungeinträge oder <code>null</code> wenn keine Änderung festgestellt werden konnte
     */
    public Lesson[] in();
}
