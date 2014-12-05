package com.facharbeit.main;

import java.awt.event.*;
import javax.swing.*;

public class FrameActions implements WindowListener
{
    JFrame frame;

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
        frame.setVisible(false);
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
    }
}