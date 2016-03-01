package eu.convertron.interlib.interfaces;

import eu.convertron.interlib.data.Lesson;

public interface Output extends Module
{
    /**
     * Verarbeitet die Vertretungeinträge.
     * @param lessons Die Vertretungeinträge, die verarbeitet werden sollen
     */
    public void out(Lesson[] lessons);

    /**
     * Verarbeitet die Laufschrift.
     * @param motd Die Laufschrift, verarbeitet werden soll
     */
    public void motdOut(String motd);
}
