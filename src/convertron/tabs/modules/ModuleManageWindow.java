package convertron.tabs.modules;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class ModuleManageWindow extends javax.swing.JFrame
{
    private static final long serialVersionUID = 1L;

    public ModuleManageWindow()
    {
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
        modulesInJarList = new javax.swing.JList<ClassLocation>();
        jarFileTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chooseJarBtn = new javax.swing.JButton();
        openJarBtn = new javax.swing.JButton();
        importModuleBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        allModulesList = new javax.swing.JList<ClassLocation>();
        removeModuleBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveAndCloseBtn = new javax.swing.JButton();
        saveProgBar = new javax.swing.JProgressBar();

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

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane2.setViewportView(allModulesList);

        removeModuleBtn.setText("entfernen");

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
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(saveProgBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeModuleBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveAndCloseBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveProgBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseJarBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chooseJarBtnActionPerformed
    {//GEN-HEADEREND:event_chooseJarBtnActionPerformed
        if(jarFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            jarFileTxt.setText(jarFileChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_chooseJarBtnActionPerformed

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new ModuleManageWindow().setVisible(true);
            }
        });
    }

    public void setFileOpened(boolean opened)
    {
        importModuleBtn.setEnabled(opened);
        modulesInJarList.setEnabled(opened);
    }

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
    private javax.swing.JProgressBar saveProgBar;
    // End of variables declaration//GEN-END:variables
}
