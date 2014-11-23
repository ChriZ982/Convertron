package com.facharbeit.io;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SettingHandler
{
    @SuppressWarnings("empty-statement")
    public static void savePathBtnActionPerformed(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea, ActionEvent evt)
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

    public static void setSpeedPlanBtnActionPerformed(JTextField speedPlanTxt, ActionEvent evt)
    {
        Settings.save("planSpeed", speedPlanTxt.getText());
    }

    public static void setSpeedMotdBtnActionPerformed(JTextField speedMotdTxt, ActionEvent evt)
    {
        Settings.save("motdSpeed", speedMotdTxt.getText());
    }

    public static void addColorBtnActionPerformed(JColorChooser colorChooser, JTextField colorNameTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo, ActionEvent evt)
    {
        Color c = JColorChooser.showDialog(colorChooser, "Neue Farbe anlegen", Color.BLUE);
        Settings.save("color" + colorNameTxt.getText(), "#" + Integer.toHexString(c.getRGB()).substring(2));

        loadColors(colorPlanCombo, colorMotdCombo);
    }

    public static void deleteColorBtnActionPerformed(JTextField colorNameTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo, ActionEvent evt)
    {
        Settings.delete("color" + colorNameTxt.getText());

        loadColors(colorPlanCombo, colorMotdCombo);
    }

    public static void colorPlanComboItemStateChanged(JPanel colorPlanPanel, JComboBox colorPlanCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
            colorPlanPanel.setBackground(Color.decode(Settings.load("color" + colorPlanCombo.getSelectedItem().toString())));
    }

    public static void setColorPlanBtnActionPerformed(JComboBox colorPlanCombo, ActionEvent evt)
    {
        Settings.save("colorPlan", colorPlanCombo.getSelectedItem().toString());
    }

    public static void colorMotdComboItemStateChanged(JPanel colorMotdPanel, JComboBox colorMotdCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
            colorMotdPanel.setBackground(Color.decode(Settings.load("color" + colorMotdCombo.getSelectedItem().toString())));
    }

    public static void setColorMotdBtnActionPerformed(JComboBox colorMotdCombo, ActionEvent evt)
    {
        Settings.save("colorMotd", colorMotdCombo.getSelectedItem().toString());
    }

    public static void loadSettings(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea, JTextField speedPlanTxt, JTextField speedMotdTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo)
    {
        load(sourceTxt, "sourcePath");
        load(backupTxt, "backupPath");

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
