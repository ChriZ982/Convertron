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
    @SuppressWarnings("empty-statement")
    public static void savePathBtnActionPerformed(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea)
    {
        saveIfNotNull(sourceTxt, "sourcePath");
        saveIfNotNull(backupTxt, "backupPath");

        ArrayList<String> destPaths = new ArrayList<String>();
        destPaths.addAll(Arrays.asList(destArea.getText().split("\n")));

        for(int i = 0; Settings.delete("destPath" + (i + 1)); i++);

        if(!destArea.getText().equals(""))
            for(int i = 0; i < destPaths.size(); i++)
                Settings.save("destPath" + (i + 1), destPaths.get(i));
    }

    public static void setSpeedPlanBtnActionPerformed(JTextField speedPlanTxt)
    {
        saveIfNotNull(speedPlanTxt, "planSpeed");
    }

    public static void setSpeedMotdBtnActionPerformed(JTextField speedMotdTxt)
    {
        saveIfNotNull(speedMotdTxt, "motdSpeed");
    }

    public static void addColorBtnActionPerformed(JColorChooser colorChooser, JTextField colorNameTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo)
    {
        Color c = JColorChooser.showDialog(colorChooser, "Neue Farbe anlegen", Color.BLUE);

        if(c != null)
        {
            Settings.save("color" + colorNameTxt.getText(), "#" + Integer.toHexString(c.getRGB()).substring(2));
            loadColors(colorPlanCombo, colorMotdCombo);
        }
    }

    public static void deleteColorBtnActionPerformed(JTextField colorNameTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo)
    {
        Settings.delete("color" + colorNameTxt.getText());

        loadColors(colorPlanCombo, colorMotdCombo);
    }

    public static void colorPlanComboItemStateChanged(JPanel colorPlanPanel, JComboBox colorPlanCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
            colorPlanPanel.setBackground(Color.decode(Settings.load("color" + colorPlanCombo.getSelectedItem().toString())));
    }

    public static void setColorPlanBtnActionPerformed(JComboBox colorPlanCombo)
    {
        Settings.save("colorPlan", colorPlanCombo.getSelectedItem().toString());
    }

    public static void colorMotdComboItemStateChanged(JPanel colorMotdPanel, JComboBox colorMotdCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
            colorMotdPanel.setBackground(Color.decode(Settings.load("color" + colorMotdCombo.getSelectedItem().toString())));
    }

    public static void setColorMotdBtnActionPerformed(JComboBox colorMotdCombo)
    {
        Settings.save("colorMotd", colorMotdCombo.getSelectedItem().toString());
    }

    public static void SQLModeBtnActionPerformed(JButton SQLModeBtn)
    {
        if(SQLModeBtn.getText().equals("read"))
        {
            Settings.save("SQLMode", "write");
            SQLModeBtn.setText("schreiben");
        } else
        {
            Settings.save("SQLMode", "write");
            SQLModeBtn.setText("schreiben");
        }
    }

    public static void loadSettings(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea, JTextField speedPlanTxt,
                                    JTextField speedMotdTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo,
                                    JTextField motdTxt, JCheckBox useSQLCheck, JTextField dbHostTxt, JTextField dbPortTxt,
                                    JTextField dbNameTxt, JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                    JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt, JTextField hour4Txt,
                                    JTextField hour5Txt, JTextField hour6Txt, JTextField hour7Txt, JTextField hour8Txt,
                                    JTextField hour9Txt, JTextField hour10Txt, JButton SQLModeBtn)
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

        useSQLCheck.setSelected(Boolean.valueOf(Settings.load("useSQL")));

        String name = "destPath1";
        if(Settings.getLineOf(name) == -1)
            Settings.load(name);

        for(int i = 1; Settings.getLineOf(name) != -1; i++)
        {
            String s = Settings.load(name);
            destArea.append(s + "\n");
            name = "destPath" + (i + 1);
        }

        loadColors(colorPlanCombo, colorMotdCombo);

        if(Settings.load("SQLMode").equals("write"))
            SQLModeBtn.setText("schreiben");
        else
            SQLModeBtn.setText("lesen");
    }

    private static void loadColors(JComboBox colorPlanCombo, JComboBox colorMotdCombo)
    {
        colorPlanCombo.removeAllItems();
        colorMotdCombo.removeAllItems();

        String[] colors = Settings.giveMultipleNames("color");
        for(String s : colors)
            if(!s.equals("colorPlan") && !s.equals("colorMotd"))
            {
                colorPlanCombo.addItem(s.substring(5));
                colorMotdCombo.addItem(s.substring(5));

            }

        colorPlanCombo.setSelectedItem(Settings.load("colorPlan"));
        colorMotdCombo.setSelectedItem(Settings.load("colorMotd"));
    }

    public static void useSQLCheckStateChanged(JCheckBox useSQLCheck)
    {
        Settings.logging(false);
        if(!Settings.load("useSQL").equals(String.valueOf(useSQLCheck.isSelected())))
        {
            Settings.logging(true);
            Settings.save("useSQL", String.valueOf(useSQLCheck.isSelected()));
        }
        Settings.logging(true);
    }

    public static void genAllBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.readInToday());
        HtmlWriter.generatePlanTomorrow(HtmlReader.readInTomorrow());
        HtmlWriter.generateModt();
        backupToDestPaths();
    }

    public static void genTodayBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.readInToday());
        backupToDestPaths();
    }

    public static void genTomorrowBtnActionPerformed()
    {
        HtmlWriter.generatePlanTomorrow(HtmlReader.readInTomorrow());
        backupToDestPaths();
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

    public static void genMotdBtnActionPerformed(JTextField motdTxt)
    {
        saveIfNotNull(motdTxt, "motdText");

        HtmlWriter.generateModt();
    }

    public static void deleteMotdBtnActionPerformed(JTextField motdTxt)
    {
        motdTxt.setText("");
        Settings.delete("motdText");
    }

    public static void SQLsaveBtnActionPerformed(JTextField dbHostTxt, JTextField dbPortTxt, JTextField dbNameTxt, JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt)
    {
        saveIfNotNull(dbHostTxt, "dbHost");
        saveIfNotNull(dbPortTxt, "dbPort");
        saveIfNotNull(dbNameTxt, "dbName");
        saveIfNotNull(dbUserTxt, "dbUser");
        saveIfNotNull(dbPwTxt, "dbPassw");
        saveIfNotNull(dbTableNameTxt, "dbTableName");
    }

    public static void hoursSaveBtnActionPerformed(JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt, JTextField hour4Txt, JTextField hour5Txt, JTextField hour6Txt, JTextField hour7Txt, JTextField hour8Txt, JTextField hour9Txt, JTextField hour10Txt)
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
        String[] paths = Settings.giveMultipleValues("destPath");
        for(String path : paths)
            backupAll(path);
    }

    private static void backupAll(String path)
    {
        backup(path, "heute.html", "morgen.html", "laufschrift.html",
               "beide.html", "TEMPLATE heute morgen.html", "TEMPLATE laufschrift.html",
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
