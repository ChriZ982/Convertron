package convertron.tabs.modules;

import interlib.interfaces.View;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ModuleManageView extends View
{
    private static final long serialVersionUID = 1L;

    public ModuleManageView(ClassLocation[] allModules)
    {
        allModulesListModel = new DefaultListModel<>();
        for(ClassLocation loc : allModules)
            allModulesListModel.addElement(loc);

        modulesInJarListModel = new DefaultListModel<>();

        initComponents();

        jarFileChooser.setFileFilter(new FileFilter()
        {
            @Override
            public boolean accept(File f)
            {
                return f.isDirectory() || f.getName().endsWith(".jar");
            }

            @Override
            public String getDescription()
            {
                return "Jar-Dateien";
            }
        });
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

        jarFileChooser = new javax.swing.JFileChooser();
        modulesInJarScrollPane = new javax.swing.JScrollPane();
        modulesInJarList = new javax.swing.JList<ClassLocation>(modulesInJarListModel);
        jarFileTextField = new javax.swing.JTextField();
        openJarLabel = new javax.swing.JLabel();
        chooseJarButton = new javax.swing.JButton();
        openJarButton = new javax.swing.JButton();
        importModuleButton = new javax.swing.JButton();
        separator1 = new javax.swing.JSeparator();
        allModulesScrollPane = new javax.swing.JScrollPane();
        allModulesList = new javax.swing.JList<ClassLocation>(allModulesListModel);
        removeModuleButton = new javax.swing.JButton();
        allModulesLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();

        modulesInJarList.setEnabled(false);
        modulesInJarScrollPane.setViewportView(modulesInJarList);

        openJarLabel.setText(".jar Datei öffnen");

        chooseJarButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                chooseJarButtonActionPerformed(evt);
            }
        });

        openJarButton.setText("öffnen");

        importModuleButton.setText("importieren");
        importModuleButton.setEnabled(false);
        importModuleButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                importModuleButtonActionPerformed(evt);
            }
        });

        separator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        allModulesScrollPane.setViewportView(allModulesList);

        removeModuleButton.setText("entfernen");
        removeModuleButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeModuleButtonActionPerformed(evt);
            }
        });

        allModulesLabel.setText("Alle Module");

        saveButton.setText("speichern");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jarFileTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseJarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(openJarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importModuleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                            .addComponent(modulesInJarScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(openJarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(allModulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(removeModuleButton, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                            .addComponent(allModulesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openJarLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jarFileTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseJarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openJarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modulesInJarScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importModuleButton))
                    .addComponent(separator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(allModulesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(allModulesScrollPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeModuleButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chooseJarButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chooseJarButtonActionPerformed
    {//GEN-HEADEREND:event_chooseJarButtonActionPerformed
        if(jarFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            jarFileTextField.setText(jarFileChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_chooseJarButtonActionPerformed

    private void importModuleButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_importModuleButtonActionPerformed
    {//GEN-HEADEREND:event_importModuleButtonActionPerformed
        for(ClassLocation loc : modulesInJarList.getSelectedValuesList())
        {
            allModulesListModel.addElement(loc);
            modulesInJarListModel.removeElement(loc);
        }
    }//GEN-LAST:event_importModuleButtonActionPerformed

    private void removeModuleButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removeModuleButtonActionPerformed
    {//GEN-HEADEREND:event_removeModuleButtonActionPerformed
        for(ClassLocation loc : allModulesList.getSelectedValuesList())
        {
            allModulesListModel.removeElement(loc);
        }
    }//GEN-LAST:event_removeModuleButtonActionPerformed

    public void setFileOpened(boolean opened)
    {
        importModuleButton.setEnabled(opened);
        modulesInJarList.setEnabled(opened);
    }

    public void addSaveListener(Runnable task)
    {
        saveButton.addActionListener(getActionListenerToRunnable(task));
    }

    public void addOpenJarListener(Runnable task)
    {
        openJarButton.addActionListener(getActionListenerToRunnable(task));
    }

    public ArrayList<ClassLocation> getAllModules()
    {
        return Collections.list(allModulesListModel.elements());
    }

    public void setModulesInJar(Collection<ClassLocation> modules)
    {
        modulesInJarListModel.removeAllElements();
        for(ClassLocation l : modules)
        {
            modulesInJarListModel.addElement(l);
        }
    }

    public String getJarFile()
    {
        return jarFileTextField.getText();
    }

    @Override
    public String getTabTitle()
    {
        return "Module verwalten";
    }

    private javax.swing.DefaultListModel<ClassLocation> allModulesListModel;
    private javax.swing.DefaultListModel<ClassLocation> modulesInJarListModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allModulesLabel;
    private javax.swing.JList<ClassLocation> allModulesList;
    private javax.swing.JScrollPane allModulesScrollPane;
    private javax.swing.JButton chooseJarButton;
    private javax.swing.JButton importModuleButton;
    private javax.swing.JFileChooser jarFileChooser;
    private javax.swing.JTextField jarFileTextField;
    private javax.swing.JList<ClassLocation> modulesInJarList;
    private javax.swing.JScrollPane modulesInJarScrollPane;
    private javax.swing.JButton openJarButton;
    private javax.swing.JLabel openJarLabel;
    private javax.swing.JButton removeModuleButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JSeparator separator1;
    // End of variables declaration//GEN-END:variables
}
