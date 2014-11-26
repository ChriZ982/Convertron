package com.facharbeit.main;

import com.facharbeit.io.FileWriter;
import com.facharbeit.io.HtmlReader;
import com.facharbeit.io.HtmlWriter;
import com.facharbeit.io.Settings;
import com.facharbeit.main.*;
import java.awt.*;
import java.awt.event.*;
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
        Settings.save("planSpeed", speedPlanTxt.getText());
    }

    public static void setSpeedMotdBtnActionPerformed(JTextField speedMotdTxt)
    {
        Settings.save("motdSpeed", speedMotdTxt.getText());
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

    public static void loadSettings(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea, JTextField speedPlanTxt, JTextField speedMotdTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo, JTextField motdTxt)
    {
        load(sourceTxt, "sourcePath");
        load(backupTxt, "backupPath");
        load(motdTxt, "motdText");

        String name = "destPath1";
        if(Settings.getLineOf(name) == -1)
            Settings.load(name);

        for(int i = 1; Settings.getLineOf(name) != -1; i++)
        {
            String s = Settings.load(name);
            destArea.append(s + "\n");
            name = "destPath" + (i + 1);
        }

        load(speedPlanTxt, "planSpeed");
        load(speedMotdTxt, "motdSpeed");

        loadColors(colorPlanCombo, colorMotdCombo);
    }

    private static void loadColors(JComboBox colorPlanCombo, JComboBox colorMotdCombo)
    {
        colorPlanCombo.removeAllItems();
        colorMotdCombo.removeAllItems();

        String[] colors = Settings.giveMultiple("color");
        for(String s : colors)
            if(!s.equals("colorPlan") && !s.equals("colorMotd"))
            {
                colorPlanCombo.addItem(s.substring(5));
                colorMotdCombo.addItem(s.substring(5));

            }

        colorPlanCombo.setSelectedItem(Settings.load("colorPlan"));
        colorMotdCombo.setSelectedItem(Settings.load("colorMotd"));
    }

    public static void genAllBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.readInToday());
        HtmlWriter.generatePlanTomorrow(HtmlReader.readInTomorrow());
        HtmlWriter.generateModt();
    }

    public static void genTodayBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.readInToday());
    }

    public static void genTomorrowBtnActionPerformed()
    {
        HtmlWriter.generatePlanTomorrow(HtmlReader.readInTomorrow());
    }

    public static void createBackupBtnActionPerformed()
    {
        String path = Settings.load("backupPath") + "\\";

        FileWriter writer1 = new FileWriter("Data/", "heute.html");
        writer1.copy(path);

        FileWriter writer2 = new FileWriter("Data/", "morgen.html");
        writer2.copy(path);

        FileWriter writer3 = new FileWriter("Data/", "laufschrift.html");
        writer3.copy(path);

        FileWriter writer4 = new FileWriter("Data/", "beide.html");
        writer4.copy(path);

        FileWriter writer5 = new FileWriter("Data/", "style.css");
        writer5.copy(path);

        FileWriter writer6 = new FileWriter("Data/", "settings.ini");
        writer6.copy(path);
    }

    public static void deleteSourceBtnActionPerformed()
    {
        //TODO
    }

    public static void genMotdBtnActionPerformed(JTextField motdTxt)
    {
        Settings.save("motdText", motdTxt.getText());

        HtmlWriter.generateModt();
    }

    public static void deleteMotdBtnActionPerformed(JTextField motdTxt)
    {
        motdTxt.setText("");
        Settings.save("motdText", motdTxt.getText());
    }

    public static void SQLsaveBtnActionPerformed(JTextField dbHostTxt, JTextField dbPortTxt, JTextField dbNameTxt, JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt)
    {
        Settings.save("dbHost", dbHostTxt.getText());
        Settings.save("dbPort", dbPortTxt.getText());
        Settings.save("dbName", dbNameTxt.getText());
        Settings.save("dbUser", dbUserTxt.getText());
        Settings.save("dbPassw", dbPwTxt.getText());
        Settings.save("dbTableName", dbTableNameTxt.getText());
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
}
