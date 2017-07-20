package eu.convertron.basicmodules.html;

import eu.convertron.interlib.config.GeneralConfigFile;
import eu.convertron.interlib.interfaces.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.swing.table.DefaultTableModel;
import static eu.convertron.basicmodules.html.DesignConfiguration.map;

@SuppressWarnings("serial")
public class DesignPanel extends View
{
    private final HashMap<String, DesignItem> designItems;
    private final GeneralConfigFile designXml;

    public DesignPanel(GeneralConfigFile designXml)
    {
        initComponents();

        designItems = new HashMap<String, DesignItem>();

        this.designXml = designXml;
        designXml.addConfigFileListener((v) -> reload());

        reload();
    }

    public String getValue(String key)
    {
        return designItems.get(key).getValue();
    }

    public ArrayList<DesignItem> getAllDesignItems()
    {
        return new ArrayList<>(designItems.values());
    }

    public void reload()
    {
        loadDesign();
        reloadTable();
    }

    private void loadDesign()
    {
        DesignConfiguration config = DesignConfiguration.deserialize(designXml.loadString());
        designItems.clear();
        designItems.putAll(map(config.getDesignItems()));
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

        saveChanges();
    }//GEN-LAST:event_changeValueButtonActionPerformed

    private void designItemsTableKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_designItemsTableKeyReleased
    {//GEN-HEADEREND:event_designItemsTableKeyReleased
        select();
    }//GEN-LAST:event_designItemsTableKeyReleased

    private void designItemsTableMouseReleased(java.awt.event.MouseEvent evt)//GEN-FIRST:event_designItemsTableMouseReleased
    {//GEN-HEADEREND:event_designItemsTableMouseReleased
        select();
    }//GEN-LAST:event_designItemsTableMouseReleased

    private void saveChanges()
    {
        DesignConfiguration config = DesignConfiguration.deserialize(designXml.loadString());
        config.setDesignItems(new ArrayList<>(designItems.values()));
        designXml.save(config.serialize());
    }

    private void reloadTable()
    {
        invokeLater(()
                ->
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
