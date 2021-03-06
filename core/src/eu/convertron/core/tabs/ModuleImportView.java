package eu.convertron.core.tabs;

import eu.convertron.applib.modules.ClassLocation;
import eu.convertron.core.Resources;
import eu.convertron.interlib.interfaces.View;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ModuleImportView extends View
{
    private static final long serialVersionUID = 1L;

    public ModuleImportView(Collection<ClassLocation> locationOfImportedModules)
    {
        invokeAndWait(() ->
                {
                    allModulesListModel = new DefaultListModel<>();
                    for(ClassLocation loc : locationOfImportedModules)
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
        changesInfoLabel = new javax.swing.JLabel();

        modulesInJarList.setEnabled(false);
        modulesInJarScrollPane.setViewportView(modulesInJarList);

        openJarLabel.setText("Jar-Datei öffnen");

        chooseJarButton.setIcon(new javax.swing.ImageIcon(Resources.get("ordner.png")));
        chooseJarButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                chooseJarButtonActionPerformed(evt);
            }
        });

        openJarButton.setText("Öffnen");

        importModuleButton.setText("Importieren");
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

        removeModuleButton.setText("Entfernen");
        removeModuleButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeModuleButtonActionPerformed(evt);
            }
        });

        allModulesLabel.setText("Alle Module");

        changesInfoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changesInfoLabel.setText("<html><font color=\"red\">Hinweis: Änderungen werden erst nach einem Neustart der Anwendung wirksam</font></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(changesInfoLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jarFileTextField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseJarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(openJarButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importModuleButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modulesInJarScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(openJarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(allModulesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(removeModuleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(modulesInJarScrollPane)
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
                .addComponent(changesInfoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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
        invokeLater(()
                ->
                {
                    importModuleButton.setEnabled(opened);
                    modulesInJarList.setEnabled(opened);
        });
    }

    public void addChangesMadeListener(Runnable task)
    {
        importModuleButton.addActionListener((ActionEvent e) -> invokeLater(task));
        removeModuleButton.addActionListener((ActionEvent e) -> invokeLater(task));
    }

    public void addOpenJarListener(Runnable task)
    {
        openJarButton.addActionListener((ActionEvent e) -> invokeLater(task));
    }

    public ArrayList<ClassLocation> getAllModules()
    {
        return Collections.list(allModulesListModel.elements());
    }

    public void setModulesInJar(Collection<ClassLocation> modules)
    {
        invokeLater(()
                ->
                {
                    modulesInJarListModel.removeAllElements();
                    for(ClassLocation l : modules)
                    {
                        modulesInJarListModel.addElement(l);
                    }
        });
    }

    public String getJarFile()
    {
        return jarFileTextField.getText();
    }

    @Override
    public String getTabTitle()
    {
        return "Module importieren";
    }

    private javax.swing.DefaultListModel<ClassLocation> allModulesListModel;
    private javax.swing.DefaultListModel<ClassLocation> modulesInJarListModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel allModulesLabel;
    private javax.swing.JList<ClassLocation> allModulesList;
    private javax.swing.JScrollPane allModulesScrollPane;
    private javax.swing.JLabel changesInfoLabel;
    private javax.swing.JButton chooseJarButton;
    private javax.swing.JButton importModuleButton;
    private javax.swing.JFileChooser jarFileChooser;
    private javax.swing.JTextField jarFileTextField;
    private javax.swing.JList<ClassLocation> modulesInJarList;
    private javax.swing.JScrollPane modulesInJarScrollPane;
    private javax.swing.JButton openJarButton;
    private javax.swing.JLabel openJarLabel;
    private javax.swing.JButton removeModuleButton;
    private javax.swing.JSeparator separator1;
    // End of variables declaration//GEN-END:variables
}
