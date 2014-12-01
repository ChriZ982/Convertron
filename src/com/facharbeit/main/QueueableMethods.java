package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.tools.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.swing.*;

public class QueueableMethods
{
    // Übersicht
    public static void genAllBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.sortArray(HtmlReader.readInToday()), 50, 65);
        HtmlWriter.generatePlanTomorrow(HtmlReader.sortArray(HtmlReader.readInTomorrow()), 65, 80);
        HtmlWriter.generateModt(80, 95);
        backupToDestPaths();
        Logger.setProgress(100);
        Logger.setProgress(0);
    }

    public static void genTodayBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.sortArray(HtmlReader.readInToday()), 50, 95);
        backupToDestPaths();
        Logger.setProgress(100);
        Logger.setProgress(0);
    }

    public static void genTomorrowBtnActionPerformed()
    {
        HtmlWriter.generatePlanTomorrow(HtmlReader.sortArray(HtmlReader.readInTomorrow()), 50, 95);
        backupToDestPaths();
        Logger.setProgress(100);
        Logger.setProgress(0);
    }

    public static void genMotdBtnActionPerformed(JTextField motdTxt)
    {
        Settings.save("motdText", motdTxt.getText());

        HtmlWriter.generateModt(0, 100);
        Logger.setProgress(0);
    }

    public static void createBackupBtnActionPerformed()
    {
        String path = Settings.load("backupPath");
        backupAll(path);
        Logger.log("Backup wurde fertiggestellt", 0);
    }

    public static void deleteSourceBtnActionPerformed()
    {
        //TODO
    }

    // Einstellungen
    public static void settingsSaveBtnActionPerformed(JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt,
                                                      JTextField hour4Txt, JTextField hour5Txt, JTextField hour6Txt,
                                                      JTextField hour7Txt, JTextField hour8Txt, JTextField hour9Txt,
                                                      JTextField hour10Txt, JCheckBox useHoursCheck, JCheckBox autoBackupCheck,
                                                      JCheckBox autoDeleteSourceCheck, JTextField speedPlanTxt,
                                                      JTextField speedMotdTxt)
    {
        saveIfNotNull(hour1Txt, "cutLesson1");
        saveIfNotNull(hour2Txt, "cutLesson2");
        saveIfNotNull(hour3Txt, "cutLesson3");
        saveIfNotNull(hour4Txt, "cutLesson4");
        saveIfNotNull(hour5Txt, "cutLesson5");
        saveIfNotNull(hour6Txt, "cutLesson6");
        saveIfNotNull(hour7Txt, "cutLesson7");
        saveIfNotNull(hour8Txt, "cutLesson8");
        saveIfNotNull(hour9Txt, "cutLesson9");
        saveIfNotNull(hour10Txt, "cutLesson10");
        saveIfNotNull(speedPlanTxt, "planSpeed");
        saveIfNotNull(speedMotdTxt, "motdSpeed");

        Settings.save("useCutLessons", String.valueOf(useHoursCheck.isSelected()));
        Settings.save("autoBackup", String.valueOf(autoBackupCheck.isSelected()));
        Settings.save("autoDeleteSources", String.valueOf(autoDeleteSourceCheck.isSelected()));
    }

    // Pfade
    public static void savePathBtnActionPerformed(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea,
                                                  JTextField sourceTodayTxt, JTextField sourceTomorrowTxt,
                                                  JCheckBox customSourceCheck)
    {
        Settings.save("customSource", String.valueOf(customSourceCheck.isSelected()));

        saveIfNotNull(sourceTxt, "sourcePath");
        saveIfNotNull(backupTxt, "backupPath");
        saveIfNotNull(sourceTodayTxt, "sourceTodayPath");
        saveIfNotNull(sourceTomorrowTxt, "sourceTomorrowPath");

        ArrayList<String> destPaths = new ArrayList<String>();
        destPaths.addAll(Arrays.asList(destArea.getText().split("\n")));

        for(int i = 0; Settings.delete("destPath" + (i + 1)); i++);

        if(!destArea.getText().equals(""))
            for(int i = 0; i < destPaths.size(); i++)
                Settings.save("destPath" + (i + 1), destPaths.get(i));
    }

    // Design
    public static void addColorBtnActionPerformed(JColorChooser colorChooser, JTextField colorNameTxt, JComboBox colorPlanCombo,
                                                  JComboBox colorMotdCombo, JComboBox colorTableCombo, JComboBox colorBorderCombo,
                                                  JComboBox fontColorCombo, JComboBox backgroundColorCombo)
    {
        Color c = JColorChooser.showDialog(colorChooser, "Neue Farbe anlegen", Color.BLUE);

        if(c != null)
        {
            Settings.save("color" + colorNameTxt.getText(), "#" + Integer.toHexString(c.getRGB()).substring(2));
            loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);
        }
    }

    public static void deleteColorBtnActionPerformed(JTextField colorNameTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo,
                                                     JComboBox colorTableCombo, JComboBox colorBorderCombo, JComboBox fontColorCombo,
                                                     JComboBox backgroundColorCombo)
    {
        Settings.delete("color" + colorNameTxt.getText());
        loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);
    }

    public static void colorPlanComboItemStateChanged(JPanel colorPlanPanel, JComboBox colorPlanCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorPlanPanel.setBackground(Color.decode(Settings.load("color" + colorPlanCombo.getSelectedItem().toString())));

            if(!Settings.load("colorOfPlan").equals(colorPlanCombo.getSelectedItem().toString()))
                Settings.save("colorOfPlan", colorPlanCombo.getSelectedItem().toString());
        }
    }

    public static void colorMotdComboItemStateChanged(JPanel colorMotdPanel, JComboBox colorMotdCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorMotdPanel.setBackground(Color.decode(Settings.load("color" + colorMotdCombo.getSelectedItem().toString())));

            if(!Settings.load("colorOfMotd").equals(colorMotdCombo.getSelectedItem().toString()))
                Settings.save("colorOfMotd", colorMotdCombo.getSelectedItem().toString());
        }
    }

    public static void colorTableComboItemStateChanged(JPanel colorTablePanel, JComboBox colorTableCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorTablePanel.setBackground(Color.decode(Settings.load("color" + colorTableCombo.getSelectedItem().toString())));

            if(!Settings.load("colorOfTable").equals(colorTableCombo.getSelectedItem().toString()))
                Settings.save("colorOfTable", colorTableCombo.getSelectedItem().toString());
        }
    }

    public static void colorBorderComboItemStateChanged(JPanel colorBorderPanel, JComboBox colorBorderCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorBorderPanel.setBackground(Color.decode(Settings.load("color" + colorBorderCombo.getSelectedItem().toString())));

            if(!Settings.load("colorOfBorder").equals(colorBorderCombo.getSelectedItem().toString()))
                Settings.save("colorOfBorder", colorBorderCombo.getSelectedItem().toString());
        }
    }

    public static void fontColorComboItemStateChanged(JPanel fontColorPanel, JComboBox fontColorCombo, JComboBox typeToEditCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            fontColorPanel.setBackground(Color.decode(Settings.load("color" + fontColorCombo.getSelectedItem().toString())));

            if(!Settings.load("fontColorOf" + typeToEditCombo.getSelectedItem().toString()).equals(fontColorCombo.getSelectedItem().toString()))
                Settings.save("fontColorOf" + typeToEditCombo.getSelectedItem().toString(), fontColorCombo.getSelectedItem().toString());
        }
    }

    public static void backgroundColorComboItemStateChanged(JPanel backgroundColorPanel, JComboBox backgroundColorCombo, JComboBox typeToEditCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            backgroundColorPanel.setBackground(Color.decode(Settings.load("color" + backgroundColorCombo.getSelectedItem().toString())));

            if(!Settings.load("backColorOf" + typeToEditCombo.getSelectedItem().toString()).equals(backgroundColorCombo.getSelectedItem().toString()))
                Settings.save("backColorOf" + typeToEditCombo.getSelectedItem().toString(), backgroundColorCombo.getSelectedItem().toString());
        }
    }

    // SQL
    public static void SQLsaveBtnActionPerformed(JTextField dbHostTxt, JTextField dbPortTxt, JTextField dbNameTxt,
                                                 JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                                 JCheckBox useSQLCheck, JButton sqlModeBtn)
    {
        Settings.save("useSQL", String.valueOf(useSQLCheck.isSelected()));
        Settings.save("SQLMode", sqlModeBtn.getText());

        saveIfNotNull(dbHostTxt, "dbHost");
        saveIfNotNull(dbPortTxt, "dbPort");
        saveIfNotNull(dbNameTxt, "dbName");
        saveIfNotNull(dbUserTxt, "dbUser");
        saveIfNotNull(dbPwTxt, "dbPassw");
        saveIfNotNull(dbTableNameTxt, "dbTableName");
    }

    // Anderes
    public static void loadSettings(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea, JTextField speedPlanTxt,
                                    JTextField speedMotdTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo,
                                    JTextField motdTxt, JCheckBox useSQLCheck, JTextField dbHostTxt, JTextField dbPortTxt,
                                    JTextField dbNameTxt, JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                    JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt, JTextField hour4Txt,
                                    JTextField hour5Txt, JTextField hour6Txt, JTextField hour7Txt, JTextField hour8Txt,
                                    JTextField hour9Txt, JTextField hour10Txt, JButton SQLModeBtn, JCheckBox autoBackupCheck,
                                    JCheckBox autoDeleteSourceCheck, JCheckBox useHoursCheck, JCheckBox customSourceCheck,
                                    JTextField sourceTodayTxt, JTextField sourceTomorrowTxt, JComboBox colorTableCombo,
                                    JComboBox colorBorderCombo, JComboBox fontColorCombo, JComboBox backgroundColorCombo)
    {
        load(sourceTxt, "sourcePath");
        load(backupTxt, "backupPath");
        load(motdTxt, "motdText");
        load(speedPlanTxt, "planSpeed");
        load(speedMotdTxt, "motdSpeed");
        load(dbHostTxt, "dbHost");
        load(dbPortTxt, "dbPort");
        load(dbNameTxt, "dbName");
        load(dbUserTxt, "dbUser");
        load(dbPwTxt, "dbPassw");
        load(dbTableNameTxt, "dbTableName");
        load(hour1Txt, "cutLesson1");
        load(hour2Txt, "cutLesson2");
        load(hour3Txt, "cutLesson3");
        load(hour4Txt, "cutLesson4");
        load(hour5Txt, "cutLesson5");
        load(hour6Txt, "cutLesson6");
        load(hour7Txt, "cutLesson7");
        load(hour8Txt, "cutLesson8");
        load(hour9Txt, "cutLesson9");
        load(hour10Txt, "cutLesson10");
        load(sourceTodayTxt, "sourceTodayPath");
        load(sourceTomorrowTxt, "sourceTomorrowPath");

        useSQLCheck.setSelected(Boolean.valueOf(Settings.load("useSQL")));
        autoBackupCheck.setSelected(Boolean.valueOf(Settings.load("autoBackup")));
        autoDeleteSourceCheck.setSelected(Boolean.valueOf(Settings.load("autoDeleteSources")));
        useHoursCheck.setSelected(Boolean.valueOf(Settings.load("useCutLessons")));
        customSourceCheck.setSelected(Boolean.valueOf(Settings.load("customSource")));

        String name = "destPath1";
        if(Settings.getLineOf(name) == -1)
            Settings.load(name);

        for(int i = 1; Settings.getLineOf(name) != -1; i++)
        {
            String s = Settings.load(name);
            destArea.append(s + "\n");
            name = "destPath" + (i + 1);
        }

        loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

        if(Settings.load("SQLMode").equals("write"))
            SQLModeBtn.setText("schreiben");
        else
            SQLModeBtn.setText("lesen");
    }

    private static void loadColors(JComboBox... colorCombos)
    {
        for(JComboBox cb : colorCombos)
        {
            cb.removeAllItems();

            String[] colors = Settings.loadNames("color");
            for(String s : colors)
                if(!s.contains("colorOf"))
                    cb.addItem(s.substring(5));
        }

        colorCombos[0].setSelectedItem(Settings.load("colorOfPlan"));
        colorCombos[1].setSelectedItem(Settings.load("colorOfMotd"));
        colorCombos[2].setSelectedItem(Settings.load("colorOfTable"));
        colorCombos[3].setSelectedItem(Settings.load("colorOfBorder"));
        colorCombos[4].setSelectedItem(Settings.load("fontColorOfÜbersicht"));
        colorCombos[5].setSelectedItem(Settings.load("backColorOfÜbersicht"));
    }

    private static void saveIfNotNull(JTextField field, String name)
    {
        if(field.getText().equals(""))
            Settings.delete(name);
        else
            Settings.save(name, field.getText());
    }

    private static void load(JTextField field, String name)
    {
        field.setText(Settings.load(name));
    }

    private static void backupToDestPaths()
    {
        String[] paths = Settings.loadValues("destPath");
        for(String path : paths)
            backupAll(path);
    }

    private static void backupAll(String path)
    {
        backup(path, "heute.html", "morgen.html", "laufschrift.html",
               "VERTRETUNGSPLAN.html", "TEMPLATE heute morgen.html", "TEMPLATE laufschrift.html",
               "settings.ini", "style.css", "antonianumLogo.png");
    }

    private static void backup(String path, String... files)
    {
        for(String file : files)
            copy(file, path);
    }

    private static void copy(String file, String path)
    {
        try
        {
            if(!Files.exists(Paths.get(path)))
                Files.createDirectories(Paths.get(path));

            Files.copy(Paths.get("Data\\" + file), Paths.get(path + "\\" + file), StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException ex)
        {
            Logger.log("\"" + file + "\" konnte nicht kopiert werden !", 2);
        }
    }
}
