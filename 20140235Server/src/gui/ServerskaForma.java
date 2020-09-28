/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import kontroler.Kontroler;

import niti.PokreniServer;

/**
 *
 * @author Ivana
 */
public class ServerskaForma extends javax.swing.JFrame {

    PokreniServer ps;

    /**
     * Creates new form ServerForma
     */
    public ServerskaForma() {
        initComponents();
        initUI();
        //NitOsvezi no = new NitOsvezi(this);
        //no.start();
    }

    private void initUI() {

        setSize(400, 250);
        centerFrame();
        setTitle("Serverska forma");
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

        txtStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPokreni = new javax.swing.JButton();
        btnZaustavi = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemPromeniPodešavanja = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtStatus.setText("Server nije pokrenut");

        jLabel1.setText("Poruka:");

        btnPokreni.setText("Pokreni server");
        btnPokreni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPokreniActionPerformed(evt);
            }
        });

        btnZaustavi.setText("Zaustavi server");
        btnZaustavi.setEnabled(false);
        btnZaustavi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaustaviActionPerformed(evt);
            }
        });

        jMenu1.setText("Podešavanja");

        jMenuItemPromeniPodešavanja.setText("Promeni");
        jMenuItemPromeniPodešavanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPromeniPodešavanjaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPromeniPodešavanja);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPokreni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(btnZaustavi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtStatus)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPokreni)
                    .addComponent(btnZaustavi))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPokreniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPokreniActionPerformed
        ps = new PokreniServer(this);
        ps.start();

    }//GEN-LAST:event_btnPokreniActionPerformed

    private void btnZaustaviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaustaviActionPerformed
        int brojSluzbenika = Kontroler.getInstance().getListaSluzbenika().size();

        if (brojSluzbenika == 0) {
            ps.interrupt();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Ne može se zaustaviti server! Trenutno je povezan sa " + brojSluzbenika + " sluzbenika!");
        }
    }//GEN-LAST:event_btnZaustaviActionPerformed

    public JButton getBtnZaustavi() {
        return btnZaustavi;
    }

    public JButton getBtnPokreni() {
        return btnPokreni;
    }

    private void jMenuItemPromeniPodešavanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPromeniPodešavanjaActionPerformed
        // TODO add your handling code here:

        PodesavanjaForma pf = new PodesavanjaForma(this, true, ps);

        pf.pack();
        pf.setVisible(true);
    }//GEN-LAST:event_jMenuItemPromeniPodešavanjaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerskaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UIManager.getLookAndFeelDefaults().put("defaultFont", new Font("Arial", Font.PLAIN, 15));
                new ServerskaForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPokreni;
    private javax.swing.JButton btnZaustavi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemPromeniPodešavanja;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
 public void serverPokrenut() {
        txtStatus.setText("Server je pokrenut");
        btnPokreni.setEnabled(false);
        btnZaustavi.setEnabled(true);
    }

    public void serverNijePokrenut() {
        txtStatus.setText("Server nije pokrenut");
        btnPokreni.setEnabled(true);
        btnZaustavi.setEnabled(false);
    }

}
