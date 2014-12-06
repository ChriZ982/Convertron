package com.facharbeit.main;

import com.facharbeit.tools.Logger;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 * Verwaltet die Aktionen des Fensters.
 */
public class FrameActions implements WindowListener
{
    /**
     * Frame das beobachtet wird.
     */
    JFrame frame;

    /**
     * Initialisiert den Beobachter.
     *
     * @param frame Zu beobachtendes Fenster
     */
    public FrameActions(JFrame frame)
    {
        this.frame = frame;
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        try
        {
            frame.setVisible(false);
        } catch(Exception ex)
        {
            Logger.log("Fehler beim Minimieren", 2);
            Logger.error(ex);
        }
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
    }
}
