package convertron.core;

import interlib.interfaces.View;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Anzeige-Fenster der Anwendung.
 */
public class Window extends javax.swing.JFrame
{
    /**
     * Zufallsgenerierter Schlüssel
     */
    private static final long serialVersionUID = 1841024231;

    /**
     * Erstellt ein neues Fenster.
     *
     *
     */
    public Window()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        tabs = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Vertretungsplan");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabs.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabs.setToolTipText("");
        tabs.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                tabsStateChanged(evt);
            }
        });
        getContentPane().add(tabs, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabsStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_tabsStateChanged
    {//GEN-HEADEREND:event_tabsStateChanged
        JPanel panel = (JPanel)tabs.getSelectedComponent();
        Dimension size = panel.getMinimumSize();

        getContentPane().setPreferredSize(getDifference(getContentPane(), panel, size));
        tabs.setPreferredSize(getDifference(tabs, panel, size));
        panel.setPreferredSize(size);

        Control.loadWindowPosition();
        pack();
    }//GEN-LAST:event_tabsStateChanged

    private Dimension getDifference(Component greater, Component smaller, Dimension additional)
    {
        return new Dimension(greater.getWidth() - smaller.getWidth() + (int)additional.getWidth(),
                             greater.getHeight() - smaller.getHeight() + (int)additional.getHeight());
    }

    public void addTab(View view)
    {
        tabs.add(view);
        tabs.setTitleAt(tabCount() - 1, view.getTabTitle());
    }

    private int tabCount()
    {
        return tabs.getTabCount();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
