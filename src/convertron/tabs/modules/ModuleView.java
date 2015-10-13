package convertron.tabs.modules;

import interlib.interfaces.Module;
import interlib.interfaces.View;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class ModuleView extends View
{
    private static final long serialVersionUID = 1L;

    public ModuleView(Object[] allOutputs, Object[] activeOutputs, Object[] allInputs, Object activeInput)
    {
        activeOutputModulesListModel = new DefaultListModel<>();
        for(Object activeOutput : activeOutputs)
        {
            if(activeOutput instanceof Module)
                activeOutputModulesListModel.addElement(new ModuleHolder((Module)activeOutput));
        }

        availableOutputModulesListModel = new DefaultListModel<>();
        for(Object availableOutput : allOutputs)
        {
            if(availableOutput instanceof Module)
                if(!Arrays.asList(activeOutputs).contains(availableOutput))
                    availableOutputModulesListModel.addElement(new ModuleHolder((Module)availableOutput));
        }

        availableInputModulesComboModel = new DefaultComboBoxModel<>();
        for(Object input : allInputs)
        {
            if(input instanceof Module)
                availableInputModulesComboModel.addElement(new ModuleHolder((Module)input));
        }

        availableInputModulesComboModel.setSelectedItem(activeInput);

        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        fileChooser = new javax.swing.JFileChooser();
        availableOutputModulesScrollPane = new javax.swing.JScrollPane();
        availableOutputModulesList = new javax.swing.JList<ModuleHolder>(availableOutputModulesListModel);
        availableOutputModulesLabel = new javax.swing.JLabel();
        activeOutputModulesScrollPane = new javax.swing.JScrollPane();
        activeOutputModulesList = new javax.swing.JList<ModuleHolder>(activeOutputModulesListModel);
        activateButton = new javax.swing.JButton();
        deactivateButton = new javax.swing.JButton();
        activeOutputModulesLabel = new javax.swing.JLabel();
        activeInputModuleComboBox = new javax.swing.JComboBox<ModuleHolder>();
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

        saveButton.setText("speichern");
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
                            .addComponent(availableOutputModulesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(availableOutputModulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activateButton)
                            .addComponent(deactivateButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(activeOutputModulesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
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
                    .addComponent(activeOutputModulesScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
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

    private void activateButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_activateButtonActionPerformed
    {//GEN-HEADEREND:event_activateButtonActionPerformed
        List<ModuleHolder> affected = availableOutputModulesList.getSelectedValuesList();
        for(ModuleHolder m : affected)
        {
            activeOutputModulesListModel.addElement(m);
            availableOutputModulesListModel.removeElement(m);
        }
    }//GEN-LAST:event_activateButtonActionPerformed

    private void deactivateButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deactivateButtonActionPerformed
    {//GEN-HEADEREND:event_deactivateButtonActionPerformed
        List<ModuleHolder> affected = activeOutputModulesList.getSelectedValuesList();
        for(ModuleHolder m : affected)
        {
            availableOutputModulesListModel.addElement(m);
            activeOutputModulesListModel.removeElement(m);
        }
    }//GEN-LAST:event_deactivateButtonActionPerformed

    public void addSaveListener(Runnable task)
    {
        saveButton.addActionListener(getActionListenerToRunnable(task));
    }

    public Module[] getActiveOutputModules()
    {
        return enumerationToArray(activeOutputModulesListModel.elements());
    }

    public Module getActiveInputModule()
    {
        return ((ModuleHolder)availableInputModulesComboModel.getSelectedItem()).module;
    }

    private Module[] enumerationToArray(Enumeration<ModuleHolder> modules)
    {
        List<ModuleHolder> list = Collections.list(modules);
        return ModuleHolder.toModule(list.toArray(new ModuleHolder[list.size()]));
    }

    @Override
    public String getTabTitle()
    {
        return "Module";
    }

    private javax.swing.DefaultListModel<ModuleHolder> activeOutputModulesListModel;
    private javax.swing.DefaultListModel<ModuleHolder> availableOutputModulesListModel;
    private javax.swing.DefaultComboBoxModel<ModuleHolder> availableInputModulesComboModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activateButton;
    private javax.swing.JComboBox<ModuleHolder> activeInputModuleComboBox;
    private javax.swing.JLabel activeInputModuleLabel;
    private javax.swing.JLabel activeOutputModulesLabel;
    private javax.swing.JList<ModuleHolder> activeOutputModulesList;
    private javax.swing.JScrollPane activeOutputModulesScrollPane;
    private javax.swing.JLabel availableOutputModulesLabel;
    private javax.swing.JList<ModuleHolder> availableOutputModulesList;
    private javax.swing.JScrollPane availableOutputModulesScrollPane;
    private javax.swing.JButton deactivateButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
