package eu.convertron.interlib.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/** Zeigt verschiedene Informationen und Einstellungen an. */
@SuppressWarnings("serial")
public abstract class View extends JPanel
{
    /**
     * Die Überschrift für den Tab
     * @return Überschrift
     */
    public abstract String getTabTitle();

    /**
     * Konvertier eine Runnable zu einer Action um diese später auszuführen.
     * @param task Aufgabe
     * @return Ausführmöglichkeit der Aufgabe
     */
    protected ActionListener getActionListenerToRunnable(Runnable task)
    {
        return (ActionEvent e) ->
        {
            EventQueue.invokeLater(task);
        };
    }
}
