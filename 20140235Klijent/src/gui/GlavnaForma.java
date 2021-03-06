/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domen.Sluzbenik;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JFrame;

/**
 *
 * @author Ivana
 */
public class GlavnaForma extends javax.swing.JFrame {

    Sluzbenik ulogovaniSluzbenik;

    /**
     * Creates new form GlavnaForma
     */
    public GlavnaForma() {
        initComponents();
        initUI();
    }

    private void initUI() {

        setSize(1930, 1070);
        centerFrame();
        setTitle("Glavna forma");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        lblUlogovaniKorisnik = new javax.swing.JLabel();
        lblUlogovani = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuPacijenti = new javax.swing.JMenu();
        jMenuItemPretraziPacijente = new javax.swing.JMenuItem();
        jMenuDoktori = new javax.swing.JMenu();
        jMenuItemPretraziDoktora = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Sluzbenik"));
        jPanel1.setToolTipText("");

        lblUlogovaniKorisnik.setText("Ulogovani sluzbenik:");

        lblUlogovani.setText("Ime i prezime ulogovanog sluzbenika");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovaniKorisnik)
                .addGap(18, 18, 18)
                .addComponent(lblUlogovani, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUlogovaniKorisnik)
                    .addComponent(lblUlogovani))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jMenuPacijenti.setText("Pacijenti");

        jMenuItemPretraziPacijente.setText("Pretrazi pacijente");
        jMenuItemPretraziPacijente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPretraziPacijenteActionPerformed(evt);
            }
        });
        jMenuPacijenti.add(jMenuItemPretraziPacijente);

        jMenuBar1.add(jMenuPacijenti);

        jMenuDoktori.setText("Doktori");

        jMenuItemPretraziDoktora.setText("Pretrazi doktore");
        jMenuItemPretraziDoktora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPretraziDoktoraActionPerformed(evt);
            }
        });
        jMenuDoktori.add(jMenuItemPretraziDoktora);

        jMenuBar1.add(jMenuDoktori);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemPretraziPacijenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPretraziPacijenteActionPerformed
        // TODO add your handling code here:

        FormaPretraziPacijenta fpp = new FormaPretraziPacijenta(this, true, ulogovaniSluzbenik);

        fpp.setVisible(true);
    }//GEN-LAST:event_jMenuItemPretraziPacijenteActionPerformed

    private void jMenuItemPretraziDoktoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPretraziDoktoraActionPerformed
        // TODO add your handling code here:
        FormaPretraziDoktora fpd = new FormaPretraziDoktora(this, true);
        fpd.setVisible(true);
    }//GEN-LAST:event_jMenuItemPretraziDoktoraActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuDoktori;
    private javax.swing.JMenuItem jMenuItemPretraziDoktora;
    private javax.swing.JMenuItem jMenuItemPretraziPacijente;
    private javax.swing.JMenu jMenuPacijenti;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JLabel lblUlogovaniKorisnik;
    // End of variables declaration//GEN-END:variables
 public void setUlogovani(Sluzbenik ulogovaniSluzbenik) {
        this.ulogovaniSluzbenik = ulogovaniSluzbenik;
        lblUlogovani.setText(ulogovaniSluzbenik.getImePrezime() + "");

    }
}
