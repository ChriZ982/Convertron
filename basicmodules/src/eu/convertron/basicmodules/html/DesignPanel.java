package eu.convertron.basicmodules.html;

import eu.convertron.interlib.interfaces.View;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class DesignPanel extends View
{
    private HashMap<String, DesignItem> designItems;

    public DesignPanel()
    {
        initComponents();

        designItems = new HashMap<String, DesignItem>();
        loadDesign();

        reloadTable();
    }

    private void loadDesign()
    {
        designItems.put("FRAME_BORDER_COLOR", new DesignItem("Plan Rahmenfarbe", DesignItemType.COLOR, "#004A80"));

        designItems.put("MOTD_HEIGHT", new DesignItem("Laufschrift Höhe", DesignItemType.NUMBER, "80px"));

        designItems.put("MOTD_FONT_STYLE", new DesignItem("Laufschrift Schriftstil", DesignItemType.FONTSTYLE, "bold"));
        designItems.put("MOTD_FONT_SIZE", new DesignItem("Laufschrift Schrifgröße", DesignItemType.FONTSIZE, "60px"));
        designItems.put("MOTD_FONT_FAMILY", new DesignItem("Laufschrift Schriftart", DesignItemType.FONTFAMILY, "calibri"));
        designItems.put("MOTD_BACK_COLOR", new DesignItem("Laufschrift Hintergrundfarbe", DesignItemType.COLOR, "#517C94"));
        designItems.put("MOTD_OPACITY", new DesignItem("Laufschrift Deckkraft", DesignItemType.NUMBER, "0.9"));

        designItems.put("MOTD_SPEED", new DesignItem("Laufschrift Geschwindigkeit", DesignItemType.NUMBER, "2s"));

        designItems.put("MOTD_TEXT_RIGHT_SPACE", new DesignItem("Laufschrift rechter Textabstand", DesignItemType.NUMBER, "200px"));

        designItems.put("MOTD_TEXT_LEFT_SPACE", new DesignItem("Laufschrift linker Textabstand", DesignItemType.NUMBER, "50px"));

        designItems.put("DAY_BACK_COLOR", new DesignItem("Tag Hintergrundfarbe", DesignItemType.COLOR, "#026398"));
        designItems.put("DAY_SIDE_SPACE", new DesignItem("Tag Seitenabstand", DesignItemType.NUMBER, "3px"));

        designItems.put("DAY_SPEED", new DesignItem("Tag Geschwindigkeit", DesignItemType.NUMBER, "3s"));

        designItems.put("DAY_HEADER_HEIGHT", new DesignItem("Tag Überschrift Höhe", DesignItemType.NUMBER, "80px"));

        designItems.put("DAY_TABLES_BOTTOM_SPACE", new DesignItem("Tabellen unterer Abstand", DesignItemType.NUMBER, "200px"));

        designItems.put("DAY_HEADER_BACK_COLOR", new DesignItem("Tag Überschrift Hintergrundfarbe", DesignItemType.COLOR, "#517C94"));
        designItems.put("DAY_HEADER_OPACITY", new DesignItem("Tag Überschrift Deckkraft", DesignItemType.NUMBER, "0.9"));

        designItems.put("DAY_DATE_FONT_STYLE", new DesignItem("Überschrift Schriftstil", DesignItemType.FONTSTYLE, "bold"));
        designItems.put("DAY_DATE_FONT_SIZE", new DesignItem("Überschrift Schrifgröße", DesignItemType.FONTSIZE, "30px"));
        designItems.put("DAY_DATE_FONT_FAMILY", new DesignItem("Überschrift Schriftart", DesignItemType.FONTFAMILY, "calibri"));
        designItems.put("DAY_DATE_TEXT_SPACE", new DesignItem("Überschrift Textabstand", DesignItemType.NUMBER, "50px"));

        designItems.put("DAY_TABLE_FONT_STYLE", new DesignItem("Tabelle Schriftstil", DesignItemType.FONTSTYLE, ""));
        designItems.put("DAY_TABLE_FONT_SIZE", new DesignItem("Tabelle Schrifgröße", DesignItemType.FONTSIZE, "16px"));
        designItems.put("DAY_TABLE_FONT_FAMILY", new DesignItem("Tabelle Schriftart", DesignItemType.FONTFAMILY, "calibri"));
        designItems.put("DAY_TABLE_FONT_COLOR", new DesignItem("Tabelle Schriftfarbe", DesignItemType.FONTCOLOR, "#000000"));
        designItems.put("DAY_TABLE_BORDER_WIDTH", new DesignItem("Tabelle Rahmenbreite", DesignItemType.NUMBER, "3px"));
        designItems.put("DAY_TABLE_BORDER_COLOR", new DesignItem("Tabelle Rahmenfarbe", DesignItemType.COLOR, "#474747"));
        designItems.put("DAY_TABLE_BACK_COLOR", new DesignItem("Tabelle Hintergrundfarbe", DesignItemType.COLOR, "#e7e7e7"));
        designItems.put("DAY_TABLES_SPACE", new DesignItem("Tabelle Abstand", DesignItemType.NUMBER, "10px"));

        designItems.put("DAY_CLASS_FONT_STYLE", new DesignItem("Klassenname Schriftstil", DesignItemType.FONTSTYLE, "bold"));
        designItems.put("DAY_CLASS_FONT_SIZE", new DesignItem("Klassenname Schrifgröße", DesignItemType.FONTSIZE, "30px"));
        designItems.put("DAY_CLASS_FONT_FAMILY", new DesignItem("Klassenname Schriftart", DesignItemType.FONTFAMILY, "calibri"));
        designItems.put("DAY_CLASS_FONT_COLOR", new DesignItem("Klassenname Schriftfarbe", DesignItemType.FONTCOLOR, "#000000"));

        designItems.put("DAY_TABLE_INNER_BORDER_WIDTH", new DesignItem("Tabelle innere Rahmenbreite", DesignItemType.NUMBER, "1px"));
        designItems.put("DAY_TABLE_INNER_BORDER_COLOR", new DesignItem("Tabelle innere Rahmenfarbe", DesignItemType.FONTCOLOR, "#000000"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        designItemsScrollPane = new javax.swing.JScrollPane();
        designItemsTable = new javax.swing.JTable();
        changeValueLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        valueLabel = new javax.swing.JLabel();
        valueTextField = new javax.swing.JTextField();
        changeValueButton = new javax.swing.JButton();

        designItemsTable.setAutoCreateRowSorter(true);
        designItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "ID", "Bezeichnung", "Art", "Wert", "Beispiel"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        designItemsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        designItemsTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                designItemsTableMouseReleased(evt);
            }
        });
        designItemsTable.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                designItemsTableKeyReleased(evt);
            }
        });
        designItemsScrollPane.setViewportView(designItemsTable);

        changeValueLabel.setText("Wert ändern:");

        nameLabel.setText("ID");

        nameTextField.setEditable(false);

        valueLabel.setText("Wert");

        changeValueButton.setText("Ändern");
        changeValueButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                changeValueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(designItemsScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(nameLabel)
                .addGap(10, 10, 10)
                .addComponent(nameTextField)
                .addGap(10, 10, 10)
                .addComponent(valueLabel)
                .addGap(10, 10, 10)
                .addComponent(valueTextField)
                .addGap(10, 10, 10)
                .addComponent(changeValueButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(changeValueLabel)
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(designItemsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(changeValueLabel)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel)
                    .addComponent(valueLabel)
                    .addComponent(changeValueButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void changeValueButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_changeValueButtonActionPerformed
    {//GEN-HEADEREND:event_changeValueButtonActionPerformed
        designItems.get(nameTextField.getText()).setValue(valueTextField.getText());

        reloadTable();
    }//GEN-LAST:event_changeValueButtonActionPerformed

    private void designItemsTableKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_designItemsTableKeyReleased
    {//GEN-HEADEREND:event_designItemsTableKeyReleased
        select();
    }//GEN-LAST:event_designItemsTableKeyReleased

    private void designItemsTableMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_designItemsTableMouseReleased
    {//GEN-HEADEREND:event_designItemsTableMouseReleased
        select();
    }//GEN-LAST:event_designItemsTableMouseReleased

    private void reloadTable()
    {
        EventQueue.invokeLater(() ->
        {
            DefaultTableModel model = (DefaultTableModel)designItemsTable.getModel();
            model.setRowCount(0);

            for(Entry<String, DesignItem> design : designItems.entrySet())
            {
                String[] designRow = design.getValue().toRow();
                String[] row = new String[designRow.length + 1];
                row[0] = design.getKey();
                System.arraycopy(designRow, 0, row, 1, designRow.length);
                model.addRow(row);
            }
        });
    }

    private void select()
    {
        int row = designItemsTable.getSelectedRow();

        nameTextField.setText(String.valueOf(designItemsTable.getValueAt(row, 0)));
        valueTextField.setText(String.valueOf(designItemsTable.getValueAt(row, 3)));
    }

    public HashMap<String, DesignItem> getDesignItems()
    {
        return designItems;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeValueButton;
    private javax.swing.JLabel changeValueLabel;
    private javax.swing.JScrollPane designItemsScrollPane;
    private javax.swing.JTable designItemsTable;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTextField valueTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabTitle()
    {
        return "Allgemeine Einstellungen";
    }
}
