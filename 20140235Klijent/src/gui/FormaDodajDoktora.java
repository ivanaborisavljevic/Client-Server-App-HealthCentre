/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.Doktor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Stefan
 */
public class FormaDodajDoktora extends javax.swing.JFrame {

    private KontrolerKlijent kontrolerKlijent;
    Doktor doktor;
    FormaPretraziDoktora fpd;

    /**
     * Creates new form FormaDodajDoktora
     */
    public FormaDodajDoktora() {
        initComponents();
        initUI();
        btnSacuvajIzmene.setVisible(false);
        btnSacuvaj.setVisible(true);
        kontrolerKlijent = new KontrolerKlijent();
        KontrolerKlijent.ucitajKomboSpecijalizacija(this, cbSpecijalizacija);
        KontrolerKlijent.ucitajKomboSmena(this, cbSmena);
        this.setVisible(true);
    }

    public FormaDodajDoktora(Doktor doktor, FormaPretraziDoktora fpd) {
        initComponents();
        initUI();
        btnSacuvajIzmene.setVisible(false);
        btnSacuvaj.setVisible(true);
        kontrolerKlijent = new KontrolerKlijent();
        KontrolerKlijent.ucitajKomboSpecijalizacija(this, cbSpecijalizacija);
        KontrolerKlijent.ucitajKomboSmena(this, cbSmena);
        this.doktor = doktor;
        this.setVisible(true);
        this.fpd = fpd;
        kontrolerKlijent.srediFormuPrikaziDoktora(doktor, txtImePrezimeDoktora, cbSpecijalizacija, cbSmena, btnSacuvajIzmene, btnSacuvaj, btnOtkazi);
    }
private void initUI() {

        setSize(500, 400);
        centerFrame();
        setTitle("Doktor forma");
    }

    private void centerFrame() {

            Dimension windowSize = getSize();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Point centerPoint = ge.getCenterPoint();

            int dx = centerPoint.x - windowSize.width / 2;
            int dy = centerPoint.y - windowSize.height / 2;    
            setLocation(dx, dy);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSpecijalizacija = new javax.swing.JComboBox<>();
        cbSmena = new javax.swing.JComboBox<>();
        txtImePrezimeDoktora = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvajIzmene = new javax.swing.JButton();
        lblValImePrezime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime i prezime:");

        jLabel2.setText("Specijalizacija:");

        jLabel3.setText("Smena:");

        cbSpecijalizacija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbSmena.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSmena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSmenaActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnSacuvajIzmene.setText("Sacuvaj izmene");
        btnSacuvajIzmene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajIzmeneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(btnSacuvajIzmene)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSacuvaj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnOtkazi)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValImePrezime)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtImePrezimeDoktora)
                        .addComponent(cbSpecijalizacija, 0, 154, Short.MAX_VALUE)
                        .addComponent(cbSmena, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtImePrezimeDoktora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValImePrezime)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSpecijalizacija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSmena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOtkazi)
                    .addComponent(btnSacuvajIzmene))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbSmenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSmenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSmenaActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        // TODO add your handling code here:
        kontrolerKlijent.zapamtiDoktora(fpd.getTblDoktori(),this, txtImePrezimeDoktora, cbSpecijalizacija.getSelectedItem(), cbSmena.getSelectedItem());
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnSacuvajIzmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajIzmeneActionPerformed
        // TODO add your handling code here:
    kontrolerKlijent.sacuvajIzmeneDoktora(fpd.getTblDoktori(),this, doktor, txtImePrezimeDoktora, cbSpecijalizacija.getSelectedItem(), cbSmena.getSelectedItem());
    }//GEN-LAST:event_btnSacuvajIzmeneActionPerformed

    public JLabel getLblValImePrezime() {
        return lblValImePrezime;
    }

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnSacuvajIzmene;
    private javax.swing.JComboBox<Object> cbSmena;
    private javax.swing.JComboBox<Object> cbSpecijalizacija;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblValImePrezime;
    private javax.swing.JTextField txtImePrezimeDoktora;
    // End of variables declaration//GEN-END:variables


    public FormaPretraziDoktora getFpd() {
        return fpd;
    }

    public void setFpd(FormaPretraziDoktora fpd) {
        this.fpd = fpd;
    }
    
    

   
}
