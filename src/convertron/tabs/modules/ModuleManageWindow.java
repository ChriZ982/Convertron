package convertron.tabs.modules;

import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

public class ModuleManageWindow extends javax.swing.JFrame
{
    private static final long serialVersionUID = 1L;

    public ModuleManageWindow(ClassLocation[] allModules)
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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jarFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        modulesInJarList = new javax.swing.JList<ClassLocation>(modulesInJarListModel);
        jarFileTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chooseJarBtn = new javax.swing.JButton();
        openJarBtn = new javax.swing.JButton();
        importModuleBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        allModulesList = new javax.swing.JList<ClassLocation>(allModulesListModel);
        removeModuleBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveAndCloseBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Module verwalten");

        modulesInJarList.setEnabled(false);
        jScrollPane1.setViewportView(modulesInJarList);

        jLabel1.setText(".jar Datei öffnen");

        chooseJarBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                chooseJarBtnActionPerformed(evt);
            }
        });

        openJarBtn.setText("öffnen");

        importModuleBtn.setText("importieren");
        importModuleBtn.setEnabled(false);
        importModuleBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                importModuleBtnActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane2.setViewportView(allModulesList);

        removeModuleBtn.setText("entfernen");
        removeModuleBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeModuleBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Alle Module");

        saveAndCloseBtn.setText("speichern und schließen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveAndCloseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jarFileTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chooseJarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(openJarBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(importModuleBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(removeModuleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jarFileTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseJarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openJarBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importModuleBtn))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeModuleBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveAndCloseBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseJarBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chooseJarBtnActionPerformed
    {//GEN-HEADEREND:event_chooseJarBtnActionPerformed
        if(jarFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            jarFileTxt.setText(jarFileChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_chooseJarBtnActionPerformed

    private void importModuleBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_importModuleBtnActionPerformed
    {//GEN-HEADEREND:event_importModuleBtnActionPerformed
        for(ClassLocation loc : modulesInJarList.getSelectedValuesList())
        {
            allModulesListModel.addElement(loc);
            modulesInJarListModel.removeElement(loc);
        }
    }//GEN-LAST:event_importModuleBtnActionPerformed

    private void removeModuleBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removeModuleBtnActionPerformed
    {//GEN-HEADEREND:event_removeModuleBtnActionPerformed
        for(ClassLocation loc : allModulesList.getSelectedValuesList())
        {
            allModulesListModel.removeElement(loc);
        }
    }//GEN-LAST:event_removeModuleBtnActionPerformed

    public void setFileOpened(boolean opened)
    {
        importModuleBtn.setEnabled(opened);
        modulesInJarList.setEnabled(opened);
    }

    // <editor-fold defaultstate="collapsed" desc="Getter">
    public DefaultListModel<ClassLocation> getAllModulesListModel()
    {
        return allModulesListModel;
    }

    public DefaultListModel<ClassLocation> getModulesInJarListModel()
    {
        return modulesInJarListModel;
    }

    public JTextField getJarFileTxt()
    {
        return jarFileTxt;
    }

    public JButton getOpenJarBtn()
    {
        return openJarBtn;
    }

    public JButton getSaveAndCloseBtn()
    {
        return saveAndCloseBtn;
    }
    // </editor-fold>

    private javax.swing.DefaultListModel<ClassLocation> allModulesListModel;
    private javax.swing.DefaultListModel<ClassLocation> modulesInJarListModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<ClassLocation> allModulesList;
    private javax.swing.JButton chooseJarBtn;
    private javax.swing.JButton importModuleBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JFileChooser jarFileChooser;
    private javax.swing.JTextField jarFileTxt;
    private javax.swing.JList<ClassLocation> modulesInJarList;
    private javax.swing.JButton openJarBtn;
    private javax.swing.JButton removeModuleBtn;
    private javax.swing.JButton saveAndCloseBtn;
    // End of variables declaration//GEN-END:variables
}
