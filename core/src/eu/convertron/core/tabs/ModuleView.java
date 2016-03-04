package eu.convertron.core.tabs;

import eu.convertron.applib.gui.ModuleListRenderer;
import eu.convertron.interlib.interfaces.Input;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.interfaces.View;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class ModuleView extends View
{
    private DefaultListModel<Output> activeOutputModulesListModel;
    private DefaultListModel<Output> availableOutputModulesListModel;
    private DefaultComboBoxModel<Input> availableInputModulesComboModel;

    public ModuleView(Collection<Output> allOutputs, Collection<Output> activeOutputs, Collection<Input> allInputs, Input activeInput)
    {
        ArrayList<Output> availableOutputs = new ArrayList<>(allOutputs);
        availableOutputs.removeAll(activeOutputs);
        activeOutputModulesListModel = new DefaultListModel<>();
        availableOutputModulesListModel = new DefaultListModel<>();
        addElementsToModel(activeOutputModulesListModel, activeOutputs);
        addElementsToModel(availableOutputModulesListModel, availableOutputs);

        availableInputModulesComboModel = new DefaultComboBoxModel<>();
        addElementsToModel(availableInputModulesComboModel, allInputs);
        availableInputModulesComboModel.setSelectedItem(activeInput);

        initComponents();

        activeOutputModulesList.setCellRenderer(new ModuleListRenderer());
        availableOutputModulesList.setCellRenderer(new ModuleListRenderer());
        activeInputModuleComboBox.setRenderer(new ModuleListRenderer());
    }

    @SuppressWarnings(
            {
                "unchecked", "deprecation"
            })
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        availableOutputModulesScrollPane = new javax.swing.JScrollPane();
        availableOutputModulesList = new javax.swing.JList<>(availableOutputModulesListModel);
        availableOutputModulesLabel = new javax.swing.JLabel();
        activeOutputModulesScrollPane = new javax.swing.JScrollPane();
        activeOutputModulesList = new javax.swing.JList<>(activeOutputModulesListModel);
        activateButton = new javax.swing.JButton();
        deactivateButton = new javax.swing.JButton();
        activeOutputModulesLabel = new javax.swing.JLabel();
        activeInputModuleComboBox = new javax.swing.JComboBox<>(availableInputModulesComboModel);
        jSeparator1 = new javax.swing.JSeparator();
        activeInputModuleLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        saveButton = new javax.swing.JButton();

        availableOutputModulesScrollPane.setViewportView(availableOutputModulesList);

        availableOutputModulesLabel.setText("Verfügbare Output Module");

        activeOutputModulesScrollPane.setViewportView(activeOutputModulesList);

        activateButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        activateButton.setText("→");
        activateButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                activateButtonActionPerformed(evt);
            }
        });

        deactivateButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        deactivateButton.setLabel("←");
        deactivateButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deactivateButtonActionPerformed(evt);
            }
        });

        activeOutputModulesLabel.setText("Aktive Output Module");

        activeInputModuleLabel.setText("Aktives Input Modul");

        saveButton.setText("Speichern");
        saveButton.setToolTipText("Speichert die Änderungen, damit sie nach einem Neustart erhalten bleiben");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(activeInputModuleLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(activeInputModuleComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(availableOutputModulesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(availableOutputModulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activateButton)
                            .addComponent(deactivateButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeOutputModulesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(activeOutputModulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableOutputModulesLabel)
                    .addComponent(activeOutputModulesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(activeOutputModulesScrollPane)
                    .addComponent(availableOutputModulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(activateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deactivateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(activeInputModuleLabel)
                    .addComponent(activeInputModuleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deactivateButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deactivateButtonActionPerformed
    {//GEN-HEADEREND:event_deactivateButtonActionPerformed
        List<Output> selected = activeOutputModulesList.getSelectedValuesList();
        for(Output out : selected)
        {
            availableOutputModulesListModel.addElement(out);
            activeOutputModulesListModel.removeElement(out);
        }
    }//GEN-LAST:event_deactivateButtonActionPerformed

    private void activateButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_activateButtonActionPerformed
    {//GEN-HEADEREND:event_activateButtonActionPerformed
        List<Output> selected = availableOutputModulesList.getSelectedValuesList();
        for(Output out : selected)
        {
            activeOutputModulesListModel.addElement(out);
            availableOutputModulesListModel.removeElement(out);
        }
    }//GEN-LAST:event_activateButtonActionPerformed

    public void addSaveListener(Runnable task)
    {
        saveButton.addActionListener((ActionEvent e) -> EventQueue.invokeLater(task));
    }

    public ArrayList<Output> getActiveOutputModules()
    {
        return new ArrayList<>(Collections.list(activeOutputModulesListModel.elements()));
    }

    public Input getActiveInputModule()
    {
        return (Input)availableInputModulesComboModel.getSelectedItem();
    }

    @Override
    public String getTabTitle()
    {
        return "Aktive Module wählen";
    }

    private static <T> void addElementsToModel(DefaultComboBoxModel<T> model, Collection<T> elements)
    {
        for(T element : elements)
        {
            model.addElement(element);
        }
    }

    private static <T> void addElementsToModel(DefaultListModel<T> model, Collection<T> elements)
    {
        for(T element : elements)
        {
            model.addElement(element);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activateButton;
    private javax.swing.JComboBox<Input> activeInputModuleComboBox;
    private javax.swing.JLabel activeInputModuleLabel;
    private javax.swing.JLabel activeOutputModulesLabel;
    private javax.swing.JList<Output> activeOutputModulesList;
    private javax.swing.JScrollPane activeOutputModulesScrollPane;
    private javax.swing.JLabel availableOutputModulesLabel;
    private javax.swing.JList<Output> availableOutputModulesList;
    private javax.swing.JScrollPane availableOutputModulesScrollPane;
    private javax.swing.JButton deactivateButton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
