package eu.convertron.applib;

import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.logging.messages.LogPriority;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Mirko Ruether
 */
public class GuiUtil
{
    public static TrayIcon initDefaultTray(ApplicationFrame frame, BufferedImage icon, String tooltip)
    {
        TrayIcon trayIcon = null;
        try
        {
            if(SystemTray.isSupported())
            {
                SystemTray tray = SystemTray.getSystemTray();
                trayIcon = new TrayIcon(icon);
                PopupMenu popup = new PopupMenu();

                popup.addSeparator();
                popup.add(createMenuItem("Maximieren", (e) -> showFrame(frame)));
                popup.add(createMenuItem("Minimieren", (e) -> hideFrame(frame)));
                popup.addSeparator();
                popup.add(createMenuItem("Beenden", (e) -> frame.exit()));

                trayIcon.setPopupMenu(popup);
                trayIcon.setToolTip(tooltip);
                trayIcon.addActionListener((e) -> showFrame(frame));

                tray.add(trayIcon);
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
        return trayIcon;
    }

    private static void showFrame(JFrame frame)
    {
        frame.setExtendedState(JFrame.NORMAL);
        frame.setVisible(true);
        frame.toFront();
        frame.requestFocus();
    }

    private static void hideFrame(JFrame frame)
    {
        frame.setVisible(false);
    }

    public static MenuItem createMenuItem(String text, Runnable task)
    {
        return createMenuItem(text, (e) -> task.run());
    }

    public static MenuItem createMenuItem(String text, ActionListener listener)
    {
        MenuItem item = new MenuItem(text);
        item.addActionListener(listener);
        return item;
    }

    private GuiUtil()
    {
    }
}
