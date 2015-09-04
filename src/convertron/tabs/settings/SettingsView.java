/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.tabs.settings;

import interlib.interfaces.View;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class SettingsView extends View
{
    private static final long serialVersionUID = 16654651L;

    private JComponent[] useHoursComponents, customDateComponents;

    /** Creates new form View */
    public SettingsView()
    {
        initComponents();

        folderChooser.setFileFilter(new FileFilter()
        {
            @Override
            public boolean accept(File f)
            {
                return f.isDirectory();
            }

            @Override
            public String getDescription()
            {
                return "Ordner";
            }
        });

        useHoursComponents = new JComponent[]
        {
            hour1Label, hour1Txt,
            hour2Label, hour2Txt,
            hour3Label, hour3Txt,
            hour4Label, hour4Txt,
            hour5Label, hour5Txt,
            hour6Label, hour6Txt,
            hour7Label, hour7Txt,
            hour8Label, hour8Txt,
            hour9Label, hour9Txt,
            hour10Label, hour10Txt
        };

        customDateComponents = new JComponent[]
        {
            customTodayLabel, customTodayTxt,
            customTomorrowLabel, customTomorrowTxt
        };
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        folderChooser = new javax.swing.JFileChooser();
        autoBackupCheck = new javax.swing.JCheckBox();
        settingsSaveBtn = new javax.swing.JButton();
        hour10Txt = new javax.swing.JTextField();
        hour10Label = new javax.swing.JLabel();
        hour9Txt = new javax.swing.JTextField();
        hour9Label = new javax.swing.JLabel();
        hour7Label = new javax.swing.JLabel();
        hour7Txt = new javax.swing.JTextField();
        hour8Txt = new javax.swing.JTextField();
        hour6Txt = new javax.swing.JTextField();
        hour4Txt = new javax.swing.JTextField();
        hour2Txt = new javax.swing.JTextField();
        hour1Txt = new javax.swing.JTextField();
        hour3Txt = new javax.swing.JTextField();
        hour5Txt = new javax.swing.JTextField();
        hour5Label = new javax.swing.JLabel();
        hour3Label = new javax.swing.JLabel();
        hour1Label = new javax.swing.JLabel();
        hour2Label = new javax.swing.JLabel();
        hour4Label = new javax.swing.JLabel();
        hour6Label = new javax.swing.JLabel();
        hour8Label = new javax.swing.JLabel();
        hoursHeadLabel = new javax.swing.JLabel();
        useHoursCheck = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        customDateCheck = new javax.swing.JCheckBox();
        customTodayLabel = new javax.swing.JLabel();
        customTodayTxt = new javax.swing.JTextField();
        customTomorrowLabel = new javax.swing.JLabel();
        customTomorrowTxt = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        automaticModeCheck = new javax.swing.JCheckBox();
        autoImportCheck = new javax.swing.JCheckBox();
        autoExportCheck = new javax.swing.JCheckBox();
        weekCombo = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dataPathTxt = new javax.swing.JTextField();
        backupPathTxt = new javax.swing.JTextField();
        dataPathChooseBtn = new javax.swing.JButton();
        backupPathChooseBtn = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(443, 336));

        autoBackupCheck.setText("Backup");
        autoBackupCheck.setToolTipText("Soll ein automatisches Backup beim Generieren erstellt werden?");

        settingsSaveBtn.setText("speichern");
        settingsSaveBtn.setToolTipText("Speichert die Einstellungen der gesamten Seite, wendet sie aber nicht an");

        hour10Txt.setToolTipText("Zeit, nach der die zehnte Stunde gelöscht wird z.B. \"9:25\"");
        hour10Txt.setEnabled(false);

        hour10Label.setText("10. Stunde");
        hour10Label.setEnabled(false);

        hour9Txt.setToolTipText("Zeit, nach der die neunte Stunde gelöscht wird z.B. \"9:25\"");
        hour9Txt.setEnabled(false);

        hour9Label.setText("9. Stunde");
        hour9Label.setEnabled(false);

        hour7Label.setText("7. Stunde");
        hour7Label.setEnabled(false);

        hour7Txt.setToolTipText("Zeit, nach der die siebte Stunde gelöscht wird z.B. \"9:25\"");
        hour7Txt.setEnabled(false);

        hour8Txt.setToolTipText("Zeit, nach der die achte Stunde gelöscht wird z.B. \"9:25\"");
        hour8Txt.setEnabled(false);

        hour6Txt.setToolTipText("Zeit, nach der die sechste Stunde gelöscht wird z.B. \"9:25\"");
        hour6Txt.setEnabled(false);

        hour4Txt.setToolTipText("Zeit, nach der die vierte Stunde gelöscht wird z.B. \"9:25\"");
        hour4Txt.setEnabled(false);

        hour2Txt.setToolTipText("Zeit, nach der die zweite Stunde gelöscht wird z.B. \"9:25\"");
        hour2Txt.setEnabled(false);

        hour1Txt.setToolTipText("Zeit, nach der die erste Stunde gelöscht wird z.B. \"9:25\"");
        hour1Txt.setEnabled(false);

        hour3Txt.setToolTipText("Zeit, nach der die dritte Stunde gelöscht wird z.B. \"9:25\"");
        hour3Txt.setEnabled(false);

        hour5Txt.setToolTipText("Zeit, nach der die fünfte Stunde gelöscht wird z.B. \"9:25\"");
        hour5Txt.setEnabled(false);

        hour5Label.setText("5. Stunde");
        hour5Label.setEnabled(false);

        hour3Label.setText("3. Stunde");
        hour3Label.setEnabled(false);

        hour1Label.setText("1. Stunde");
        hour1Label.setEnabled(false);

        hour2Label.setText("2. Stunde");
        hour2Label.setEnabled(false);

        hour4Label.setText("4. Stunde");
        hour4Label.setEnabled(false);

        hour6Label.setText("6. Stunde");
        hour6Label.setEnabled(false);

        hour8Label.setText("8. Stunde");
        hour8Label.setEnabled(false);

        hoursHeadLabel.setText("Stunden ausblenden ab:");

        useHoursCheck.setText("Vergangene Vertretungen ausblenden");
        useHoursCheck.setToolTipText("Sollen vergangene Stunden ausgeblendet werden?");
        useHoursCheck.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                useHoursCheckItemStateChanged(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel18.setText("Gerade Woche");

        customDateCheck.setText("Benutzerdefiniertes Datum");
        customDateCheck.setToolTipText("Soll ein benutzerdefiniertes Datum für heute und morgen angenommen werden?");
        customDateCheck.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                customDateCheckItemStateChanged(evt);
            }
        });

        customTodayLabel.setText("Heute");
        customTodayLabel.setEnabled(false);

        customTodayTxt.setToolTipText("Neues Datum für den heutigen Plan z.B. \"24.12.\"");
        customTodayTxt.setEnabled(false);

        customTomorrowLabel.setText("Morgen");
        customTomorrowLabel.setEnabled(false);

        customTomorrowTxt.setToolTipText("Neues Datum für den morgigen Plan z.B. \"25.12.\"");
        customTomorrowTxt.setEnabled(false);

        automaticModeCheck.setText("Automatikmodus");

        autoImportCheck.setText("Vertretungsplan importieren");

        autoExportCheck.setText("Vertretungsplan exportieren");

        weekCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B" }));

        jLabel1.setText("Alles generieren:");

        jLabel4.setText("Pfade:");

        jLabel5.setText("Data");

        jLabel6.setText("Backup");

        dataPathChooseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convertron/res/ordner.png"))); // NOI18N
        dataPathChooseBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dataPathChooseBtnActionPerformed(evt);
            }
        });

        backupPathChooseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convertron/res/ordner.png"))); // NOI18N
        backupPathChooseBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backupPathChooseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(settingsSaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customTodayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(customTomorrowLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customTodayTxt)
                                            .addComponent(customTomorrowTxt)))
                                    .addComponent(customDateCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(automaticModeCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(autoImportCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(autoExportCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(autoBackupCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(weekCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hoursHeadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(hour9Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(hour7Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(hour5Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(hour3Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addComponent(hour1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(hour7Txt)
                                                    .addComponent(hour5Txt)
                                                    .addComponent(hour3Txt)
                                                    .addComponent(hour1Txt)
                                                    .addComponent(hour9Txt))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour10Label)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour10Txt))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour8Txt))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour6Txt))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour4Txt))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour2Txt))))))
                                    .addComponent(useHoursCheck)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataPathTxt)
                            .addComponent(backupPathTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataPathChooseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backupPathChooseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(useHoursCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoursHeadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour1Label)
                            .addComponent(hour2Label)
                            .addComponent(hour2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour3Label)
                            .addComponent(hour4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour4Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour5Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour5Label)
                            .addComponent(hour6Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour6Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour7Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour7Label)
                            .addComponent(hour8Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour8Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour9Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour9Label)
                            .addComponent(hour10Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour10Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(weekCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(automaticModeCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoBackupCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoImportCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoExportCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customDateCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customTodayLabel)
                            .addComponent(customTodayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customTomorrowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customTomorrowLabel)))
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataPathChooseBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(dataPathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(backupPathTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backupPathChooseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settingsSaveBtn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void useHoursCheckItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_useHoursCheckItemStateChanged
    {//GEN-HEADEREND:event_useHoursCheckItemStateChanged
        for(JComponent comp : useHoursComponents)
            comp.setEnabled(useHoursCheck.isSelected());
    }//GEN-LAST:event_useHoursCheckItemStateChanged

    private void customDateCheckItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_customDateCheckItemStateChanged
    {//GEN-HEADEREND:event_customDateCheckItemStateChanged
        for(JComponent comp : customDateComponents)
            comp.setEnabled(customDateCheck.isSelected());
    }//GEN-LAST:event_customDateCheckItemStateChanged

    private void dataPathChooseBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dataPathChooseBtnActionPerformed
    {//GEN-HEADEREND:event_dataPathChooseBtnActionPerformed
        if(folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            dataPathTxt.setText(folderChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_dataPathChooseBtnActionPerformed

    private void backupPathChooseBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backupPathChooseBtnActionPerformed
    {//GEN-HEADEREND:event_backupPathChooseBtnActionPerformed
        if(folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            backupPathTxt.setText(folderChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_backupPathChooseBtnActionPerformed

    public void addSaveListener(Runnable task)
    {
        settingsSaveBtn.addActionListener(getActionListenerToRunnable(task));
    }

    public String[] getTimeCutHours()
    {
        return new String[]
        {
            hour1Txt.getText(),
            hour2Txt.getText(),
            hour3Txt.getText(),
            hour4Txt.getText(),
            hour5Txt.getText(),
            hour6Txt.getText(),
            hour7Txt.getText(),
            hour8Txt.getText(),
            hour9Txt.getText(),
            hour10Txt.getText(),
        };
    }

    public boolean useCutHours()
    {
        return useHoursCheck.isSelected();
    }

    public String getNameOfFlatWeek()
    {
        return weekCombo.getSelectedItem().toString();
    }

    public boolean autoMode()
    {
        return automaticModeCheck.isSelected();
    }

    public boolean autoBackup()
    {
        return autoBackupCheck.isSelected();
    }

    public boolean autoImport()
    {
        return autoImportCheck.isSelected();
    }

    public boolean autoExport()
    {
        return autoExportCheck.isSelected();
    }

    public boolean useCustomDate()
    {
        return customDateCheck.isSelected();
    }

    public String getCustumDateToday()
    {
        return customTodayTxt.getText();
    }

    public String getCustumDateTomorrow()
    {
        return customTomorrowTxt.getText();
    }

    public String getBackupPath()
    {
        return backupPathTxt.getText();
    }

    public String getDataPath()
    {
        return dataPathTxt.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoBackupCheck;
    private javax.swing.JCheckBox autoExportCheck;
    private javax.swing.JCheckBox autoImportCheck;
    private javax.swing.JCheckBox automaticModeCheck;
    private javax.swing.JButton backupPathChooseBtn;
    private javax.swing.JTextField backupPathTxt;
    private javax.swing.JCheckBox customDateCheck;
    private javax.swing.JLabel customTodayLabel;
    private javax.swing.JTextField customTodayTxt;
    private javax.swing.JLabel customTomorrowLabel;
    private javax.swing.JTextField customTomorrowTxt;
    private javax.swing.JButton dataPathChooseBtn;
    private javax.swing.JTextField dataPathTxt;
    private javax.swing.JFileChooser folderChooser;
    private javax.swing.JLabel hour10Label;
    private javax.swing.JTextField hour10Txt;
    private javax.swing.JLabel hour1Label;
    private javax.swing.JTextField hour1Txt;
    private javax.swing.JLabel hour2Label;
    private javax.swing.JTextField hour2Txt;
    private javax.swing.JLabel hour3Label;
    private javax.swing.JTextField hour3Txt;
    private javax.swing.JLabel hour4Label;
    private javax.swing.JTextField hour4Txt;
    private javax.swing.JLabel hour5Label;
    private javax.swing.JTextField hour5Txt;
    private javax.swing.JLabel hour6Label;
    private javax.swing.JTextField hour6Txt;
    private javax.swing.JLabel hour7Label;
    private javax.swing.JTextField hour7Txt;
    private javax.swing.JLabel hour8Label;
    private javax.swing.JTextField hour8Txt;
    private javax.swing.JLabel hour9Label;
    private javax.swing.JTextField hour9Txt;
    private javax.swing.JLabel hoursHeadLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JButton settingsSaveBtn;
    private javax.swing.JCheckBox useHoursCheck;
    private javax.swing.JComboBox<String> weekCombo;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabTitle()
    {
        return "Einstellungen";
    }
}
