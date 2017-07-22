package eu.convertron.core;

import eu.convertron.applib.LogFile;
import eu.convertron.applib.gui.ApplicationFrame;
import eu.convertron.core.tabs.ModuleControl;
import eu.convertron.core.tabs.ModuleImportControl;
import eu.convertron.core.tabs.OverviewControl;
import eu.convertron.core.tabs.SettingsControl;
import eu.convertron.core.tabs.SystemSettingsControl;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.util.SubTabView;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Anzeige-Fenster der Anwendung.
 */
public class Window extends ApplicationFrame
{
    /**
     * Zufallsgenerierter Schlüssel
     */
    private static final long serialVersionUID = 1841024231;

    private final OverviewControl overviewControl;
    private final SettingsControl settingsControl;
    private final SystemSettingsControl systemSettingsControl;
    private final ModuleControl moduleControl;
    private final ModuleImportControl moduleImportControl;

    private final Control control;

    /**
     * Erstellt ein neues Fenster.
     *
     *
     * @param control
     * @param exitListener
     * @param trayImg
     * @param trayToolTip
     * @param additionalMenuItems
     * @throws java.io.IOException
     */
    public Window(Control control)
    {
        this.control = control;
        overviewControl = new OverviewControl(control);
        systemSettingsControl = new SystemSettingsControl(this);
        settingsControl = new SettingsControl(control.getCoreConfig());
        moduleControl = new ModuleControl(control.getModuleManager());
        moduleImportControl = new ModuleImportControl(control.getModuleManager(), this);

        super.init(Resources.get("trayLogo.png"), "Vertretungsplan-Generator Client",
                   createMenuItem("Alles generieren", (e) -> control.genAll()),
                   createMenuItem("Backup erstellen", (e) -> control.createBackup()),
                   null,
                   createMenuItem("Plan importieren", (e) -> control.importLessons()),
                   createMenuItem("Plan exportieren", (e) -> control.export()));

        initComponents();

        addTab(overviewControl.getView());
        addTab(systemSettingsControl.getView());
        addTab(settingsControl.getView());
        addTab(new SubTabView("Module", moduleControl.getView(), moduleImportControl.getView()));

        addTabs(moduleControl.getModuleViews());

        loadPos();
        Logger.logMessage(LogPriority.HINT, "Fenster erstellt und gefüllt");
    }

    @Override
    public void exit()
    {
        CoreSettings.positionX.save(String.valueOf((int)this.getLocation().getX()));
        CoreSettings.positionY.save(String.valueOf((int)this.getLocation().getY()));

        System.exit(control.stop() ? 0 : -1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        tabsPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vertretungsplan");

        tabsPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabsPane.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(tabsPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addTabs(Collection<? extends View> views)
    {
        for(View view : views)
            addTab(view);
    }

    public void addTab(View view)
    {
        View.invokeLater(()
                ->
        {
            tabsPane.add(view);
            tabsPane.setTitleAt(tabCount() - 1, view.getTabTitle());
        });
    }

    private int tabCount()
    {
        return tabsPane.getTabCount();
    }

    private void loadPos()
    {
        String x = CoreSettings.positionX.load();
        String y = CoreSettings.positionY.load();
        try
        {
            setLocation(Integer.parseInt(x), Integer.parseInt(y));
            Logger.logMessage(LogPriority.INFO, "Fenster Position wurde geladen");
        }
        catch(NumberFormatException ex)
        {
            Logger.logMessage(LogPriority.INFO, "Fenster Position konnte nicht geladen werden");
        }
    }

    public static void main(String[] args)
    {
        try
        {
            System.setProperty("file.encoding", StandardCharsets.UTF_8.name());
            Logger.addLogOutput(new LogFile());
            setLookAndFeel();
            Control c = new Control();
            View.invokeAndWait(()
                    ->
            {
                new Window(c).setVisible(true);
            });
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

    private static void setLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Logger.logMessage(LogPriority.INFO, "Look and Feel set to " + UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.WARNING, "Das Design der Anwendung konnte nicht geändert werden", ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabsPane;
    // End of variables declaration//GEN-END:variables
}
