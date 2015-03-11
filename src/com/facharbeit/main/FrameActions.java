package com.facharbeit.main;

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
    private JFrame frame;

    /**
     * Anwendung des Fensters.
     */
    private Application app;

    /**
     * Initialisiert den Beobachter.
     *
     * @param frame Zu beobachtendes Fenster
     * @param app   Die Anwendung
     */
    public FrameActions(JFrame frame, Application app)
    {
        this.frame = frame;
        this.app = app;
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
        app.exit();
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
        frame.setVisible(false);
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
    }
}
