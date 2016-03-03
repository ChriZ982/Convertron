package eu.convertron.core;

import eu.convertron.applib.ApplicationFrame;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import java.awt.MenuItem;

/**
 * Anzeige-Fenster der Anwendung.
 */
public class Window extends ApplicationFrame
{
    /**
     * Zufallsgenerierter Schlüssel
     */
    private static final long serialVersionUID = 1841024231;

    /**
     * Erstellt ein neues Fenster.
     *
     *
     * @param exitListener
     * @param trayImg
     * @param trayToolTip
     * @param additionalMenuItems
     * @throws java.io.IOException
     */
    public Window()
    {
        super(Resources.get("trayLogo.png"), "Vertretungsplan-Generator Client",
              new MenuItem[]
              {
                  createMenuItem("Alles generieren", (e) -> Control.genAll()),
                  createMenuItem("Backup erstellen", (e) -> Control.createBackup())
              });
        initComponents();

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

    @Override
    public void exit()
    {
        Control.exit();
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

    public void addTab(View view)
    {
        tabsPane.add(view);
        tabsPane.setTitleAt(tabCount() - 1, view.getTabTitle());
    }

    private int tabCount()
    {
        return tabsPane.getTabCount();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabsPane;
    // End of variables declaration//GEN-END:variables
}
