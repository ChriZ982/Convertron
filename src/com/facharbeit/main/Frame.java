package com.facharbeit.main;

import com.facharbeit.tools.*;
import java.awt.Color;
import javax.swing.*;

/**
 * Anzeige-Fenster der Anwendung.
 */
public class Frame extends javax.swing.JFrame
{
    /**
     * Zufallsgenerierter Schlüssel (unwichtig)
     */
    private static final long serialVersionUID = 1161647102;

    /**
     * Komponenten, die mit Zeit zu tun haben.
     */
    private JComponent[] hoursComponents;

    /**
     * Komponenten, die mit SQL zu tun haben.
     */
    private JComponent[] sqlComponents;

    /**
     * Erstellt ein neues Fenster.
     */
    public Frame()
    {
        try
        {
            initComponents();

            hoursComponents = new JComponent[]
            {
                hoursHeadLabel, hour1Label, hour2Label, hour3Label, hour4Label, hour5Label,
                hour6Label, hour7Label, hour8Label, hour9Label, hour10Label, hour1Txt,
                hour2Txt, hour3Txt, hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt
            };
            sqlComponents = new JComponent[]
            {
                dbHostLabel, dbPortLabel, dbNameLabel, dbUserLabel, dbPwLabel, dbTableNameLabel,
                dbHostTxt, dbPortTxt, dbNameTxt, dbUserTxt, dbPwTxt, dbTableNameTxt,
                sqlModeLabel, sqlModeReadRBtn, sqlModeWriteRBtn, sqlModeDelWriteRBtn
            };
        } catch(Exception ex)
        {
            Logger.log("Fenster konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jColorChooser1 = new javax.swing.JColorChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        sqlMode = new javax.swing.ButtonGroup();
        Tabs = new javax.swing.JTabbedPane();
        ControlPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        genTodayBtn = new javax.swing.JButton();
        genTomorrowBtn = new javax.swing.JButton();
        genAllBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        motdTxt = new javax.swing.JTextField();
        genMotdBtn = new javax.swing.JButton();
        progBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        createBackupBtn = new javax.swing.JButton();
        deleteSourceBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        SettingsPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        speedPlanTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        speedMotdTxt = new javax.swing.JTextField();
        autoBackupCheck = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        weekTxt = new javax.swing.JTextField();
        customSourceCheck = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        sourceTodayTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        sourceTomorrowTxt = new javax.swing.JTextField();
        PathPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sourceTxt = new javax.swing.JTextField();
        selectSourceTodayBtn = new javax.swing.JButton();
        selectBackupBtn = new javax.swing.JButton();
        selectDestBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        destArea = new javax.swing.JTextArea("");
        backupTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        savePathBtn = new javax.swing.JButton();
        DesignPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        colorPlanCombo = new javax.swing.JComboBox();
        colorPlanPanel = new javax.swing.JPanel();
        colorMotdPanel = new javax.swing.JPanel();
        deleteColor = new javax.swing.JButton();
        addColorBtn = new javax.swing.JButton();
        colorNameTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        colorMotdCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        colorTableCombo = new javax.swing.JComboBox();
        colorTablePanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        colorBorderCombo = new javax.swing.JComboBox();
        colorBorderPanel = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        typeToEditCombo = new javax.swing.JComboBox();
        typeToEditTxt = new javax.swing.JTextField();
        addTypeBtn = new javax.swing.JButton();
        deleteTypeBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        fontColorPanel = new javax.swing.JPanel();
        fontColorCombo = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        fontTypeTxt = new javax.swing.JTextField();
        fontSizeLabel = new javax.swing.JLabel();
        backgroundColorLabel = new javax.swing.JLabel();
        backgroundColorCombo = new javax.swing.JComboBox();
        backgroundColorPanel = new javax.swing.JPanel();
        fontSizeTxt = new javax.swing.JTextField();
        boldCheck = new javax.swing.JCheckBox();
        italicCheck = new javax.swing.JCheckBox();
        saveDesignBtn = new javax.swing.JButton();
        SQLPanel = new javax.swing.JPanel();
        useSQLCheck = new javax.swing.JCheckBox();
        sqlSaveBtn = new javax.swing.JButton();
        dbTableNameTxt = new javax.swing.JTextField();
        dbTableNameLabel = new javax.swing.JLabel();
        dbNameTxt = new javax.swing.JTextField();
        dbNameLabel = new javax.swing.JLabel();
        dbUserLabel = new javax.swing.JLabel();
        dbUserTxt = new javax.swing.JTextField();
        dbPwLabel = new javax.swing.JLabel();
        dbPwTxt = new javax.swing.JPasswordField();
        dbPortTxt = new javax.swing.JTextField();
        dbPortLabel = new javax.swing.JLabel();
        dbHostTxt = new javax.swing.JTextField();
        dbHostLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sqlModeLabel = new javax.swing.JLabel();
        sqlModeReadRBtn = new javax.swing.JRadioButton();
        sqlModeWriteRBtn = new javax.swing.JRadioButton();
        sqlModeDelWriteRBtn = new javax.swing.JRadioButton();

        jFileChooser1.setFileHidingEnabled(true);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vertretungsplan");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        Tabs.setToolTipText("");

        ControlPanel.setToolTipText("");

        log.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        log.setToolTipText("Zeigt den Status des Programms an");
        log.setFocusable(false);
        jScrollPane1.setViewportView(log);

        jLabel1.setText("Status:");

        genTodayBtn.setText("heutigen Plan generieren");
        genTodayBtn.setToolTipText("Generiert nur den heutigen Plan");
        genTodayBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genTodayBtnActionPerformed(evt);
            }
        });

        genTomorrowBtn.setText("morgigen Plan generieren");
        genTomorrowBtn.setToolTipText("Generiert nur den morgigen Plan");
        genTomorrowBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genTomorrowBtnActionPerformed(evt);
            }
        });

        genAllBtn.setText("Alles generieren");
        genAllBtn.setToolTipText("Generiert den kompletten Plan");
        genAllBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        genAllBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genAllBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Vertretungplan:");

        motdTxt.setText("Laufschrift");
        motdTxt.setToolTipText("Text, der als Laufschrift angezeigt werden soll z.B. \"Dies ist eine Laufschrift\"");
        motdTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        motdTxt.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                motdTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                motdTxtFocusLost(evt);
            }
        });

        genMotdBtn.setText("Laufschrift generieren");
        genMotdBtn.setToolTipText("Generiert UND SPEICHERT nur die Laufschrift");
        genMotdBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genMotdBtnActionPerformed(evt);
            }
        });

        progBar.setToolTipText("Zeigt den Fortschritt der Generierung an");

        jLabel4.setText("Fortschritt:");

        createBackupBtn.setText("Backup erstellen");
        createBackupBtn.setToolTipText("Erstellt ein Backup des aktuellen Plans");
        createBackupBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                createBackupBtnActionPerformed(evt);
            }
        });

        deleteSourceBtn.setText("Quellpläne löschen");
        deleteSourceBtn.setToolTipText("Löscht die Quellpläne aus dem eingestellten Ordner");
        deleteSourceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteSourceBtnActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/antonianumLogo.jpg"))); // NOI18N
        jLabel5.setToolTipText("Antonianum Logo");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(genAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(genTodayBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(genTomorrowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .addComponent(genMotdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ControlPanelLayout.createSequentialGroup()
                            .addComponent(createBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteSourceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel2)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(motdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ControlPanelLayout.createSequentialGroup()
                                .addComponent(genTodayBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genTomorrowBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genMotdBtn))
                            .addComponent(genAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createBackupBtn)
                            .addComponent(deleteSourceBtn)))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        Tabs.addTab("Übersicht", ControlPanel);

        jLabel14.setText("Scrollgeschwindigkeit");

        speedPlanTxt.setToolTipText("Scrollgeschwindigkeit des Plans in % z.B. \"100\"");

        jLabel7.setText("Laufschriftgeschw.");

        speedMotdTxt.setToolTipText("Scrollgeschwindigkeit der Laufschrift in % z.B. \"100\"");

        autoBackupCheck.setText("Automatisches Backup");
        autoBackupCheck.setToolTipText("Soll ein automatisches Backup beim Generieren erstellt werden?");

        jLabel20.setText("%");

        jLabel21.setText("%");

        settingsSaveBtn.setText("speichern");
        settingsSaveBtn.setToolTipText("Speichert die Einstellungen der gesamten Seite, wendet sie aber nicht an");
        settingsSaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                settingsSaveBtnActionPerformed(evt);
            }
        });

        hour10Txt.setToolTipText("Zeit, nach der die zehnte Stunde gelöscht wird z.B. \"9:25\"");

        hour10Label.setText("10. Stunde");

        hour9Txt.setToolTipText("Zeit, nach der die neunte Stunde gelöscht wird z.B. \"9:25\"");

        hour9Label.setText("9. Stunde");

        hour7Label.setText("7. Stunde");

        hour7Txt.setToolTipText("Zeit, nach der die siebte Stunde gelöscht wird z.B. \"9:25\"");

        hour8Txt.setToolTipText("Zeit, nach der die achte Stunde gelöscht wird z.B. \"9:25\"");

        hour6Txt.setToolTipText("Zeit, nach der die sechste Stunde gelöscht wird z.B. \"9:25\"");

        hour4Txt.setToolTipText("Zeit, nach der die vierte Stunde gelöscht wird z.B. \"9:25\"");

        hour2Txt.setToolTipText("Zeit, nach der die zweite Stunde gelöscht wird z.B. \"9:25\"");

        hour1Txt.setToolTipText("Zeit, nach der die erste Stunde gelöscht wird z.B. \"9:25\"");

        hour3Txt.setToolTipText("Zeit, nach der die dritte Stunde gelöscht wird z.B. \"9:25\"");

        hour5Txt.setToolTipText("Zeit, nach der die fünfte Stunde gelöscht wird z.B. \"9:25\"");

        hour5Label.setText("5. Stunde");

        hour3Label.setText("3. Stunde");

        hour1Label.setText("1. Stunde");

        hour2Label.setText("2. Stunde");

        hour4Label.setText("4. Stunde");

        hour6Label.setText("6. Stunde");

        hour8Label.setText("8. Stunde");

        hoursHeadLabel.setText("Stunden ausblenden ab:");

        useHoursCheck.setText("Vergangene Vertretungen automatisch ausblenden");
        useHoursCheck.setToolTipText("Sollen vergangene Stunden ausgeblendet werden?");
        useHoursCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                useHoursCheckStateChanged(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null, null, null}
            },
            new String []
            {
                "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        table.setToolTipText("Verschieben der Tabellen-Sortierung auf dem Vertretungsplan");
        jScrollPane3.setViewportView(table);

        jLabel18.setText("Gerade Woche");

        weekTxt.setToolTipText("Buchstaben für die Gerade Woche definieren z.B. \"B\"");

        customSourceCheck.setText("Benutzerdefiniertes Datum");
        customSourceCheck.setToolTipText("Soll ein benutzerdefiniertes Datum für heute und morgen angenommen werden?");
        customSourceCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                customSourceCheckStateChanged(evt);
            }
        });

        jLabel10.setText("Heute");
        jLabel10.setEnabled(false);

        sourceTodayTxt.setToolTipText("Neues Datum für den heutigen Plan z.B. \"24.12.\"");
        sourceTodayTxt.setEnabled(false);

        jLabel22.setText("Morgen");
        jLabel22.setEnabled(false);

        sourceTomorrowTxt.setToolTipText("Neues Datum für den morgigen Plan z.B. \"25.12.\"");
        sourceTomorrowTxt.setEnabled(false);

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addComponent(settingsSaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addComponent(autoBackupCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                .addGap(6, 6, 6))
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sourceTodayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(customSourceCheck)
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(speedPlanTxt)
                                            .addComponent(speedMotdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                            .addComponent(weekTxt))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel21)))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sourceTomorrowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hoursHeadLabel)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(hour9Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour7Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour5Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour3Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hour3Txt)
                                    .addComponent(hour5Txt)
                                    .addComponent(hour7Txt)
                                    .addComponent(hour9Txt)
                                    .addComponent(hour1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(hour8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hour8Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(hour10Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hour10Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(hour6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hour6Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hour2Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hour4Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(hour2Txt)
                                            .addComponent(hour4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(useHoursCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addComponent(useHoursCheck)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hoursHeadLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hour1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour1Label)
                                    .addComponent(hour2Label)
                                    .addComponent(hour2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hour3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour3Label)
                                    .addComponent(hour4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour4Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hour5Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour5Label)
                                    .addComponent(hour6Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour6Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hour7Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour7Label)
                                    .addComponent(hour8Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour8Label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hour9Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour9Label)
                                    .addComponent(hour10Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hour10Label)))
                            .addComponent(jSeparator2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addComponent(autoBackupCheck)
                        .addGap(41, 41, 41)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(speedPlanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedMotdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(weekTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(customSourceCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(sourceTodayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sourceTomorrowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(settingsSaveBtn)
                .addContainerGap())
        );

        Tabs.addTab("Einstellungen", SettingsPanel);

        jLabel6.setText("Quellpfad");

        sourceTxt.setToolTipText("Quellpfad für die Vertretungs-Dateien");

        selectSourceTodayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectSourceTodayBtn.setToolTipText("Quellpfad auswählen");
        selectSourceTodayBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectSourceTodayBtnActionPerformed(evt);
            }
        });

        selectBackupBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectBackupBtn.setToolTipText("Backuppfad auswählen");
        selectBackupBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectBackupBtnActionPerformed(evt);
            }
        });

        selectDestBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectDestBtn.setToolTipText("Zielpfad hinzufügen");
        selectDestBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectDestBtnActionPerformed(evt);
            }
        });

        destArea.setColumns(20);
        destArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        destArea.setRows(5);
        destArea.setToolTipText("Zielpfade in die der Plan automatisch kopiert wird");
        jScrollPane2.setViewportView(destArea);

        backupTxt.setToolTipText("Backuppfad für den generierten Plan");

        jLabel8.setText("Backuppfad");

        jLabel9.setText("Zielpfade");

        savePathBtn.setText("speichern");
        savePathBtn.setToolTipText("Speichert alle Pfade");
        savePathBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                savePathBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PathPanelLayout = new javax.swing.GroupLayout(PathPanel);
        PathPanel.setLayout(PathPanelLayout);
        PathPanelLayout.setHorizontalGroup(
            PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(savePathBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PathPanelLayout.createSequentialGroup()
                        .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PathPanelLayout.createSequentialGroup()
                                .addComponent(backupTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PathPanelLayout.createSequentialGroup()
                                .addComponent(sourceTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectSourceTodayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PathPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        PathPanelLayout.setVerticalGroup(
            PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sourceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectSourceTodayBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(savePathBtn)
                .addContainerGap())
        );

        Tabs.addTab("Pfade", PathPanel);

        jLabel11.setText("Vertretungplan");

        colorPlanCombo.setToolTipText("Hintergrundfarbe des Vertretungsplans");
        colorPlanCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorPlanComboItemStateChanged(evt);
            }
        });

        colorPlanPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorPlanPanelLayout = new javax.swing.GroupLayout(colorPlanPanel);
        colorPlanPanel.setLayout(colorPlanPanelLayout);
        colorPlanPanelLayout.setHorizontalGroup(
            colorPlanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorPlanPanelLayout.setVerticalGroup(
            colorPlanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        colorMotdPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorMotdPanelLayout = new javax.swing.GroupLayout(colorMotdPanel);
        colorMotdPanel.setLayout(colorMotdPanelLayout);
        colorMotdPanelLayout.setHorizontalGroup(
            colorMotdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorMotdPanelLayout.setVerticalGroup(
            colorMotdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        deleteColor.setText("Farbe löschen");
        deleteColor.setToolTipText("Angegebene Farbe löschen");
        deleteColor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteColorActionPerformed(evt);
            }
        });

        addColorBtn.setText("Farbe bearbeiten/hinzufügen");
        addColorBtn.setToolTipText("Angegebene Farbe bearbeiten/hinzufügen");
        addColorBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addColorBtnActionPerformed(evt);
            }
        });

        colorNameTxt.setForeground(java.awt.Color.gray);
        colorNameTxt.setText("Farbenname");
        colorNameTxt.setToolTipText("Name der Farbe, die hinzugefügt/bearbeitet werden soll z.B. \"Antonsblau\"");
        colorNameTxt.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                colorNameTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                colorNameTxtFocusLost(evt);
            }
        });

        jLabel13.setText("Laufschrift");

        colorMotdCombo.setToolTipText("Hintergrundfarbe der Laufschrift");
        colorMotdCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorMotdComboItemStateChanged(evt);
            }
        });

        jLabel3.setText("Hintergrundfarben");

        jLabel12.setText("Tabelle");

        colorTableCombo.setToolTipText("Hintergrundfarbe der Tabelle");
        colorTableCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorTableComboItemStateChanged(evt);
            }
        });

        colorTablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorTablePanelLayout = new javax.swing.GroupLayout(colorTablePanel);
        colorTablePanel.setLayout(colorTablePanelLayout);
        colorTablePanelLayout.setHorizontalGroup(
            colorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorTablePanelLayout.setVerticalGroup(
            colorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel15.setText("andere Farben");

        jLabel16.setText("Rahmen");

        colorBorderCombo.setToolTipText("Farbe des Rahmens, der um die Frames angezeigt wird");
        colorBorderCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorBorderComboItemStateChanged(evt);
            }
        });

        colorBorderPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorBorderPanelLayout = new javax.swing.GroupLayout(colorBorderPanel);
        colorBorderPanel.setLayout(colorBorderPanelLayout);
        colorBorderPanelLayout.setHorizontalGroup(
            colorBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorBorderPanelLayout.setVerticalGroup(
            colorBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel17.setText("Text");

        typeToEditCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Überschrift", "Stufenname", "Laufschrift", "Tabelle" }));
        typeToEditCombo.setToolTipText("Bereich des Designs der bearbeitet werden soll");
        typeToEditCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                typeToEditComboItemStateChanged(evt);
            }
        });

        typeToEditTxt.setForeground(java.awt.Color.gray);
        typeToEditTxt.setText("Vertretungsart");
        typeToEditTxt.setToolTipText("Name einer neuen, zu differenzierenden, Vertretungsart z.B. \"Raum-Vtr.\"");
        typeToEditTxt.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                typeToEditTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                typeToEditTxtFocusLost(evt);
            }
        });

        addTypeBtn.setText("hinzufügen");
        addTypeBtn.setToolTipText("Eine neue, zu differenzierende, Vertretungsart erstellen");
        addTypeBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addTypeBtnActionPerformed(evt);
            }
        });

        deleteTypeBtn.setText("löschen");
        deleteTypeBtn.setToolTipText("Eine Vertretungsart löschen");
        deleteTypeBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteTypeBtnActionPerformed(evt);
            }
        });

        label.setText("Schriftfarbe");

        fontColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout fontColorPanelLayout = new javax.swing.GroupLayout(fontColorPanel);
        fontColorPanel.setLayout(fontColorPanelLayout);
        fontColorPanelLayout.setHorizontalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        fontColorPanelLayout.setVerticalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        fontColorCombo.setToolTipText("Schriftfarbe für den gewählten Bereich festlegen");
        fontColorCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                fontColorComboItemStateChanged(evt);
            }
        });

        jLabel23.setText("Schriftart");

        fontTypeTxt.setToolTipText("Schriftart für den gewählten Bereich festlegen z.B. \"calibri\"");
        fontTypeTxt.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                fontTypeTxtMouseExited(evt);
            }
        });

        fontSizeLabel.setText("Schriftgröße");

        backgroundColorLabel.setText("Hintergrundfarbe");

        backgroundColorCombo.setToolTipText("Hintergrundfarbe für den gewählten Bereich festlegen");
        backgroundColorCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                backgroundColorComboItemStateChanged(evt);
            }
        });

        backgroundColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout backgroundColorPanelLayout = new javax.swing.GroupLayout(backgroundColorPanel);
        backgroundColorPanel.setLayout(backgroundColorPanelLayout);
        backgroundColorPanelLayout.setHorizontalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        backgroundColorPanelLayout.setVerticalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        fontSizeTxt.setToolTipText("Schriftgröße für den gewählten Bereich festlegen z.B. \"12\"");
        fontSizeTxt.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                fontSizeTxtMouseExited(evt);
            }
        });

        boldCheck.setText("Fett");
        boldCheck.setToolTipText("Soll die Schrift des gewählten Bereichs fett gedruckt werden?");
        boldCheck.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                boldCheckActionPerformed(evt);
            }
        });

        italicCheck.setText("Kursiv");
        italicCheck.setToolTipText("Soll die Schrift des gewählten Bereichs kursiv gedruckt werden?");
        italicCheck.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                italicCheckActionPerformed(evt);
            }
        });

        saveDesignBtn.setText("Style anwenden");
        saveDesignBtn.setToolTipText("Den, oben eingestellten, Style für den Plan anwenden");
        saveDesignBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveDesignBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DesignPanelLayout = new javax.swing.GroupLayout(DesignPanel);
        DesignPanel.setLayout(DesignPanelLayout);
        DesignPanelLayout.setHorizontalGroup(
            DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesignPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 33, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(colorTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(typeToEditCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontTypeTxt))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DesignPanelLayout.createSequentialGroup()
                                        .addComponent(label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(fontSizeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boldCheck)
                                        .addGap(18, 18, 18)
                                        .addComponent(italicCheck))
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(backgroundColorLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(backgroundColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(typeToEditTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addTypeBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteTypeBtn))))
                            .addComponent(jLabel3)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(colorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addColorBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteColor))
                            .addComponent(jLabel15)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBorderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBorderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(saveDesignBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        DesignPanelLayout.setVerticalGroup(
            DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesignPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addColorBtn)
                    .addComponent(deleteColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(colorTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(colorBorderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(colorBorderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(typeToEditCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeToEditTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addTypeBtn)
                            .addComponent(deleteTypeBtn)))
                    .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(colorTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(backgroundColorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backgroundColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fontColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fontColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(fontTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fontSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fontSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boldCheck)
                            .addComponent(italicCheck))
                        .addGap(27, 27, 27))
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(saveDesignBtn)
                .addGap(28, 28, 28))
        );

        fontSizeTxt.getAccessibleContext().setAccessibleName("");

        Tabs.addTab("Design", DesignPanel);

        useSQLCheck.setText("SQL benutzen");
        useSQLCheck.setToolTipText("Soll die SQL-Unterstützung aktiviert werden?");
        useSQLCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                useSQLCheckStateChanged(evt);
            }
        });

        sqlSaveBtn.setText("speichern");
        sqlSaveBtn.setToolTipText("Speichert die SQL Einstellungen");
        sqlSaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sqlSaveBtnActionPerformed(evt);
            }
        });

        dbTableNameTxt.setToolTipText("Tabellen Name z.B. \"Vertretungen\"");

        dbTableNameLabel.setText("Tabellenname:");

        dbNameTxt.setToolTipText("Datenbank Name z.B. \"Schuldatenbank\"");

        dbNameLabel.setText("Datenbankname:");

        dbUserLabel.setText("Benutzername:");

        dbUserTxt.setToolTipText("Benutzername z.B. \"admin\"");

        dbPwLabel.setText("Passwort:");

        dbPwTxt.setToolTipText("Passwort z.B. \"passw\"");

        dbPortTxt.setToolTipText("Datenbank Port Standard:\"3306\"");

        dbPortLabel.setText("Port:");

        dbHostTxt.setToolTipText("Datenbank Host z.B. \"www.antonianum.de\"");

        dbHostLabel.setText("Datenbank Host:");

        sqlModeLabel.setText("Sql-Modus:");

        sqlMode.add(sqlModeReadRBtn);
        sqlModeReadRBtn.setText("lesen");

        sqlMode.add(sqlModeWriteRBtn);
        sqlModeWriteRBtn.setText("schreiben");

        sqlMode.add(sqlModeDelWriteRBtn);
        sqlModeDelWriteRBtn.setText("löschen und schreiben");

        javax.swing.GroupLayout SQLPanelLayout = new javax.swing.GroupLayout(SQLPanel);
        SQLPanel.setLayout(SQLPanelLayout);
        SQLPanelLayout.setHorizontalGroup(
            SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SQLPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sqlSaveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(SQLPanelLayout.createSequentialGroup()
                        .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbNameLabel)
                            .addComponent(dbUserLabel))
                        .addGap(18, 18, 18)
                        .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SQLPanelLayout.createSequentialGroup()
                                .addComponent(dbHostTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dbPortLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dbPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SQLPanelLayout.createSequentialGroup()
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dbNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dbTableNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dbPwLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dbTableNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(dbPwTxt)))))
                    .addGroup(SQLPanelLayout.createSequentialGroup()
                        .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(useSQLCheck)
                            .addComponent(dbHostLabel)
                            .addComponent(sqlModeLabel)
                            .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(sqlModeReadRBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sqlModeWriteRBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sqlModeDelWriteRBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SQLPanelLayout.setVerticalGroup(
            SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SQLPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(useSQLCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbHostLabel)
                    .addComponent(dbHostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbPortLabel)
                    .addComponent(dbPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbNameLabel)
                    .addComponent(dbNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbTableNameLabel)
                    .addComponent(dbTableNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbUserLabel)
                    .addComponent(dbPwLabel)
                    .addComponent(dbPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sqlModeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqlModeReadRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqlModeWriteRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqlModeDelWriteRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(sqlSaveBtn)
                .addContainerGap())
        );

        Tabs.addTab("SQL", SQLPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectSourceTodayBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectSourceTodayBtnActionPerformed
    {//GEN-HEADEREND:event_selectSourceTodayBtnActionPerformed
        try
        {
            jFileChooser1.showOpenDialog(null);
            sourceTxt.setText(jFileChooser1.getSelectedFile().getPath());
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
    }//GEN-LAST:event_selectSourceTodayBtnActionPerformed

    private void selectBackupBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectBackupBtnActionPerformed
    {//GEN-HEADEREND:event_selectBackupBtnActionPerformed
        try
        {
            jFileChooser1.showOpenDialog(null);
            backupTxt.setText(jFileChooser1.getSelectedFile().getPath());
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
    }//GEN-LAST:event_selectBackupBtnActionPerformed

    private void selectDestBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectDestBtnActionPerformed
    {//GEN-HEADEREND:event_selectDestBtnActionPerformed
        try
        {
            while(destArea.getText().startsWith("\n"))
                destArea.setText(destArea.getText().substring("\n".length()));

            jFileChooser1.showOpenDialog(null);

            if(!destArea.getText().endsWith("\n") && destArea.getText().contains("\n"))
                destArea.setText(destArea.getText() + "\n");

            destArea.append(jFileChooser1.getSelectedFile().getPath() + "\n");
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
    }//GEN-LAST:event_selectDestBtnActionPerformed

    private void savePathBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_savePathBtnActionPerformed
    {//GEN-HEADEREND:event_savePathBtnActionPerformed
        try
        {
            while(destArea.getText().startsWith("\n"))
                destArea.setText(destArea.getText().substring("\n".length()));
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
        Application.addToQueue("savePathBtnActionPerformed", sourceTxt, backupTxt, destArea);
    }//GEN-LAST:event_savePathBtnActionPerformed

    private void addColorBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addColorBtnActionPerformed
    {//GEN-HEADEREND:event_addColorBtnActionPerformed
        if(!colorNameTxt.getText().equals("Farbenname") && !colorNameTxt.getText().equals(""))
            Application.addToQueue("addColorBtnActionPerformed", jColorChooser1, colorNameTxt, colorPlanCombo, colorMotdCombo,
                                   colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);
    }//GEN-LAST:event_addColorBtnActionPerformed

    private void colorPlanComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorPlanComboItemStateChanged
    {//GEN-HEADEREND:event_colorPlanComboItemStateChanged
        Application.addToQueue("colorPlanComboItemStateChanged", colorPlanPanel, colorPlanCombo, evt);
    }//GEN-LAST:event_colorPlanComboItemStateChanged

    private void colorMotdComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorMotdComboItemStateChanged
    {//GEN-HEADEREND:event_colorMotdComboItemStateChanged
        Application.addToQueue("colorMotdComboItemStateChanged", colorMotdPanel, colorMotdCombo, evt);
    }//GEN-LAST:event_colorMotdComboItemStateChanged

    private void deleteColorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteColorActionPerformed
    {//GEN-HEADEREND:event_deleteColorActionPerformed
        Application.addToQueue("deleteColorBtnActionPerformed", colorNameTxt, colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo);
    }//GEN-LAST:event_deleteColorActionPerformed

    private void useSQLCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useSQLCheckStateChanged
    {//GEN-HEADEREND:event_useSQLCheckStateChanged
        try
        {
            for(JComponent j : sqlComponents)
                j.setEnabled(useSQLCheck.isSelected());
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
    }//GEN-LAST:event_useSQLCheckStateChanged

    private void genAllBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genAllBtnActionPerformed
    {//GEN-HEADEREND:event_genAllBtnActionPerformed
        Application.addToQueue("genAllBtnActionPerformed");
    }//GEN-LAST:event_genAllBtnActionPerformed

    private void genTodayBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genTodayBtnActionPerformed
    {//GEN-HEADEREND:event_genTodayBtnActionPerformed
        Application.addToQueue("genTodayBtnActionPerformed");
    }//GEN-LAST:event_genTodayBtnActionPerformed

    private void genTomorrowBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genTomorrowBtnActionPerformed
    {//GEN-HEADEREND:event_genTomorrowBtnActionPerformed
        Application.addToQueue("genTomorrowBtnActionPerformed");
    }//GEN-LAST:event_genTomorrowBtnActionPerformed

    private void createBackupBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_createBackupBtnActionPerformed
    {//GEN-HEADEREND:event_createBackupBtnActionPerformed
        Application.addToQueue("createBackupBtnActionPerformed");
    }//GEN-LAST:event_createBackupBtnActionPerformed

    private void deleteSourceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteSourceBtnActionPerformed
    {//GEN-HEADEREND:event_deleteSourceBtnActionPerformed
        Application.addToQueue("deleteSourceBtnActionPerformed");
    }//GEN-LAST:event_deleteSourceBtnActionPerformed

    private void genMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genMotdBtnActionPerformed
    {//GEN-HEADEREND:event_genMotdBtnActionPerformed
        Application.addToQueue("genMotdBtnActionPerformed", motdTxt);
    }//GEN-LAST:event_genMotdBtnActionPerformed

    private void sqlSaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sqlSaveBtnActionPerformed
    {//GEN-HEADEREND:event_sqlSaveBtnActionPerformed
        JRadioButton[] rBtns =
        {
            sqlModeReadRBtn, sqlModeWriteRBtn, sqlModeDelWriteRBtn
        };
        Application.addToQueue("SQLsaveBtnActionPerformed", dbHostTxt, dbPortTxt, dbNameTxt, dbUserTxt,
                               dbPwTxt, dbTableNameTxt, useSQLCheck, rBtns);

    }//GEN-LAST:event_sqlSaveBtnActionPerformed

    private void settingsSaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_settingsSaveBtnActionPerformed
    {//GEN-HEADEREND:event_settingsSaveBtnActionPerformed
        Application.addToQueue("settingsSaveBtnActionPerformed", hour1Txt, hour2Txt, hour3Txt,
                               hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt,
                               useHoursCheck, autoBackupCheck, speedPlanTxt, speedMotdTxt,
                               table, weekTxt, sourceTodayTxt, sourceTomorrowTxt, customSourceCheck);
    }//GEN-LAST:event_settingsSaveBtnActionPerformed

    private void useHoursCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useHoursCheckStateChanged
    {//GEN-HEADEREND:event_useHoursCheckStateChanged
        try
        {
            for(JComponent j : hoursComponents)
                j.setEnabled(useHoursCheck.isSelected());
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
    }//GEN-LAST:event_useHoursCheckStateChanged

    private void typeToEditComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_typeToEditComboItemStateChanged
    {//GEN-HEADEREND:event_typeToEditComboItemStateChanged
        try
        {
            Application.addToQueue("typeToEditComboItemStateChanged", typeToEditCombo, fontColorCombo, fontColorPanel,
                                   backgroundColorCombo, backgroundColorPanel, fontTypeTxt, fontSizeTxt, boldCheck,
                                   italicCheck, evt);

            backgroundColorLabel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
            backgroundColorCombo.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
            backgroundColorPanel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
    }//GEN-LAST:event_typeToEditComboItemStateChanged

    private void customSourceCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_customSourceCheckStateChanged
    {//GEN-HEADEREND:event_customSourceCheckStateChanged
        try
        {
            sourceTodayTxt.setEnabled(customSourceCheck.isSelected());
            sourceTomorrowTxt.setEnabled(customSourceCheck.isSelected());
            jLabel10.setEnabled(customSourceCheck.isSelected());
            jLabel22.setEnabled(customSourceCheck.isSelected());
        } catch(Exception ex)
        {
            Logger.log("Fehler im Frame", 2);
            Logger.error(ex);
        }
    }//GEN-LAST:event_customSourceCheckStateChanged

    private void colorTableComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorTableComboItemStateChanged
    {//GEN-HEADEREND:event_colorTableComboItemStateChanged
        Application.addToQueue("colorTableComboItemStateChanged", colorTablePanel, colorTableCombo, evt);
    }//GEN-LAST:event_colorTableComboItemStateChanged

    private void colorBorderComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorBorderComboItemStateChanged
    {//GEN-HEADEREND:event_colorBorderComboItemStateChanged
        Application.addToQueue("colorBorderComboItemStateChanged", colorBorderPanel, colorBorderCombo, evt);
    }//GEN-LAST:event_colorBorderComboItemStateChanged

    private void fontColorComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_fontColorComboItemStateChanged
    {//GEN-HEADEREND:event_fontColorComboItemStateChanged
        Application.addToQueue("fontColorComboItemStateChanged", fontColorPanel, fontColorCombo, typeToEditCombo, evt);
    }//GEN-LAST:event_fontColorComboItemStateChanged

    private void backgroundColorComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_backgroundColorComboItemStateChanged
    {//GEN-HEADEREND:event_backgroundColorComboItemStateChanged
        Application.addToQueue("backgroundColorComboItemStateChanged", backgroundColorPanel, backgroundColorCombo,
                               typeToEditCombo, evt);
    }//GEN-LAST:event_backgroundColorComboItemStateChanged

    private void boldCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_boldCheckActionPerformed
    {//GEN-HEADEREND:event_boldCheckActionPerformed
        Application.addToQueue("styleCheckActionPerformed", boldCheck, italicCheck, typeToEditCombo);
    }//GEN-LAST:event_boldCheckActionPerformed

    private void italicCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_italicCheckActionPerformed
    {//GEN-HEADEREND:event_italicCheckActionPerformed
        Application.addToQueue("styleCheckActionPerformed", boldCheck, italicCheck, typeToEditCombo);
    }//GEN-LAST:event_italicCheckActionPerformed

    private void fontSizeTxtMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_fontSizeTxtMouseExited
    {//GEN-HEADEREND:event_fontSizeTxtMouseExited
        Application.addToQueue("fontSizeTxtActionPerformed", fontSizeTxt, typeToEditCombo);
    }//GEN-LAST:event_fontSizeTxtMouseExited

    private void fontTypeTxtMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_fontTypeTxtMouseExited
    {//GEN-HEADEREND:event_fontTypeTxtMouseExited
        Application.addToQueue("fontTypeTxtActionPerformed", fontTypeTxt, typeToEditCombo);
    }//GEN-LAST:event_fontTypeTxtMouseExited

    private void addTypeBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addTypeBtnActionPerformed
    {//GEN-HEADEREND:event_addTypeBtnActionPerformed
        if(!typeToEditTxt.getText().equals("Vertretungsart") && !typeToEditTxt.getText().equals(""))
            Application.addToQueue("addTypeBtnActionPerformed", typeToEditTxt, typeToEditCombo);
    }//GEN-LAST:event_addTypeBtnActionPerformed

    private void deleteTypeBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteTypeBtnActionPerformed
    {//GEN-HEADEREND:event_deleteTypeBtnActionPerformed
        Application.addToQueue("deleteTypeBtnActionPerformed", typeToEditTxt, typeToEditCombo);
    }//GEN-LAST:event_deleteTypeBtnActionPerformed

    private void saveDesignBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveDesignBtnActionPerformed
    {//GEN-HEADEREND:event_saveDesignBtnActionPerformed
        Application.addToQueue("saveDesignBtnActionPerformed");
    }//GEN-LAST:event_saveDesignBtnActionPerformed

    private void colorNameTxtFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_colorNameTxtFocusGained
    {//GEN-HEADEREND:event_colorNameTxtFocusGained
        if(colorNameTxt.getText().equals("Farbenname"))
            colorNameTxt.setText("");
        colorNameTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_colorNameTxtFocusGained

    private void colorNameTxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_colorNameTxtFocusLost
    {//GEN-HEADEREND:event_colorNameTxtFocusLost
        if(colorNameTxt.getText().equals(""))
        {
            colorNameTxt.setText("Farbenname");
            colorNameTxt.setForeground(Color.GRAY);
        } else
            colorNameTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_colorNameTxtFocusLost

    private void typeToEditTxtFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_typeToEditTxtFocusGained
    {//GEN-HEADEREND:event_typeToEditTxtFocusGained
        if(typeToEditTxt.getText().equals("Vertretungsart"))
            typeToEditTxt.setText("");
        typeToEditTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_typeToEditTxtFocusGained

    private void typeToEditTxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_typeToEditTxtFocusLost
    {//GEN-HEADEREND:event_typeToEditTxtFocusLost
        if(typeToEditTxt.getText().equals(""))
        {
            typeToEditTxt.setText("Vertretungsart");
            typeToEditTxt.setForeground(Color.GRAY);
        } else
            typeToEditTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_typeToEditTxtFocusLost

    private void motdTxtFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_motdTxtFocusGained
    {//GEN-HEADEREND:event_motdTxtFocusGained
        if(motdTxt.getText().equals("Laufschrift"))
            motdTxt.setText("");
        motdTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_motdTxtFocusGained

    private void motdTxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_motdTxtFocusLost
    {//GEN-HEADEREND:event_motdTxtFocusLost
        if(motdTxt.getText().equals(""))
        {
            motdTxt.setText("Laufschrift");
            motdTxt.setForeground(Color.GRAY);
        } else
            motdTxt.setForeground(Color.BLACK);
    }//GEN-LAST:event_motdTxtFocusLost

    public JTextPane getStatusPane()
    {
        return log;
    }

    public JProgressBar getProgBar()
    {
        return progBar;
    }

    public void loadSettings()
    {
        try
        {
            JRadioButton[] rBtns =
            {
                sqlModeReadRBtn, sqlModeWriteRBtn, sqlModeDelWriteRBtn
            };
            Application.addToQueue("loadSettings", sourceTxt, backupTxt, destArea, speedPlanTxt, speedMotdTxt,
                                   colorPlanCombo, colorMotdCombo, motdTxt, useSQLCheck, dbHostTxt, dbPortTxt,
                                   dbNameTxt, dbUserTxt, dbPwTxt, dbTableNameTxt, rBtns, hour1Txt, hour2Txt, hour3Txt,
                                   hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt,
                                   autoBackupCheck, useHoursCheck, customSourceCheck, sourceTodayTxt,
                                   sourceTomorrowTxt, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo,
                                   fontTypeTxt, fontSizeTxt, boldCheck, italicCheck, typeToEditCombo, table, weekTxt);

            sourceTodayTxt.setEnabled(customSourceCheck.isSelected());
            sourceTomorrowTxt.setEnabled(customSourceCheck.isSelected());
            jLabel10.setEnabled(customSourceCheck.isSelected());
            jLabel22.setEnabled(customSourceCheck.isSelected());
            backgroundColorLabel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
            backgroundColorCombo.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
            backgroundColorPanel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));

            for(JComponent j : sqlComponents)
                j.setEnabled(useSQLCheck.isSelected());

            for(JComponent j : hoursComponents)
                j.setEnabled(useHoursCheck.isSelected());
        } catch(Exception ex)
        {
            Logger.log("Fehler beim Laden der Einstellungen", 2);
            Logger.error(ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JPanel DesignPanel;
    private javax.swing.JPanel PathPanel;
    private javax.swing.JPanel SQLPanel;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton addColorBtn;
    private javax.swing.JButton addTypeBtn;
    private javax.swing.JCheckBox autoBackupCheck;
    private javax.swing.JComboBox backgroundColorCombo;
    private javax.swing.JLabel backgroundColorLabel;
    private javax.swing.JPanel backgroundColorPanel;
    private javax.swing.JTextField backupTxt;
    private javax.swing.JCheckBox boldCheck;
    private javax.swing.JComboBox colorBorderCombo;
    private javax.swing.JPanel colorBorderPanel;
    private javax.swing.JComboBox colorMotdCombo;
    private javax.swing.JPanel colorMotdPanel;
    private javax.swing.JTextField colorNameTxt;
    private javax.swing.JComboBox colorPlanCombo;
    private javax.swing.JPanel colorPlanPanel;
    private javax.swing.JComboBox colorTableCombo;
    private javax.swing.JPanel colorTablePanel;
    private javax.swing.JButton createBackupBtn;
    private javax.swing.JCheckBox customSourceCheck;
    private javax.swing.JLabel dbHostLabel;
    private javax.swing.JTextField dbHostTxt;
    private javax.swing.JLabel dbNameLabel;
    private javax.swing.JTextField dbNameTxt;
    private javax.swing.JLabel dbPortLabel;
    private javax.swing.JTextField dbPortTxt;
    private javax.swing.JLabel dbPwLabel;
    private javax.swing.JPasswordField dbPwTxt;
    private javax.swing.JLabel dbTableNameLabel;
    private javax.swing.JTextField dbTableNameTxt;
    private javax.swing.JLabel dbUserLabel;
    private javax.swing.JTextField dbUserTxt;
    private javax.swing.JButton deleteColor;
    private javax.swing.JButton deleteSourceBtn;
    private javax.swing.JButton deleteTypeBtn;
    private javax.swing.JTextArea destArea;
    private javax.swing.JComboBox fontColorCombo;
    private javax.swing.JPanel fontColorPanel;
    private javax.swing.JLabel fontSizeLabel;
    private javax.swing.JTextField fontSizeTxt;
    private javax.swing.JTextField fontTypeTxt;
    private javax.swing.JButton genAllBtn;
    private javax.swing.JButton genMotdBtn;
    private javax.swing.JButton genTodayBtn;
    private javax.swing.JButton genTomorrowBtn;
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
    private javax.swing.JCheckBox italicCheck;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel label;
    private javax.swing.JTextPane log;
    private javax.swing.JTextField motdTxt;
    private javax.swing.JProgressBar progBar;
    private javax.swing.JButton saveDesignBtn;
    private javax.swing.JButton savePathBtn;
    private javax.swing.JButton selectBackupBtn;
    private javax.swing.JButton selectDestBtn;
    private javax.swing.JButton selectSourceTodayBtn;
    private javax.swing.JButton settingsSaveBtn;
    private javax.swing.JTextField sourceTodayTxt;
    private javax.swing.JTextField sourceTomorrowTxt;
    private javax.swing.JTextField sourceTxt;
    private javax.swing.JTextField speedMotdTxt;
    private javax.swing.JTextField speedPlanTxt;
    private javax.swing.ButtonGroup sqlMode;
    private javax.swing.JRadioButton sqlModeDelWriteRBtn;
    private javax.swing.JLabel sqlModeLabel;
    private javax.swing.JRadioButton sqlModeReadRBtn;
    private javax.swing.JRadioButton sqlModeWriteRBtn;
    private javax.swing.JButton sqlSaveBtn;
    private javax.swing.JTable table;
    private javax.swing.JComboBox typeToEditCombo;
    private javax.swing.JTextField typeToEditTxt;
    private javax.swing.JCheckBox useHoursCheck;
    private javax.swing.JCheckBox useSQLCheck;
    private javax.swing.JTextField weekTxt;
    // End of variables declaration//GEN-END:variables
}
