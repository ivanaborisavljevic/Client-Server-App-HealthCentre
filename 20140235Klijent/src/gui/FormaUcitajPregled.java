/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.Lek;
import domen.Pregled;
import domen.Terapija;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javax.swing.JOptionPane;
import kontroler.KontrolerKlijent;
import modeli.ModelTabelePregleda;
import modeli.ModelTabeleTerapija;

/**
 *
 * @author Stefan
 */
public class FormaUcitajPregled extends javax.swing.JFrame {

    private Pregled pregled;
    private FormaPretraziPacijenta fpp;
    private KontrolerKlijent kontrolerKlijent;

    /**
     * Creates new form UcitajPregled
     */
    public FormaUcitajPregled(Pregled pregled, FormaPretraziPacijenta fpp) {

        initComponents();
        initUI();
        this.pregled = pregled;
        this.fpp = fpp;
       

        ModelTabeleTerapija mtt = new ModelTabeleTerapija(new ArrayList<>());
        tblTerapija.setModel(mtt);
        kontrolerKlijent = new KontrolerKlijent();
        kontrolerKlijent.srediTabeluTerapija(this, tblTerapija);
        srediFormu();

    }

    public Pregled getPregled() {
        return pregled;
    }

    private void initUI() {

        setSize(800, 1000);
        centerFrame();
        setTitle("Pregled forma");
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaOpis = new javax.swing.JTextArea();
        chbNe = new javax.swing.JCheckBox();
        chbDa = new javax.swing.JCheckBox();
        lblRealizovan = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        lblCena = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblDoktor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblVrstaPregleda = new javax.swing.JLabel();
        lblVreme = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPacijent = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTerapija = new javax.swing.JTable();
        btnSacuvajIzmene = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        btnDodajLek = new javax.swing.JButton();
        btnObrisiLek = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtAreaOpis.setColumns(20);
        txtAreaOpis.setRows(5);
        jScrollPane1.setViewportView(txtAreaOpis);

        chbNe.setText("Ne");
        chbNe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbNeActionPerformed(evt);
            }
        });

        chbDa.setText("Da");
        chbDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbDaActionPerformed(evt);
            }
        });

        lblRealizovan.setText("     Realizovan:");

        lblOpis.setText("     Napomena:");

        jLabel5.setText("     Cena:");

        jLabel7.setText("     Doktor:");

        jLabel6.setText("     Vrsta pregleda:");

        jLabel3.setText("     Vreme:");

        jLabel2.setText("     Datum:");

        jLabel1.setText("     Pacijent:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Terapija"));

        tblTerapija.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblTerapija);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSacuvajIzmene.setText("Sačuvaj izmene");
        btnSacuvajIzmene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajIzmeneActionPerformed(evt);
            }
        });

        btnOtkazi.setText("Otkaži");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnDodajLek.setText("Dodaj lek");
        btnDodajLek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajLekActionPerformed(evt);
            }
        });

        btnObrisiLek.setText("Obrisi lek");
        btnObrisiLek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiLekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(284, 284, 284)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDatum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblVreme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPacijent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(245, 245, 245)
                        .addComponent(lblVrstaPregleda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblOpis)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblRealizovan)))
                        .addGap(264, 264, 264)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDoktor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnDodajLek)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnObrisiLek))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(chbDa)
                                            .addGap(99, 99, 99)
                                            .addComponent(chbNe))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnSacuvajIzmene)
                .addGap(127, 127, 127)
                .addComponent(btnOtkazi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblPacijent, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lblDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(lblVreme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVrstaPregleda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDoktor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOpis)
                        .addGap(209, 209, 209)
                        .addComponent(lblRealizovan))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblCena, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chbDa)
                            .addComponent(chbNe))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodajLek)
                    .addComponent(btnObrisiLek))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnSacuvajIzmene))
                .addGap(74, 74, 74))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnSacuvajIzmeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajIzmeneActionPerformed
        // TODO add your handling code here:

        boolean test = kontrolerKlijent.sacuvajIzmenePregleda(tblTerapija, pregled, txtAreaOpis, chbDa, chbNe);
        if (!test) {
            JOptionPane.showMessageDialog(null, "Sistem ne moze da izmeni pregled!");
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Sistem je izmenio pregled!");
            kontrolerKlijent.srediTabeluPregleda(fpp.getTblPacijenti(), fpp.getTblIstorijaPregleda());
            dispose();
            return;
        }
    }//GEN-LAST:event_btnSacuvajIzmeneActionPerformed

    private void chbNeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbNeActionPerformed
        // TODO add your handling code here:
        if (chbNe.isSelected()) {
            chbDa.setSelected(false);
            ModelTabeleTerapija mtt= new ModelTabeleTerapija(new ArrayList());
            tblTerapija.setModel(mtt);
            jPanel2.setVisible(false);
            btnDodajLek.setVisible(false);
            btnObrisiLek.setVisible(false);
            
        } else {
            chbDa.setSelected(true);
            jPanel2.setVisible(true);
            btnDodajLek.setVisible(true);
            btnObrisiLek.setVisible(true);
            kontrolerKlijent.srediTabeluTerapija(this, tblTerapija);
        }
    }//GEN-LAST:event_chbNeActionPerformed

    private void chbDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbDaActionPerformed
        if (chbDa.isSelected()) {
            chbNe.setSelected(false);
            jPanel2.setVisible(true);
            btnDodajLek.setVisible(true);
            btnObrisiLek.setVisible(true);
           // lblTerapija.setVisible(true);
        } else {
            chbNe.setSelected(true);
            jPanel2.setVisible(false);
            btnDodajLek.setVisible(false);
            btnObrisiLek.setVisible(false);
            //lblTerapija.setVisible(false);
        }
    }//GEN-LAST:event_chbDaActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void btnDodajLekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajLekActionPerformed
        // TODO add your handling code here:
        ModelTabeleTerapija mtt = (ModelTabeleTerapija) tblTerapija.getModel();
        ArrayList<Terapija> listaTerapija = mtt.getListaTerapija();
        FormaLek fl = new FormaLek(this, true);
        fl.srediTabelu(listaTerapija);
        fl.pack();
        fl.setVisible(true);
    }//GEN-LAST:event_btnDodajLekActionPerformed

    private void btnObrisiLekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiLekActionPerformed
        // TODO add your handling code here:
        int red = tblTerapija.getSelectedRow();
        if(red != -1) {
            ModelTabeleTerapija mtt = (ModelTabeleTerapija) tblTerapija.getModel();
            mtt.obrisi(red);
        }else {
            JOptionPane.showMessageDialog(this, "Niste izabrali terapiju");
        }
    }//GEN-LAST:event_btnObrisiLekActionPerformed
    public void srediFormu() {
        lblPacijent.setText(pregled.getPacijent().getImePrezime());
        lblDatum.setText("" + pregled.getDatum());
        lblVreme.setText(pregled.getVreme());
        lblDoktor.setText(pregled.getDoktor().getImePrezime());
        lblVrstaPregleda.setText(pregled.getVrstaPregleda().getNaziv());
        lblCena.setText("" + pregled.getCena());
        if (pregled.isRealizovan()) {
            chbDa.setSelected(true);
            chbNe.setSelected(false);
            chbNe.setEnabled(false);
            chbDa.setEnabled(false);
            jPanel2.setVisible(true);
            //lblTerapija.setVisible(true);
            ModelTabeleTerapija mtt = (ModelTabeleTerapija)tblTerapija.getModel();
            btnDodajLek.setVisible(true);
            btnObrisiLek.setVisible(true);
            btnSacuvajIzmene.setVisible(true);
            
        } else {
            chbDa.setSelected(false);
            chbNe.setSelected(true);
            jPanel2.setVisible(false);
            btnDodajLek.setVisible(false);
            btnObrisiLek.setVisible(false);
           // lblTerapija.setVisible(false);
            
        }
        txtAreaOpis.setText(pregled.getOpis());
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajLek;
    private javax.swing.JButton btnObrisiLek;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvajIzmene;
    private javax.swing.JCheckBox chbDa;
    private javax.swing.JCheckBox chbNe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCena;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblDoktor;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblPacijent;
    private javax.swing.JLabel lblRealizovan;
    private javax.swing.JLabel lblVreme;
    private javax.swing.JLabel lblVrstaPregleda;
    private javax.swing.JTable tblTerapija;
    private javax.swing.JTextArea txtAreaOpis;
    // End of variables declaration//GEN-END:variables

    void dodajTerapiju(FormaLek aThis, Lek l) {
        try {
            ModelTabeleTerapija mtt = (ModelTabeleTerapija) tblTerapija.getModel();
            mtt.dodaj(l, pregled);
            JOptionPane.showMessageDialog(this, "Lek je dodat");
        } catch (Exception ex) {
            Logger.getLogger(FormaUcitajPregled.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
