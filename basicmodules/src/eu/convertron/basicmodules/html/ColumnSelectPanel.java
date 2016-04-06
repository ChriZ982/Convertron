package eu.convertron.basicmodules.html;

import eu.convertron.basicmodules.html.serialization.DesignConfiguration;
import eu.convertron.basicmodules.html.serialization.DesignDeserilization;
import eu.convertron.basicmodules.html.serialization.DesignSerialization;
import eu.convertron.interlib.data.GeneralConfigFile;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.io.TextFile;
import java.awt.EventQueue;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ColumnSelectPanel extends View
{
    private HashMap<String, Column> columns;
    private GeneralConfigFile designXml;

    public ColumnSelectPanel(GeneralConfigFile designXml)
    {
        initComponents();

        columns = new HashMap<String, Column>();

        this.designXml = designXml;
        designXml.addConifgFileListener((v) -> reload());

        reload();
    }

    public void reload()
    {
        loadDesign();
        reloadTable();
    }

    private void loadDesign()
    {
        TextFile textFile = new TextFile("./debug./Data/design.xml");
        DesignDeserilization deserilization = new DesignDeserilization(textFile.readAllToString().replaceAll("\n", ""));
        DesignConfiguration config = deserilization.getDesign();

        columns.putAll(config.getColums());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        columnScrollPane = new javax.swing.JScrollPane();
        columnTable = new javax.swing.JTable();
        editColumnLabel = new javax.swing.JLabel();
        importNameLabel = new javax.swing.JLabel();
        importNameTextField = new javax.swing.JTextField();
        exportNameLabel = new javax.swing.JLabel();
        exportNameTextField = new javax.swing.JTextField();
        positionLabel = new javax.swing.JLabel();
        positionTextField = new javax.swing.JTextField();
        widthLabel = new javax.swing.JLabel();
        widthTextField = new javax.swing.JTextField();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        sumWidthLabel = new javax.swing.JLabel();
        valueSumWidthLabel = new javax.swing.JLabel();
        checkSumLabel = new javax.swing.JLabel();

        columnTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Importname", "Exportname", "Position", "Breite"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        columnTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        columnTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                columnTableMouseReleased(evt);
            }
        });
        columnTable.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                columnTableKeyReleased(evt);
            }
        });
        columnScrollPane.setViewportView(columnTable);

        editColumnLabel.setText("Spalten bearbeiten:");

        importNameLabel.setText("Importname");

        exportNameLabel.setText("Exportname");

        positionLabel.setText("Position");

        widthLabel.setText("Breite");

        newButton.setText("Neu");
        newButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newButtonActionPerformed(evt);
            }
        });

        editButton.setText("Ändern");
        editButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Löschen");
        deleteButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteButtonActionPerformed(evt);
            }
        });

        sumWidthLabel.setText("Gesamte Breite:");

        valueSumWidthLabel.setText("0");

        checkSumLabel.setText("✓");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(columnScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(sumWidthLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(valueSumWidthLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(checkSumLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(importNameLabel)
                                    .addGap(10, 10, 10)
                                    .addComponent(importNameTextField)
                                    .addGap(10, 10, 10)
                                    .addComponent(exportNameLabel)
                                    .addGap(10, 10, 10)
                                    .addComponent(exportNameTextField)
                                    .addGap(10, 10, 10)
                                    .addComponent(positionLabel)
                                    .addGap(10, 10, 10)
                                    .addComponent(positionTextField)
                                    .addGap(10, 10, 10)
                                    .addComponent(widthLabel)
                                    .addGap(10, 10, 10)
                                    .addComponent(widthTextField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(newButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(10, 10, 10)
                                    .addComponent(editButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(10, 10, 10)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addComponent(editColumnLabel))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(columnScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sumWidthLabel)
                    .addComponent(valueSumWidthLabel)
                    .addComponent(checkSumLabel))
                .addGap(10, 10, 10)
                .addComponent(editColumnLabel)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importNameLabel)
                    .addComponent(importNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportNameLabel)
                    .addComponent(exportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positionLabel)
                    .addComponent(positionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(widthLabel)
                    .addComponent(widthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(editButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newButtonActionPerformed
    {//GEN-HEADEREND:event_newButtonActionPerformed
        columns.put(importNameTextField.getText(),
                    new Column(exportNameTextField.getText(),
                               Integer.parseInt(positionTextField.getText()),
                               Double.parseDouble(widthTextField.getText())));

        reloadTable();
    }//GEN-LAST:event_newButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editButtonActionPerformed
    {//GEN-HEADEREND:event_editButtonActionPerformed
        Column column = columns.get(importNameTextField.getText());
        column.setName(exportNameTextField.getText());
        column.setPosition(Integer.parseInt(positionTextField.getText()));
        column.setWidth(Double.parseDouble(widthTextField.getText()));

        reloadTable();
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteButtonActionPerformed
    {//GEN-HEADEREND:event_deleteButtonActionPerformed
        columns.remove(importNameTextField.getText());

        reloadTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void columnTableKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_columnTableKeyReleased
    {//GEN-HEADEREND:event_columnTableKeyReleased
        select();
    }//GEN-LAST:event_columnTableKeyReleased

    private void columnTableMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_columnTableMouseReleased
    {//GEN-HEADEREND:event_columnTableMouseReleased
        select();
    }//GEN-LAST:event_columnTableMouseReleased

    private void checkSum()
    {
        double width = 0;
        for(Column column : columns.values())
        {
            width += column.getWidth();
        }

        valueSumWidthLabel.setText(width + "%");

        if(width == 100.0)
        {
            checkSumLabel.setText("<html><font color=\"green\">✓</font></html>");
        }
        else if(width < 100.0)
        {
            checkSumLabel.setText("<html><font color=\"red\">✗ " + width + "% &lt; 100% Bitte wählen Sie größere Breiten!</font></html>");
        }
        else if(width > 100.0)
        {
            checkSumLabel.setText("<html><font color=\"red\">✗ " + width + "% &gt; 100% Bitte wählen Sie kleinere Breiten!</font></html>");
        }
    }

    private void reloadTable()
    {
        TextFile textFile = new TextFile("./debug./Data/design.xml");
        DesignDeserilization deserilization = new DesignDeserilization(textFile.readAllToString().replaceAll("\n", ""));
        DesignConfiguration config = deserilization.getDesign();
        config.setColums(columns);

        DesignSerialization serialization = new DesignSerialization(config);
        serialization.copyTo(new File("./debug./Data/design.xml"));

        EventQueue.invokeLater(()
                ->
                {
                    DefaultTableModel model = (DefaultTableModel)columnTable.getModel();
                    model.setRowCount(0);

                    for(Map.Entry<String, Column> column : columns.entrySet())
                    {
                        String[] columnRow = column.getValue().toRow();
                        String[] row = new String[columnRow.length + 1];
                        row[0] = column.getKey();
                        System.arraycopy(columnRow, 0, row, 1, columnRow.length);
                        model.addRow(row);
                    }
        });

        checkSum();
    }

    private void select()
    {
        int row = columnTable.getSelectedRow();

        importNameTextField.setText(String.valueOf(columnTable.getValueAt(row, 0)));
        exportNameTextField.setText(String.valueOf(columnTable.getValueAt(row, 1)));
        positionTextField.setText(String.valueOf(columnTable.getValueAt(row, 2)));
        widthTextField.setText(String.valueOf(columnTable.getValueAt(row, 3)));
    }

    public HashMap<String, Column> getColumns()
    {
        return columns;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel checkSumLabel;
    private javax.swing.JScrollPane columnScrollPane;
    private javax.swing.JTable columnTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel editColumnLabel;
    private javax.swing.JLabel exportNameLabel;
    private javax.swing.JTextField exportNameTextField;
    private javax.swing.JLabel importNameLabel;
    private javax.swing.JTextField importNameTextField;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JTextField positionTextField;
    private javax.swing.JLabel sumWidthLabel;
    private javax.swing.JLabel valueSumWidthLabel;
    private javax.swing.JLabel widthLabel;
    private javax.swing.JTextField widthTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabTitle()
    {
        return "Spalten verwalten";
    }
}
