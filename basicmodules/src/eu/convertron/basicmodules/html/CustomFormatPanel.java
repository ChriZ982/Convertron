package eu.convertron.basicmodules.html;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CustomFormatPanel extends javax.swing.JPanel
{
    private static final long serialVersionUID = 4759288764385060125L;

    public CustomFormatPanel()
    {

    }

    public void init()
    {
        initComponents();

        DocumentListener l = new DocumentListener()
        {
            @Override
            public void changedUpdate(DocumentEvent e)
            {
                updateGui();
            }

            @Override
            public void insertUpdate(DocumentEvent e)
            {
                updateGui();
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                updateGui();
            }
        };

        fontSizeTxt.getDocument().addDocumentListener(l);
        fontFamilyTxt.getDocument().addDocumentListener(l);
        fontStyleTxt.getDocument().addDocumentListener(l);
        fontColorTxt.getDocument().addDocumentListener(l);
        backColorTxt.getDocument().addDocumentListener(l);

        setFormat(null);
    }

    public CustomFormat getFormat()
    {
        return new CustomFormat(fontSizeTxt.getText(),
                                fontFamilyTxt.getText(),
                                fontStyleTxt.getText(),
                                fontColorTxt.getText(),
                                backColorTxt.getText());
    }

    @SuppressWarnings("AssignmentToMethodParameter")
    public void setFormat(CustomFormat format)
    {
        if(format == null)
        {
            format = new CustomFormat("", "", "", "", "");
        }

        fontSizeTxt.setText(format.getFontSize());
        fontFamilyTxt.setText(format.getFontFamily());
        fontStyleTxt.setText(format.getFontStyle());
        fontColorTxt.setText(format.getFontColor());
        backColorTxt.setText(format.getBackColor());
    }

    public void setToDefault()
    {
        setFormat(new CustomFormat("16", "calibri", "", "000000", "e7e7e7"));
    }

    private void updateGui()
    {
        fontSizeEx.setText(DesignItemType.FONTSIZE.getExample(fontSizeTxt.getText()));
        fontFamilyEx.setText(DesignItemType.FONTFAMILY.getExample(fontFamilyTxt.getText()));
        fontStyleEx.setText(DesignItemType.FONTSTYLE.getExample(fontStyleTxt.getText()));
        fontColorEx.setText(DesignItemType.FONTCOLOR.getExample(fontColorTxt.getText()));
        backColorEx.setText(DesignItemType.COLOR.getExample(backColorTxt.getText()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new javax.swing.JLabel();
        fontColorTxt = new javax.swing.JTextField();
        fontColorEx = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fontSizeTxt = new javax.swing.JTextField();
        fontSizeEx = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fontFamilyTxt = new javax.swing.JTextField();
        fontFamilyEx = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fontStyleTxt = new javax.swing.JTextField();
        fontStyleEx = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        backColorTxt = new javax.swing.JTextField();
        backColorEx = new javax.swing.JLabel();

        jLabel1.setText("Schriftfarbe");

        jLabel2.setText("Schriftgröße");

        jLabel4.setText("Schriftart");

        jLabel5.setText("Schriftstil");

        jLabel6.setText("Hintergrundfarbe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backColorTxt)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fontColorTxt)
                            .addComponent(fontSizeTxt)
                            .addComponent(fontFamilyTxt)
                            .addComponent(fontStyleTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fontStyleEx, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(fontFamilyEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fontSizeEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fontColorEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(backColorEx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fontColorEx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontColorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fontSizeEx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fontFamilyEx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontFamilyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fontStyleEx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fontStyleTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backColorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backColorEx, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backColorEx;
    private javax.swing.JTextField backColorTxt;
    private javax.swing.JLabel fontColorEx;
    private javax.swing.JTextField fontColorTxt;
    private javax.swing.JLabel fontFamilyEx;
    private javax.swing.JTextField fontFamilyTxt;
    private javax.swing.JLabel fontSizeEx;
    private javax.swing.JTextField fontSizeTxt;
    private javax.swing.JLabel fontStyleEx;
    private javax.swing.JTextField fontStyleTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
