/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.regex.Pattern;
import domen.Pacijent;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import kontroler.KontrolerKlijent;
import modeli.ModelTabelePacijenata;
import modeli.ModelTabelePregleda;

/**
 *
 * @author Ivana
 */
public class FormaDodajPacijenta extends javax.swing.JFrame {

    private KontrolerKlijent kontrolerKlijent;
    Pacijent pacijent;
    FormaPretraziPacijenta fpp;

    /**
     * Creates new form FormaDodajPacijenta
     */
    public FormaDodajPacijenta(FormaPretraziPacijenta fpp) {

        initComponents();
        initUI();
        setVisible(true);

        btnSacuvajIzmene.setVisible(false);
        btnSacuvaj.setVisible(true);
        kontrolerKlijent = new KontrolerKlijent();
        this.fpp = (FormaPretraziPacijenta) fpp;

    }

    public FormaDodajPacijenta(Pacijent pacijent, FormaPretraziPacijenta forma) {
        initComponents();
        initUI();
        setVisible(true);
        btnSacuvajIzmene.setVisible(false);
        btnSacuvaj.setVisible(true);
        kontrolerKlijent = new KontrolerKlijent();
        this.pacijent = pacijent;
        this.fpp = (FormaPretraziPacijenta) forma;
        kontrolerKlijent.srediFormuPrikaziPacijenta(pacijent, txtImePrezime, txtJMBG, txtDatumRodjenja, txtAdresa, txtGrad, txtTelefon, btnSacuvaj, btnSacuvajIzmene, btnOtkazi);
        setVisible(true);
    }

    private void initUI() {

        setSize(500, 700);
        centerFrame();
        setTitle("Pacijent forma");
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

        lblImePrezime = new javax.swing.JLabel();
        txtImePrezime = new javax.swing.JTextField();
        lblDrzava = new javax.swing.JLabel();
        txtJMBG = new javax.swing.JTextField();
        lblDatumRodjenja = new javax.swing.JLabel();
        txtDatumRodjenja = new javax.swing.JTextField();
        lblEvropska = new javax.swing.JLabel();
        txtAdresa = new javax.swing.JTextField();
        lblSvetska = new javax.swing.JLabel();
        txtGrad = new javax.swing.JTextField();
        lblOlimpijske = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        btnSacuvaj = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        btnSacuvajIzmene = new javax.swing.JButton();
        lblJmbgValBrCifara = new javax.swing.JLabel();
        lblJmbgValSamoCifre = new javax.swing.JLabel();
        lblValImePrezime = new javax.swing.JLabel();
        lblValDatumFormat = new javax.swing.JLabel();
        lblValDatumPosleDanas = new javax.swing.JLabel();
        lblValDatumPre1900 = new javax.swing.JLabel();
        lblValJmbgPrazno = new javax.swing.JLabel();
        lblValDatumPrazno = new javax.swing.JLabel();
        lblValAdresaPrazno = new javax.swing.JLabel();
        lblValGradPrazno = new javax.swing.JLabel();
        lblValTelefonPrazno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblImePrezime.setText("Ime i prezime:");

        lblDrzava.setText("JMBG:");

        txtJMBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJMBGActionPerformed(evt);
            }
        });

        lblDatumRodjenja.setText("Datum rodjenja:");

        lblEvropska.setText("Adresa:");

        txtAdresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresaActionPerformed(evt);
            }
        });

        lblSvetska.setText("Grad:");

        lblOlimpijske.setText("Telefon:");

        btnSacuvaj.setText("Sačuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnSacuvajIzmene.setText("Sacuvaj Izmene");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblDatumRodjenja)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImePrezime)
                            .addComponent(lblDrzava)))
                    .addComponent(lblEvropska, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSvetska)
                    .addComponent(lblOlimpijske))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValImePrezime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtImePrezime))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTelefon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValGradPrazno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGrad, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValAdresaPrazno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAdresa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValDatumPre1900, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValDatumPosleDanas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValDatumFormat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValDatumPrazno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJmbgValBrCifara, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValJmbgPrazno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJMBG)
                            .addComponent(lblJmbgValSamoCifre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblValTelefonPrazno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(btnSacuvajIzmene, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(btnSacuvaj)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImePrezime)
                    .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDrzava, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJMBG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValJmbgPrazno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJmbgValBrCifara, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJmbgValSamoCifre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDatumRodjenja)
                    .addComponent(txtDatumRodjenja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValDatumPrazno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValDatumFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblValDatumPosleDanas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValDatumPre1900, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEvropska, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValAdresaPrazno, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSvetska, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGrad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValGradPrazno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOlimpijske)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValTelefonPrazno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSacuvaj)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvajIzmene)
                    .addComponent(btnOtkazi))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtJMBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJMBGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJMBGActionPerformed

    private void txtAdresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresaActionPerformed

    public JLabel getLblValImePrezime() {
        return lblValImePrezime;
    }

    public JLabel getLblValDatumFormat() {
        return lblValDatumFormat;
    }

   

    public JLabel getLblValDatumPre1900() {
        return lblValDatumPre1900;
    }

    public JLabel getLblJmbgValBrCifara() {
        return lblJmbgValBrCifara;
    }

    public JLabel getLblJmbgValSamoCifre() {
        return lblJmbgValSamoCifre;
    }

    public JLabel getLblValDatumPosleDanas() {
        return lblValDatumPosleDanas;
    }

    public JLabel getLblValAdresaPrazno() {
        return lblValAdresaPrazno;
    }

    public JLabel getLblValDatumPrazno() {
        return lblValDatumPrazno;
    }

    public JLabel getLblValGradPrazno() {
        return lblValGradPrazno;
    }

    public JLabel getLblValJmbgPrazno() {
        return lblValJmbgPrazno;
    }

    public JLabel getLblValTelefonPrazno() {
        return lblValTelefonPrazno;
    }


    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        
        getLblValImePrezime().setText("");
        getLblValJmbgPrazno().setText("");
        getLblJmbgValBrCifara().setText("");
        getLblJmbgValSamoCifre().setText("");
        getLblValDatumPrazno().setText("");
        getLblValDatumFormat().setText("");
        getLblValDatumPosleDanas().setText("");
        getLblValDatumPre1900().setText("");
        getLblValAdresaPrazno().setText("");
        getLblValGradPrazno().setText("");
        getLblValTelefonPrazno().setText("");
        kontrolerKlijent.zapamtiPacijenta(this, fpp.getTblPacijenti(), txtImePrezime, txtJMBG, txtDatumRodjenja, txtAdresa, txtGrad, txtTelefon);
        fpp.resetSelection();
        fpp.getTblIstorijaPregleda().setModel(new ModelTabelePregleda());
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
        fpp.setVisible(true);
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnSacuvajIzmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajIzmeneActionPerformed
        // TODO add your handling code here:
        
        getLblValImePrezime().setText("");
        getLblValJmbgPrazno().setText("");
        getLblJmbgValBrCifara().setText("");
        getLblJmbgValSamoCifre().setText("");
        getLblValDatumPrazno().setText("");
        getLblValDatumFormat().setText("");
        getLblValDatumPosleDanas().setText("");
        getLblValDatumPre1900().setText("");
        getLblValAdresaPrazno().setText("");
        getLblValGradPrazno().setText("");
        getLblValTelefonPrazno().setText("");
        kontrolerKlijent.sacuvajIzmenePacijenta(fpp.getTblPacijenti(), this, pacijent, txtImePrezime, txtJMBG, txtDatumRodjenja, txtAdresa, txtGrad, txtTelefon);
    }//GEN-LAST:event_btnSacuvajIzmeneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnSacuvajIzmene;
    private javax.swing.JLabel lblDatumRodjenja;
    private javax.swing.JLabel lblDrzava;
    private javax.swing.JLabel lblEvropska;
    private javax.swing.JLabel lblImePrezime;
    private javax.swing.JLabel lblJmbgValBrCifara;
    private javax.swing.JLabel lblJmbgValSamoCifre;
    private javax.swing.JLabel lblOlimpijske;
    private javax.swing.JLabel lblSvetska;
    private javax.swing.JLabel lblValAdresaPrazno;
    private javax.swing.JLabel lblValDatumFormat;
    private javax.swing.JLabel lblValDatumPosleDanas;
    private javax.swing.JLabel lblValDatumPrazno;
    private javax.swing.JLabel lblValDatumPre1900;
    private javax.swing.JLabel lblValGradPrazno;
    private javax.swing.JLabel lblValImePrezime;
    private javax.swing.JLabel lblValJmbgPrazno;
    private javax.swing.JLabel lblValTelefonPrazno;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtDatumRodjenja;
    private javax.swing.JTextField txtGrad;
    private javax.swing.JTextField txtImePrezime;
    private javax.swing.JTextField txtJMBG;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables

    public FormaPretraziPacijenta getFpp() {
        return fpp;
    }

    public void setFpp(FormaPretraziPacijenta fpp) {
        this.fpp = fpp;
    }
}
