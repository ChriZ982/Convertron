package eu.convertron.core.usercallback;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class MoveConflictDialog extends JDialog
{
    private static final long serialVersionUID = -103274309078433390L;

    public MoveConflictDialog(JFrame parent, String module, String config)
    {
        super(parent, true);
        initComponents();

        moduleLabel.setText(module);
        fileNameLabel.setText(config);
    }

    public void addAbortListener(Runnable listener)
    {
        abortBtn.addActionListener((e) -> listener.run());
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                listener.run();
            }
        });
    }

    public void addDiscardLocalListener(Runnable listener)
    {
        discardLocalBtn.addActionListener((e) -> listener.run());
    }

    public void addOverrideGlobalBtn(Runnable listener)
    {
        overrideGlobalBtn.addActionListener((e) -> listener.run());
    }

    public void addStartMeldListener(Runnable listener)
    {
        startMeldBtn.addActionListener((e) -> listener.run());
    }

    public void addUseMeldResultListener(Runnable listener)
    {
        useMeldResultBtn.addActionListener((e) -> listener.run());
    }

    public void setMeldStarted(boolean meldStarted)
    {
        startMeldBtn.setEnabled(!meldStarted);
        useMeldResultBtn.setEnabled(meldStarted);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        moduleLabel = new javax.swing.JLabel();
        fileNameLabel = new javax.swing.JLabel();
        discardLocalBtn = new javax.swing.JButton();
        overrideGlobalBtn = new javax.swing.JButton();
        startMeldBtn = new javax.swing.JButton();
        useMeldResultBtn = new javax.swing.JButton();
        abortBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Dateikonflikt");

        jLabel1.setText("Folgende Konfigurationsdatei verursacht einen Konflikt:");

        jLabel2.setText("Modul:");

        jLabel3.setText("Konflikt beim Verschieben einer Konfigurationsdatei von lokal nach global!");

        jLabel4.setText("Datei:");

        moduleLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        moduleLabel.setText("<<Modul>>");

        fileNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fileNameLabel.setText("<<Datei>>");

        discardLocalBtn.setText("Lokale Datei verwerfen");

        overrideGlobalBtn.setText("Globale Datei überschreiben");

        startMeldBtn.setText("Die Dateien mit Meld vergleichen");

        useMeldResultBtn.setText("Ergebnis des Meld-Merges verwenden");
        useMeldResultBtn.setEnabled(false);

        abortBtn.setText("Abbrechen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(discardLocalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moduleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fileNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(overrideGlobalBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(startMeldBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(useMeldResultBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(abortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(moduleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fileNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(discardLocalBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overrideGlobalBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startMeldBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(useMeldResultBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(abortBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortBtn;
    private javax.swing.JButton discardLocalBtn;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel moduleLabel;
    private javax.swing.JButton overrideGlobalBtn;
    private javax.swing.JButton startMeldBtn;
    private javax.swing.JButton useMeldResultBtn;
    // End of variables declaration//GEN-END:variables
}
