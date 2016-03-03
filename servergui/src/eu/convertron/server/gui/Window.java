package eu.convertron.server.gui;

import eu.convertron.applib.ApplicationFrame;
import eu.convertron.applib.LogFile;
import eu.convertron.applib.LogPanel;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.server.Control;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class Window extends ApplicationFrame
{
    private static final long serialVersionUID = -1353727408535016989L;

    public Window()
    {
        super(Resources.get("trayLogo.png"), "Convertron Server");
        logPanel = new LogPanel();
        initComponents();
    }

    @Override
    public void exit()
    {
        Control.exit();
    }

    public static void main(String[] args)
    {
        List<String> argsList = Arrays.asList(args);
        if(argsList.contains("--no-gui"))
        {
            Control.main(args);
            return;
        }

        Logger.addLogOutput(new LogFile());
        try
        {
            EventQueue.invokeAndWait(() -> new Window().setVisible(true));
            Logger.logMessage(LogPriority.HINT, "Server gestartet.");
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim erstellen des Fensters", ex);
            JOptionPane.showMessageDialog(null, "Fehler beim erstellen des Fensters, siehe Logdatei");
        }

        Control.startServer();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        overviewTab = new javax.swing.JPanel();
        logScrollPane = new javax.swing.JScrollPane(logPanel);
        showInfoCheck = new javax.swing.JCheckBox();
        showDevInfoCheck = new javax.swing.JCheckBox();
        configTab = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Convertron Server GUI");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        showInfoCheck.setText("Zeige Infos");

        showDevInfoCheck.setText("Zeige Entwicklerinfos");

        javax.swing.GroupLayout overviewTabLayout = new javax.swing.GroupLayout(overviewTab);
        overviewTab.setLayout(overviewTabLayout);
        overviewTabLayout.setHorizontalGroup(
            overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overviewTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logScrollPane)
                    .addGroup(overviewTabLayout.createSequentialGroup()
                        .addComponent(showInfoCheck)
                        .addGap(18, 18, 18)
                        .addComponent(showDevInfoCheck)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        overviewTabLayout.setVerticalGroup(
            overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overviewTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showInfoCheck)
                    .addComponent(showDevInfoCheck))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Übersicht", overviewTab);

        javax.swing.GroupLayout configTabLayout = new javax.swing.GroupLayout(configTab);
        configTab.setLayout(configTabLayout);
        configTabLayout.setHorizontalGroup(
            configTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 242, Short.MAX_VALUE)
        );
        configTabLayout.setVerticalGroup(
            configTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 89, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Konfiguration", configTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private LogPanel logPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel configTab;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane logScrollPane;
    private javax.swing.JPanel overviewTab;
    private javax.swing.JCheckBox showDevInfoCheck;
    private javax.swing.JCheckBox showInfoCheck;
    // End of variables declaration//GEN-END:variables
}
