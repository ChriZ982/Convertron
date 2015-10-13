package convertron.core;

import interlib.interfaces.View;

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

        tabsPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vertretungsplan");

        tabsPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabsPane.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(tabsPane, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addTab(View view)
    {
        tabsPane.add(view);
        tabsPane.setTitleAt(tabCount() - 1, view.getTabTitle());
    }

    private int tabCount()
    {
        return tabsPane.getTabCount();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabsPane;
    // End of variables declaration//GEN-END:variables
}
