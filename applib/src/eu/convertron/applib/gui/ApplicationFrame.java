package eu.convertron.applib.gui;

import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public abstract class ApplicationFrame extends JFrame
{
    private static final long serialVersionUID = 7773116682310690513L;
    protected TrayIcon trayIcon;

    public static MenuItem createMenuItem(String text, ActionListener listener)
    {
        MenuItem item = new MenuItem(text);
        item.addActionListener(listener);
        return item;
    }

    public ApplicationFrame()
    {
    }

    public ApplicationFrame(URL trayLocation, String trayToolTip, MenuItem... additionalMenuItems)
    {
        this();
        init(trayLocation, trayToolTip, additionalMenuItems);
    }

    protected void init(URL trayLocation, String trayToolTip, MenuItem... additionalMenuItems)
    {
        trayIcon = initTray(trayLocation, trayToolTip, additionalMenuItems);
        appendWindowListener(trayIcon != null);
    }

    private TrayIcon initTray(URL trayLocation, String trayToolTip, MenuItem... additionalMenuItems)
    {
        try
        {
            if(SystemTray.isSupported())
            {
                SystemTray tray = SystemTray.getSystemTray();
                TrayIcon result = new TrayIcon(ImageIO.read(trayLocation));
                PopupMenu popup = new PopupMenu();

                for(MenuItem item : additionalMenuItems)
                {
                    if(item == null)
                        popup.addSeparator();
                    else
                        popup.add(item);
                }

                popup.addSeparator();
                popup.add(createMenuItem("Maximieren", (e) -> showFrame()));
                popup.add(createMenuItem("Minimieren", (e) -> hideFrame()));
                popup.addSeparator();
                popup.add(createMenuItem("Beenden", (e) -> exit()));

                result.setPopupMenu(popup);
                result.setToolTip(trayToolTip);
                result.addActionListener((e) -> showFrame());

                tray.add(result);
                return result;
            }
            else
            {
                Logger.logMessage(LogPriority.INFO, "Das Betriebssystem unterstützt kein Tray, "
                                                    + "es wurde kein Tray initialisiert");
            }
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Tray konnte nicht initialisiert werden", ex);
        }
        return null;
    }

    private void appendWindowListener(boolean minimizeToTray)
    {
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }

            @Override
            public void windowIconified(WindowEvent e)
            {
                if(minimizeToTray)
                {
                    hideFrame();
                }
            }
        });
    }

    public void showFrame()
    {
        setExtendedState(JFrame.NORMAL);
        setVisible(true);
        toFront();
        requestFocus();
    }

    public void hideFrame()
    {
        setVisible(false);
    }

    public abstract void exit();
}
