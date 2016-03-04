package eu.convertron.basicmodules.html;

import eu.convertron.basicmodules.html.serialization.DesignConfiguration;
import eu.convertron.basicmodules.html.serialization.DesignDeserilization;
import eu.convertron.basicmodules.html.serialization.DesignSerialization;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.io.TextFile;
import java.awt.EventQueue;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CustomDesignPanel extends View
{
    private HashMap<String, HashMap<String, CustomDesignItem>> designItems;

    public CustomDesignPanel()
    {
        initComponents();

        designItems = new HashMap<String, HashMap<String, CustomDesignItem>>();
        loadDesign();

        reloadTable();
    }

    private void loadDesign()
    {
        TextFile textFile = new TextFile("./debug./Data/design.xml");
        DesignDeserilization deserilization = new DesignDeserilization(textFile.readAllToString().replaceAll("\n", ""));
        DesignConfiguration config = deserilization.getDesign();

        designItems.putAll(config.getCustomDesigns());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        customFormat = new javax.swing.JLabel();
        formatColumnLabel = new javax.swing.JLabel();
        formatColumnTextField = new javax.swing.JTextField();
        formatNameLabel = new javax.swing.JLabel();
        formatNameTextField = new javax.swing.JTextField();
        customDesignItemsScrollPane = new javax.swing.JScrollPane();
        customDesignItemsTable = new javax.swing.JTable();
        newFormatButton = new javax.swing.JButton();
        deleteFormatButton = new javax.swing.JButton();
        customChangeValueLabel = new javax.swing.JLabel();
        customNameLabel = new javax.swing.JLabel();
        customNameTextField = new javax.swing.JTextField();
        customValueLabel = new javax.swing.JLabel();
        customValueTextField = new javax.swing.JTextField();
        customChangeValueButton = new javax.swing.JButton();

        customFormat.setText("Benutzerdefiniertes Format:");

        formatColumnLabel.setText("Spaltenbezeichnung");

        formatNameLabel.setText("Spaltenwert");

        customDesignItemsTable.setAutoCreateRowSorter(true);
        customDesignItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "ID", "Spaltenname", "Spaltenwert", "Bezeichnung", "Art", "Wert", "Beispiel"
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
        customDesignItemsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        customDesignItemsTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                customDesignItemsTableMouseReleased(evt);
            }
        });
        customDesignItemsTable.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                customDesignItemsTableKeyReleased(evt);
            }
        });
        customDesignItemsScrollPane.setViewportView(customDesignItemsTable);

        newFormatButton.setText("Neu");
        newFormatButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newFormatButtonActionPerformed(evt);
            }
        });

        deleteFormatButton.setText("Löschen");
        deleteFormatButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteFormatButtonActionPerformed(evt);
            }
        });

        customChangeValueLabel.setText("Wert ändern:");

        customNameLabel.setText("ID");

        customNameTextField.setEditable(false);

        customValueLabel.setText("Wert");

        customChangeValueButton.setText("Ändern");
        customChangeValueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                customChangeValueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customDesignItemsScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(customNameLabel)
                .addGap(10, 10, 10)
                .addComponent(customNameTextField)
                .addGap(10, 10, 10)
                .addComponent(customValueLabel)
                .addGap(10, 10, 10)
                .addComponent(customValueTextField)
                .addGap(10, 10, 10)
                .addComponent(customChangeValueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(customChangeValueLabel)
                .addGap(529, 529, 529))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customFormat)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(formatColumnLabel)
                        .addGap(10, 10, 10)
                        .addComponent(formatColumnTextField)
                        .addGap(10, 10, 10)
                        .addComponent(formatNameLabel)
                        .addGap(10, 10, 10)
                        .addComponent(formatNameTextField)
                        .addGap(10, 10, 10)
                        .addComponent(newFormatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(deleteFormatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(customFormat)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatNameLabel)
                    .addComponent(formatNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newFormatButton)
                    .addComponent(deleteFormatButton)
                    .addComponent(formatColumnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatColumnLabel))
                .addGap(10, 10, 10)
                .addComponent(customDesignItemsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(customChangeValueLabel)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customValueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(customNameLabel)
                    .addComponent(customValueLabel)
                    .addComponent(customChangeValueButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newFormatButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newFormatButtonActionPerformed
    {//GEN-HEADEREND:event_newFormatButtonActionPerformed
        String name = formatNameTextField.getText();
        String column = formatColumnTextField.getText();

        String key = "CUSTOM_" + column + "_" + name;

        HashMap<String, CustomDesignItem> temp = new HashMap<String, CustomDesignItem>();

        temp.put(key + "_FONT_SIZE", new CustomDesignItem(column, name, name + " Schrifgröße", DesignItemType.FONTSIZE, "16"));
        temp.put(key + "_FONT_FAMILY", new CustomDesignItem(column, name, name + " Schriftart", DesignItemType.FONTFAMILY, "calibri"));
        temp.put(key + "_FONT_STYLE", new CustomDesignItem(column, name, name + " Schriftstil", DesignItemType.FONTSTYLE, ""));
        temp.put(key + "_FONT_COLOR", new CustomDesignItem(column, name, name + " Schriftfarbe", DesignItemType.FONTCOLOR, "000000"));
        temp.put(key + "_BACK_COLOR", new CustomDesignItem(column, name, name + " Hintergrundfarbe", DesignItemType.COLOR, "e7e7e7"));

        designItems.put(key, temp);

        reloadTable();
    }//GEN-LAST:event_newFormatButtonActionPerformed

    private void deleteFormatButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteFormatButtonActionPerformed
    {//GEN-HEADEREND:event_deleteFormatButtonActionPerformed
        String name = formatNameTextField.getText();
        String column = formatColumnTextField.getText();

        designItems.remove("CUSTOM_" + column + "_" + name);

        reloadTable();
    }//GEN-LAST:event_deleteFormatButtonActionPerformed

    private void customChangeValueButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_customChangeValueButtonActionPerformed
    {//GEN-HEADEREND:event_customChangeValueButtonActionPerformed
        String[] name = customNameTextField.getText().split("_");

        designItems.get(name[0] + "_" + name[1] + "_" + name[2]).get(customNameTextField.getText()).setValue(customValueTextField.getText());

        reloadTable();
    }//GEN-LAST:event_customChangeValueButtonActionPerformed

    private void customDesignItemsTableKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_customDesignItemsTableKeyReleased
    {//GEN-HEADEREND:event_customDesignItemsTableKeyReleased
        select();
    }//GEN-LAST:event_customDesignItemsTableKeyReleased

    private void customDesignItemsTableMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_customDesignItemsTableMouseReleased
    {//GEN-HEADEREND:event_customDesignItemsTableMouseReleased
        select();
    }//GEN-LAST:event_customDesignItemsTableMouseReleased

    private void reloadTable()
    {
        TextFile textFile = new TextFile("./debug./Data/design.xml");
        DesignDeserilization deserilization = new DesignDeserilization(textFile.readAllToString().replaceAll("\n", ""));
        DesignConfiguration config = deserilization.getDesign();
        config.setCustomDesigns(designItems);

        DesignSerialization serialization = new DesignSerialization(config);
        serialization.copyTo(new File("./debug./Data/design.xml"));

        EventQueue.invokeLater(()
                ->
                {
                    DefaultTableModel model = (DefaultTableModel)customDesignItemsTable.getModel();
                    model.setRowCount(0);

                    for(HashMap<String, CustomDesignItem> head : designItems.values())
                    {
                        for(Map.Entry<String, CustomDesignItem> design : head.entrySet())
                        {
                            String[] designRow = design.getValue().toRow();
                            String[] row = new String[designRow.length + 1];
                            row[0] = design.getKey();
                            System.arraycopy(designRow, 0, row, 1, designRow.length);
                            model.addRow(row);
                        }
                    }
        });
    }

    private void select()
    {
        int row = customDesignItemsTable.getSelectedRow();

        customNameTextField.setText(String.valueOf(customDesignItemsTable.getValueAt(row, 0)));
        customValueTextField.setText(String.valueOf(customDesignItemsTable.getValueAt(row, 5)));
    }

    public HashMap<String, HashMap<String, CustomDesignItem>> getDesignItems()
    {
        return designItems;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton customChangeValueButton;
    private javax.swing.JLabel customChangeValueLabel;
    private javax.swing.JScrollPane customDesignItemsScrollPane;
    private javax.swing.JTable customDesignItemsTable;
    private javax.swing.JLabel customFormat;
    private javax.swing.JLabel customNameLabel;
    private javax.swing.JTextField customNameTextField;
    private javax.swing.JLabel customValueLabel;
    private javax.swing.JTextField customValueTextField;
    private javax.swing.JButton deleteFormatButton;
    private javax.swing.JLabel formatColumnLabel;
    private javax.swing.JTextField formatColumnTextField;
    private javax.swing.JLabel formatNameLabel;
    private javax.swing.JTextField formatNameTextField;
    private javax.swing.JButton newFormatButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabTitle()
    {
        return "Benutzerdefiniertes Design";
    }
}
