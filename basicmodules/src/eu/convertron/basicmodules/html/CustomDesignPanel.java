package eu.convertron.basicmodules.html;

import eu.convertron.basicmodules.html.serialization.DesignConfiguration;
import eu.convertron.interlib.data.GeneralConfigFile;
import eu.convertron.interlib.interfaces.View;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import static eu.convertron.basicmodules.html.serialization.DesignConfiguration.map;

@SuppressWarnings("serial")
public class CustomDesignPanel extends View
{
    private HashMap<String, CustomDesignItem> designItems;
    private GeneralConfigFile designXml;

    private DefaultListModel<String> listModel;
    private CustomFormatPanel panel;

    public CustomDesignPanel(GeneralConfigFile designXml)
    {
        listModel = new DefaultListModel<>();
        initComponents();
        panel = (CustomFormatPanel)customFormatJPanel;
        panel.init();

        designItems = new HashMap<String, CustomDesignItem>();

        this.designXml = designXml;
        designXml.addConifgFileListener((v) -> reload());

        reload();
    }

    public ArrayList<CustomDesignItem> getAllCustomDesignItems()
    {
        return new ArrayList<>(designItems.values());
    }

    public void reload()
    {
        loadDesign();
    }

    private void loadDesign()
    {
        DesignConfiguration config = DesignConfiguration.deserialize(designXml.loadString());
        designItems.clear();
        designItems.putAll(map(config.getCustomDesigns()));

        listModel.clear();
        for(String key : designItems.keySet())
        {
            listModel.addElement(key);
        }
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
        newFormatButton = new javax.swing.JButton();
        deleteFormatButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>(listModel);
        customFormatJPanel = new CustomFormatPanel();
        saveFormat = new javax.swing.JButton();

        customFormat.setText("Benutzerdefiniertes Format:");

        formatColumnLabel.setText("Spaltenbezeichnung");

        formatNameLabel.setText("Spaltenwert");

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

        list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        customFormatJPanel.setLayout(null);

        saveFormat.setText("Speichere Format");
        saveFormat.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveFormatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customFormat)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(formatColumnLabel)
                        .addGap(10, 10, 10)
                        .addComponent(formatColumnTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(formatNameLabel)
                        .addGap(10, 10, 10)
                        .addComponent(formatNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(newFormatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(deleteFormatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customFormatJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveFormat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(customFormatJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveFormat)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newFormatButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_newFormatButtonActionPerformed
    {//GEN-HEADEREND:event_newFormatButtonActionPerformed
        String name = formatNameTextField.getText();
        String column = formatColumnTextField.getText();

        String key = "CUSTOM_" + column + "_" + name;
        if(!designItems.containsKey(key))
        {
            listModel.addElement(key);
            panel.setToDefault();
            designItems.put(key, new CustomDesignItem(key, column, name, panel.getFormat()));
            list.setSelectedValue(key, true);
        }

        save();
    }//GEN-LAST:event_newFormatButtonActionPerformed

    private void deleteFormatButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteFormatButtonActionPerformed
    {//GEN-HEADEREND:event_deleteFormatButtonActionPerformed
        String name = formatNameTextField.getText();
        String column = formatColumnTextField.getText();

        designItems.remove("CUSTOM_" + column + "_" + name);

        save();
    }//GEN-LAST:event_deleteFormatButtonActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_listValueChanged
    {//GEN-HEADEREND:event_listValueChanged
        if(list.getSelectedValue() == null)
        {
            panel.setFormat(null);
        }
        else
        {
            panel.setFormat(designItems.get(list.getSelectedValue()).getFormat());
        }
    }//GEN-LAST:event_listValueChanged

    private void saveFormatActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveFormatActionPerformed
    {//GEN-HEADEREND:event_saveFormatActionPerformed
        if(list.getSelectedValue() != null)
        {
            designItems.get(list.getSelectedValue()).setFormat(panel.getFormat());
            save();
        }
    }//GEN-LAST:event_saveFormatActionPerformed

    private void save()
    {
        DesignConfiguration config = DesignConfiguration.deserialize(designXml.loadString());
        config.setCustomDesigns(new ArrayList<>(designItems.values()));

        designXml.save(config.serialize());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customFormat;
    private javax.swing.JPanel customFormatJPanel;
    private javax.swing.JButton deleteFormatButton;
    private javax.swing.JLabel formatColumnLabel;
    private javax.swing.JTextField formatColumnTextField;
    private javax.swing.JLabel formatNameLabel;
    private javax.swing.JTextField formatNameTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JButton newFormatButton;
    private javax.swing.JButton saveFormat;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabTitle()
    {
        return "Benutzerdefiniertes Design";
    }
}
