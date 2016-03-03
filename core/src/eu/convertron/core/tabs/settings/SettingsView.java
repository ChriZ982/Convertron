package eu.convertron.core.tabs.settings;

import eu.convertron.applib.settings.CheckBoxSetting;
import eu.convertron.applib.settings.ComboBoxSetting;
import eu.convertron.applib.settings.ComponentSetting;
import eu.convertron.applib.settings.TextFieldSetting;
import eu.convertron.core.CoreArraySettings;
import eu.convertron.core.CoreSettings;
import eu.convertron.core.Resources;
import eu.convertron.interlib.interfaces.View;
import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

@SuppressWarnings("serial")
public class SettingsView extends View
{
    private JComponent[] useHoursComponents, customDateComponents;

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
            hour1Label, hour1TextField,
            hour2Label, hour2TextField,
            hour3Label, hour3TextField,
            hour4Label, hour4TextField,
            hour5Label, hour5TextField,
            hour6Label, hour6TextField,
            hour7Label, hour7TextField,
            hour8Label, hour8TextField,
            hour9Label, hour9TextField,
            hour10Label, hour10TextField
        };

        customDateComponents = new JComponent[]
        {
            customTodayLabel, customTodayTextField,
            customTomorrowLabel, customTomorrowTextField
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        folderChooser = new javax.swing.JFileChooser();
        autoBackupCheckBox = new javax.swing.JCheckBox();
        saveSettingsButton = new javax.swing.JButton();
        hour10TextField = new javax.swing.JTextField();
        hour10Label = new javax.swing.JLabel();
        hour9TextField = new javax.swing.JTextField();
        hour9Label = new javax.swing.JLabel();
        hour7Label = new javax.swing.JLabel();
        hour7TextField = new javax.swing.JTextField();
        hour8TextField = new javax.swing.JTextField();
        hour6TextField = new javax.swing.JTextField();
        hour4TextField = new javax.swing.JTextField();
        hour2TextField = new javax.swing.JTextField();
        hour1TextField = new javax.swing.JTextField();
        hour3TextField = new javax.swing.JTextField();
        hour5TextField = new javax.swing.JTextField();
        hour5Label = new javax.swing.JLabel();
        hour3Label = new javax.swing.JLabel();
        hour1Label = new javax.swing.JLabel();
        hour2Label = new javax.swing.JLabel();
        hour4Label = new javax.swing.JLabel();
        hour6Label = new javax.swing.JLabel();
        hour8Label = new javax.swing.JLabel();
        hoursHeadLabel = new javax.swing.JLabel();
        useHoursCheckBox = new javax.swing.JCheckBox();
        separator2 = new javax.swing.JSeparator();
        evenWeekLabel = new javax.swing.JLabel();
        customDateCheckBox = new javax.swing.JCheckBox();
        customTodayLabel = new javax.swing.JLabel();
        customTodayTextField = new javax.swing.JTextField();
        customTomorrowLabel = new javax.swing.JLabel();
        customTomorrowTextField = new javax.swing.JTextField();
        separator1 = new javax.swing.JSeparator();
        automaticModeCheckBox = new javax.swing.JCheckBox();
        autoImportCheckBox = new javax.swing.JCheckBox();
        autoExportCheckBox = new javax.swing.JCheckBox();
        evenWeekComboBox = new javax.swing.JComboBox<String>();
        generateAllLabel = new javax.swing.JLabel();
        pathsLabel = new javax.swing.JLabel();
        dataPathLabel = new javax.swing.JLabel();
        backupPathLabel = new javax.swing.JLabel();
        dataPathTextField = new javax.swing.JTextField();
        backupPathTextField = new javax.swing.JTextField();
        dataPathChooseButton = new javax.swing.JButton();
        backupPathChooseButton = new javax.swing.JButton();

        autoBackupCheckBox.setText("Backup");
        autoBackupCheckBox.setToolTipText("Soll ein automatisches Backup beim Generieren erstellt werden?");

        saveSettingsButton.setText("speichern");
        saveSettingsButton.setToolTipText("Speichert die Einstellungen der gesamten Seite, wendet sie aber nicht an");

        hour10TextField.setToolTipText("Zeit, nach der die zehnte Stunde gelöscht wird z.B. \"9:25\"");
        hour10TextField.setEnabled(false);

        hour10Label.setText("10. Stunde");
        hour10Label.setEnabled(false);

        hour9TextField.setToolTipText("Zeit, nach der die neunte Stunde gelöscht wird z.B. \"9:25\"");
        hour9TextField.setEnabled(false);

        hour9Label.setText("9. Stunde");
        hour9Label.setEnabled(false);

        hour7Label.setText("7. Stunde");
        hour7Label.setEnabled(false);

        hour7TextField.setToolTipText("Zeit, nach der die siebte Stunde gelöscht wird z.B. \"9:25\"");
        hour7TextField.setEnabled(false);

        hour8TextField.setToolTipText("Zeit, nach der die achte Stunde gelöscht wird z.B. \"9:25\"");
        hour8TextField.setEnabled(false);

        hour6TextField.setToolTipText("Zeit, nach der die sechste Stunde gelöscht wird z.B. \"9:25\"");
        hour6TextField.setEnabled(false);

        hour4TextField.setToolTipText("Zeit, nach der die vierte Stunde gelöscht wird z.B. \"9:25\"");
        hour4TextField.setEnabled(false);

        hour2TextField.setToolTipText("Zeit, nach der die zweite Stunde gelöscht wird z.B. \"9:25\"");
        hour2TextField.setEnabled(false);

        hour1TextField.setToolTipText("Zeit, nach der die erste Stunde gelöscht wird z.B. \"9:25\"");
        hour1TextField.setEnabled(false);

        hour3TextField.setToolTipText("Zeit, nach der die dritte Stunde gelöscht wird z.B. \"9:25\"");
        hour3TextField.setEnabled(false);

        hour5TextField.setToolTipText("Zeit, nach der die fünfte Stunde gelöscht wird z.B. \"9:25\"");
        hour5TextField.setEnabled(false);

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

        useHoursCheckBox.setText("Vergangene Vertretungen ausblenden");
        useHoursCheckBox.setToolTipText("Sollen vergangene Stunden ausgeblendet werden?");
        useHoursCheckBox.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                useHoursCheckBoxItemStateChanged(evt);
            }
        });

        separator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        evenWeekLabel.setText("Gerade Woche");

        customDateCheckBox.setText("Benutzerdefiniertes Datum");
        customDateCheckBox.setToolTipText("Soll ein benutzerdefiniertes Datum für heute und morgen angenommen werden?");
        customDateCheckBox.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                customDateCheckBoxItemStateChanged(evt);
            }
        });

        customTodayLabel.setText("Heute");
        customTodayLabel.setEnabled(false);

        customTodayTextField.setToolTipText("Neues Datum für den heutigen Plan z.B. \"24.12.\"");
        customTodayTextField.setEnabled(false);

        customTomorrowLabel.setText("Morgen");
        customTomorrowLabel.setEnabled(false);

        customTomorrowTextField.setToolTipText("Neues Datum für den morgigen Plan z.B. \"25.12.\"");
        customTomorrowTextField.setEnabled(false);

        automaticModeCheckBox.setText("Automatikmodus");

        autoImportCheckBox.setText("Vertretungsplan importieren");

        autoExportCheckBox.setText("Vertretungsplan exportieren");

        evenWeekComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B" }));

        generateAllLabel.setText("Alles generieren:");

        pathsLabel.setText("Pfade:");

        dataPathLabel.setText("Data");

        backupPathLabel.setText("Backup");

        dataPathChooseButton.setIcon(new javax.swing.ImageIcon(Resources.get("ordner.png")));
        dataPathChooseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dataPathChooseButtonActionPerformed(evt);
            }
        });

        backupPathChooseButton.setIcon(new javax.swing.ImageIcon(Resources.get("ordner.png")));
        backupPathChooseButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backupPathChooseButtonActionPerformed(evt);
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
                        .addComponent(saveSettingsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customTodayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(customTomorrowLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(customTodayTextField)
                                            .addComponent(customTomorrowTextField)))
                                    .addComponent(customDateCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(automaticModeCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(generateAllLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(autoImportCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(autoExportCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                            .addComponent(autoBackupCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(evenWeekLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(evenWeekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                    .addComponent(hour7TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                                    .addComponent(hour5TextField)
                                                    .addComponent(hour3TextField)
                                                    .addComponent(hour1TextField)
                                                    .addComponent(hour9TextField))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour10Label)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour10TextField, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour8TextField))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour6TextField))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour4Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour4TextField))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(hour2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(hour2TextField))))))
                                    .addComponent(useHoursCheckBox)))
                            .addComponent(pathsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(backupPathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dataPathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataPathTextField)
                            .addComponent(backupPathTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataPathChooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backupPathChooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(useHoursCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoursHeadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour1Label)
                            .addComponent(hour2Label)
                            .addComponent(hour2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour3Label)
                            .addComponent(hour4TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour4Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour5TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour5Label)
                            .addComponent(hour6TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour6Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour7TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour7Label)
                            .addComponent(hour8TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour8Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour9TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour9Label)
                            .addComponent(hour10TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour10Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(evenWeekLabel)
                            .addComponent(evenWeekComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(automaticModeCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generateAllLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoBackupCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoImportCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoExportCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customDateCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(customTodayLabel)
                            .addComponent(customTodayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customTomorrowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(customTomorrowLabel)))
                    .addComponent(separator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dataPathChooseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataPathLabel)
                        .addComponent(dataPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backupPathLabel)
                        .addComponent(backupPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(backupPathChooseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addComponent(saveSettingsButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void useHoursCheckBoxItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_useHoursCheckBoxItemStateChanged
    {//GEN-HEADEREND:event_useHoursCheckBoxItemStateChanged
        for(JComponent comp : useHoursComponents)
            comp.setEnabled(useHoursCheckBox.isSelected());
    }//GEN-LAST:event_useHoursCheckBoxItemStateChanged

    private void customDateCheckBoxItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_customDateCheckBoxItemStateChanged
    {//GEN-HEADEREND:event_customDateCheckBoxItemStateChanged
        for(JComponent comp : customDateComponents)
            comp.setEnabled(customDateCheckBox.isSelected());
    }//GEN-LAST:event_customDateCheckBoxItemStateChanged

    private void dataPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_dataPathChooseButtonActionPerformed
    {//GEN-HEADEREND:event_dataPathChooseButtonActionPerformed
        if(folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            dataPathTextField.setText(folderChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_dataPathChooseButtonActionPerformed

    private void backupPathChooseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backupPathChooseButtonActionPerformed
    {//GEN-HEADEREND:event_backupPathChooseButtonActionPerformed
        if(folderChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            backupPathTextField.setText(folderChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_backupPathChooseButtonActionPerformed

    public void addSaveListener(Runnable task)
    {
        saveSettingsButton.addActionListener(getActionListenerToRunnable(task));
    }

    public ComponentSetting[] createHandlers()
    {
        return new ComponentSetting[]
        {
            new CheckBoxSetting(automaticModeCheckBox, CoreSettings.autoMode),
            new CheckBoxSetting(autoImportCheckBox, CoreSettings.autoImport),
            new CheckBoxSetting(autoExportCheckBox, CoreSettings.autoExport),
            new CheckBoxSetting(autoBackupCheckBox, CoreSettings.autoBackup),
            //-----
            new CheckBoxSetting(customDateCheckBox, CoreSettings.useCustomDate),
            new TextFieldSetting(customTodayTextField, CoreSettings.customDateToday),
            new TextFieldSetting(customTomorrowTextField, CoreSettings.customDateTomorrow),
            //-----
            new CheckBoxSetting(useHoursCheckBox, CoreSettings.useCutHours),
            new TextFieldSetting(hour1TextField, CoreArraySettings.cutHours, 0),
            new TextFieldSetting(hour2TextField, CoreArraySettings.cutHours, 1),
            new TextFieldSetting(hour3TextField, CoreArraySettings.cutHours, 2),
            new TextFieldSetting(hour4TextField, CoreArraySettings.cutHours, 3),
            new TextFieldSetting(hour5TextField, CoreArraySettings.cutHours, 4),
            new TextFieldSetting(hour6TextField, CoreArraySettings.cutHours, 5),
            new TextFieldSetting(hour7TextField, CoreArraySettings.cutHours, 6),
            new TextFieldSetting(hour8TextField, CoreArraySettings.cutHours, 7),
            new TextFieldSetting(hour9TextField, CoreArraySettings.cutHours, 8),
            new TextFieldSetting(hour10TextField, CoreArraySettings.cutHours, 9),
            //-----
            new ComboBoxSetting(evenWeekComboBox, CoreSettings.evenWeekChar),
            //-----
            new TextFieldSetting(dataPathTextField, CoreSettings.pathData),
            new TextFieldSetting(backupPathTextField, CoreSettings.pathBackup)
        };
    }

    @Override
    public String getTabTitle()
    {
        return "Einstellungen";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoBackupCheckBox;
    private javax.swing.JCheckBox autoExportCheckBox;
    private javax.swing.JCheckBox autoImportCheckBox;
    private javax.swing.JCheckBox automaticModeCheckBox;
    private javax.swing.JButton backupPathChooseButton;
    private javax.swing.JLabel backupPathLabel;
    private javax.swing.JTextField backupPathTextField;
    private javax.swing.JCheckBox customDateCheckBox;
    private javax.swing.JLabel customTodayLabel;
    private javax.swing.JTextField customTodayTextField;
    private javax.swing.JLabel customTomorrowLabel;
    private javax.swing.JTextField customTomorrowTextField;
    private javax.swing.JButton dataPathChooseButton;
    private javax.swing.JLabel dataPathLabel;
    private javax.swing.JTextField dataPathTextField;
    private javax.swing.JComboBox<String> evenWeekComboBox;
    private javax.swing.JLabel evenWeekLabel;
    private javax.swing.JFileChooser folderChooser;
    private javax.swing.JLabel generateAllLabel;
    private javax.swing.JLabel hour10Label;
    private javax.swing.JTextField hour10TextField;
    private javax.swing.JLabel hour1Label;
    private javax.swing.JTextField hour1TextField;
    private javax.swing.JLabel hour2Label;
    private javax.swing.JTextField hour2TextField;
    private javax.swing.JLabel hour3Label;
    private javax.swing.JTextField hour3TextField;
    private javax.swing.JLabel hour4Label;
    private javax.swing.JTextField hour4TextField;
    private javax.swing.JLabel hour5Label;
    private javax.swing.JTextField hour5TextField;
    private javax.swing.JLabel hour6Label;
    private javax.swing.JTextField hour6TextField;
    private javax.swing.JLabel hour7Label;
    private javax.swing.JTextField hour7TextField;
    private javax.swing.JLabel hour8Label;
    private javax.swing.JTextField hour8TextField;
    private javax.swing.JLabel hour9Label;
    private javax.swing.JTextField hour9TextField;
    private javax.swing.JLabel hoursHeadLabel;
    private javax.swing.JLabel pathsLabel;
    private javax.swing.JButton saveSettingsButton;
    private javax.swing.JSeparator separator1;
    private javax.swing.JSeparator separator2;
    private javax.swing.JCheckBox useHoursCheckBox;
    // End of variables declaration//GEN-END:variables
}
