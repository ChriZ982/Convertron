package eu.convertron.server.gui;

import eu.convertron.applib.etc.LogFile;
import eu.convertron.applib.gui.ApplicationFrame;
import eu.convertron.applib.gui.LogPanel;
import eu.convertron.interlib.data.SingleConfigurationListener;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.server.ConsoleMain;
import eu.convertron.server.Control;
import java.awt.EventQueue;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import static eu.convertron.server.Control.MOTD_CONFIG;

public class Window extends ApplicationFrame
{
    private static final long serialVersionUID = -1353727408535016989L;

    private final Control control;

    public Window(Control control)
    {
        this.control = control;
        super.init(Resources.get("trayLogo.png"), "Convertron Server", createMenuItem("Exportieren", (e) -> control.export()));
        logPanel = new LogPanel();
        initComponents();

        control.getCoreConfig().addConfigListener(
                new SingleConfigurationListener(MOTD_CONFIG, (v) -> motdTxt.setText(new String(v, StandardCharsets.UTF_8))));
        motdTxt.setText(new String(control.getCoreConfig().getOrCreateConfig(MOTD_CONFIG), StandardCharsets.UTF_8));
    }

    @Override
    public void exit()
    {
        control.exit();
    }

    public static void main(String[] args)
    {
        List<String> argsList = Arrays.asList(args);
        if(argsList.contains("--no-gui"))
        {
            ConsoleMain.main(args);
            return;
        }

        Logger.addLogOutput(new LogFile());

        Control c = new Control();

        try
        {
            EventQueue.invokeAndWait(() -> new Window(c).setVisible(true));
            Logger.logMessage(LogPriority.HINT, "Server gestartet.");
        }
        catch(Exception ex)
        {
            Logger.logError(LogPriority.ERROR, "Fehler beim erstellen des Fensters", ex);
            JOptionPane.showMessageDialog(null, "Fehler beim erstellen des Fensters, siehe Logdatei");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        overviewTab = new javax.swing.JPanel();
        logScrollPane = new javax.swing.JScrollPane(logPanel);
        showInfoCheck = new javax.swing.JCheckBox();
        showDevInfoCheck = new javax.swing.JCheckBox();
        exportBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        motdTxt = new javax.swing.JTextField();
        saveMotdBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Convertron Server GUI");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        showInfoCheck.setText("Zeige Infos");
        showInfoCheck.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                showInfoCheckItemStateChanged(evt);
            }
        });

        showDevInfoCheck.setText("Zeige Entwicklerinfos");
        showDevInfoCheck.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                showDevInfoCheckItemStateChanged(evt);
            }
        });

        exportBtn.setText("Vertretungplan exportieren");
        exportBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                exportBtnActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportView(motdTxt);

        saveMotdBtn.setText("Laufschrift speichern");
        saveMotdBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveMotdBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout overviewTabLayout = new javax.swing.GroupLayout(overviewTab);
        overviewTab.setLayout(overviewTabLayout);
        overviewTabLayout.setHorizontalGroup(
            overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overviewTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exportBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logScrollPane)
                    .addGroup(overviewTabLayout.createSequentialGroup()
                        .addComponent(showInfoCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(showDevInfoCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveMotdBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        overviewTabLayout.setVerticalGroup(
            overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overviewTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(overviewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showInfoCheck)
                    .addComponent(showDevInfoCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveMotdBtn)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Übersicht", overviewTab);

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

    private void exportBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_exportBtnActionPerformed
    {//GEN-HEADEREND:event_exportBtnActionPerformed
        control.export();
    }//GEN-LAST:event_exportBtnActionPerformed

    private void saveMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveMotdBtnActionPerformed
    {//GEN-HEADEREND:event_saveMotdBtnActionPerformed
        control.getCoreConfig().setConfig(MOTD_CONFIG, motdTxt.getText().getBytes(StandardCharsets.UTF_8));
    }//GEN-LAST:event_saveMotdBtnActionPerformed

    private void showInfoCheckItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_showInfoCheckItemStateChanged
    {//GEN-HEADEREND:event_showInfoCheckItemStateChanged
        logPanel.setLogInfos(showInfoCheck.isSelected());
    }//GEN-LAST:event_showInfoCheckItemStateChanged

    private void showDevInfoCheckItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_showDevInfoCheckItemStateChanged
    {//GEN-HEADEREND:event_showDevInfoCheckItemStateChanged
        logPanel.setLogDevInfos(showDevInfoCheck.isSelected());
    }//GEN-LAST:event_showDevInfoCheckItemStateChanged

    private LogPanel logPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JScrollPane logScrollPane;
    private javax.swing.JTextField motdTxt;
    private javax.swing.JPanel overviewTab;
    private javax.swing.JButton saveMotdBtn;
    private javax.swing.JCheckBox showDevInfoCheck;
    private javax.swing.JCheckBox showInfoCheck;
    // End of variables declaration//GEN-END:variables
}
