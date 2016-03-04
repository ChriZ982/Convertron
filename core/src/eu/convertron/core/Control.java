package eu.convertron.core;

import eu.convertron.core.data.CsvStorage;
import eu.convertron.core.data.Storage;
import eu.convertron.core.settings.CoreSettings;
import eu.convertron.core.tabs.modules.ModuleControl;
import eu.convertron.core.tabs.overview.OverviewControl;
import eu.convertron.core.tabs.settings.SettingsControl;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.io.Folder;
import eu.convertron.interlib.io.ResourceFile;
import eu.convertron.interlib.logging.LogFile;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.logging.messages.LogPriority;
import eu.convertron.interlib.settings.SettingLocation;
import java.awt.EventQueue;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Verwaltet alle Aktionen, die im Programm geschehen sollen.
 */
public class Control
{
    /**
     * Das Fenster des Programms.
     */
    private static Window window;

    private static OverviewControl overview;
    private static SettingsControl settings;
    private static ModuleControl moduleManager;

    private static Storage storage;

    /**
     * Das Symbol der Anwendung im Tray.
     */
    private static TrayIcon trayIcon;

    private static Timer autoTimer;

    /**
     * Ruft die "main-Methode" der Anwendung auf.
     *
     * @param args Parameter, die beim Aufruf des Programms übergeben wurden
     */
    public static void main(String[] args)
    {
        try
        {
            setFileEncoding("UTF-8");
            Logger.addLogOutput(new LogFile());

            setJavaLookAndFeel();

            copyFilesFromPackage();

            initializeStorage();

            createAndFillWindow();

            loadWindowPosition();

            initTray();

            initAutoTimer();

            Logger.logMessage(LogPriority.HINT, "Anwendung gestartet");
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim initialisieren der Anwendung", ex);
            StringWriter writer = new StringWriter();
            ex.printStackTrace(new PrintWriter(writer));
            JOptionPane.showMessageDialog(null,
                                          "Fehler beim initialisieren der Anwendung!\n"
                                          + writer.toString(),
                                          "Schwerwiegender Fehler",
                                          JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
    }

    private static void setJavaLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
        {
            Logger.logError(LogPriority.ERROR, "Das Design der Anwendung konnte nicht geändert werden", ex);
        }
    }

    private static void initializeStorage()
    {
        storage = new CsvStorage();
    }

    private static void initAutoTimer()
    {
        autoTimer = new Timer(60000,
                              (ActionEvent e)
                              ->
                              {
                                  if(CoreSettings.autoMode.load().equals("true"))
                                      genAll();
                      });
        autoTimer.start();
    }

    private static void createAndFillWindow()
    {
        window = new Window();

        overview = new OverviewControl();
        settings = new SettingsControl();
        moduleManager = new ModuleControl();

        window.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }

            @Override
            public void windowIconified(WindowEvent e)
            {
                if(trayIcon != null)
                {
                    window.setVisible(false);
                }
            }
        });

        window.setVisible(true);
        Logger.logMessage(LogPriority.INFO, "Fenster wurde erstellt und gefüllt");
    }

    private static void setFileEncoding(String charsetName)
    {
        try
        {
            if(Charset.isSupported(charsetName))
            {
                System.setProperty("file.encoding", charsetName);
                Logger.logMessage(LogPriority.INFO, "File Encoding wurde konfiguriert");
            }
            else
            {
                throw new UnsupportedCharsetException(charsetName);
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Das File Encoding konnte nicht auf ISO-8859-1 umgestellt werden.\n"
                                                + "Es kann zu Anzeigeproblemen kommen.\n"
                                                + "Bitte prüfen Sie die Sicherheitseinstellungen und installierte Charsets.",
                                          "Warnung", JOptionPane.OK_OPTION);
        }
    }

    /**
     * Initialisiert den Data-Ordner.
     */
    private static void copyFilesFromPackage()
    {
        String destPath = CoreSettings.pathData.load();
        copyFileFromPackage("antonianumLogo.png", destPath);
        copyFileFromPackage("template - style.txt", destPath);
        copyFileFromPackage("VERTRETUNGSPLAN.html", destPath);
        copyFileFromPackage("template - motd.txt", destPath);
        copyFileFromPackage("template - day.txt", destPath);
        copyFileFromPackage("template - class.txt", destPath);
        copyFileFromPackage("template - lesson.txt", destPath);
        copyFileFromPackage("design.xml", destPath);

        Logger.logMessage(LogPriority.INFO, "Alle Dateien wurden erstellt oder überprüft");
    }

    private static void copyFileFromPackage(String fileName, String destPath)
    {
        ResourceFile resourceFile = new ResourceFile(Resources.RESOURCEPATH + "stdData", fileName, Control.class);
        resourceFile.copyIfNotExists(destPath);
    }

    public static void loadWindowPosition()
    {
        String x = CoreSettings.positionX.load();
        String y = CoreSettings.positionY.load();
        try
        {
            window.setLocation(Integer.parseInt(x), Integer.parseInt(y));
            Logger.logMessage(LogPriority.INFO, "Fenster Position wurde geladen");
        }
        catch(NumberFormatException ex)
        {
            Logger.logMessage(LogPriority.INFO, "Fenster Position konnte nicht geladen werden");
        }
    }

    /**
     * Initialisiert den Tray.
     */
    private static void initTray()
    {
        trayIcon = null;
        try
        {
            if(SystemTray.isSupported())
            {
                SystemTray tray = SystemTray.getSystemTray();

                BufferedImage icon = ImageIO.read(Resources.get("trayLogo.png"));
                trayIcon = new TrayIcon(icon);

                PopupMenu popup = new PopupMenu();

                initTrayMenuItem("Alles generieren", popup,
                                 ()
                                 ->
                                 {
                                     Control.genAll();
                         });

                initTrayMenuItem("Backup erstellen", popup,
                                 ()
                                 ->
                                 {
                                     Control.createBackup();
                         });

                popup.addSeparator();

                initTrayMenuItem("Maximieren", popup,
                                 (java.awt.event.ActionEvent evt)
                                 ->
                                 {
                                     window.setExtendedState(JFrame.NORMAL);
                                     window.setVisible(true);
                                     window.toFront();
                                     window.requestFocus();
                         });

                initTrayMenuItem("Minimieren", popup,
                                 (java.awt.event.ActionEvent evt)
                                 ->
                                 {
                                     window.setVisible(false);
                         });

                popup.addSeparator();

                initTrayMenuItem("Beenden", popup,
                                 (java.awt.event.ActionEvent evt)
                                 ->
                                 {
                                     Control.exit();
                         });

                trayIcon.setPopupMenu(popup);
                trayIcon.setToolTip("Vertretungsplan-Generator");

                trayIcon.addActionListener((ActionEvent e)
                        ->
                        {
                            window.setExtendedState(JFrame.NORMAL);
                            window.setVisible(true);
                            window.toFront();
                            window.requestFocus();
                });

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
    }

    private static void initTrayMenuItem(String text, PopupMenu menu, Runnable task)
    {
        initTrayMenuItem(text, menu,
                         (ActionEvent e)
                         ->
                         {
                             EventQueue.invokeLater(task);
                 });
    }

    private static void initTrayMenuItem(String text, PopupMenu menu, ActionListener listener)
    {
        MenuItem item = new MenuItem(text);
        item.addActionListener(listener);

        menu.add(item);
    }

    /**
     * Beendet das Programm.
     */
    public static void exit()
    {
        try
        {
            autoTimer.stop();
            //ToDo Exit Tabs -> Pending Changes?!

            CoreSettings.positionX.save(String.valueOf((int)window.getLocation().getX()));
            CoreSettings.positionY.save(String.valueOf((int)window.getLocation().getY()));

            if(trayIcon != null)
                SystemTray.getSystemTray().remove(trayIcon);

            window.dispose();
            System.exit(0);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim Beenden", ex);
            System.exit(-1);
        }
    }

    public static void addViewToWindow(View view)
    {
        if(window != null)
            window.addTab(view);
    }

    public static void genAll()
    {
        if(CoreSettings.autoBackup.load().equals("true"))
            createBackup();

        if(CoreSettings.autoImport.load().equals("true"))
            importLessons();

        if(CoreSettings.autoExport.load().equals("true"))
            exportLessonsAndMotd();
    }

    public static void importLessons()
    {
        Lesson[] in = moduleManager.importLessons();
        if(in != null)
        {
            storage.save(TableOptions.compress(in));
            Logger.logMessage(LogPriority.HINT, "Vertretungseinträge aktualisiert");
        }
        else
        {
            Logger.logMessage(LogPriority.INFO, "Import lieferte keine neuen Vertretungeinträge, keine Änderungen vorgenommen");
        }
    }

    public static void exportLessonsAndMotd()
    {
        moduleManager.exportLessons(storage.load());

        moduleManager.exportMotd(CoreSettings.motdText.load());

        Logger.logMessage(LogPriority.HINT, "Exportieren abgeschlossen");
    }

    public static void createBackup()
    {
        try
        {
            String backupPath = CoreSettings.pathBackup.load();
            new Folder(CoreSettings.pathData.load()).copyContent(backupPath);
            SettingLocation.LOCAL.getFile().copy(backupPath);
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Fehler beim erstellen eines Backups", ex);
        }
    }
}
