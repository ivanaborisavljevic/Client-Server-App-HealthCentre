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

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import kontroler.KontrolerKlijent;
import modeli.ModelTabeleDoktora;

/**
 *
 * @author Stefan
 */
public class FormaPretraziDoktora extends javax.swing.JFrame {
KontrolerKlijent kontrolerKlijent;
GlavnaForma gf;
private Object lastSelected;

    public GlavnaForma getGf() {
        return gf;
    }

    public JTable getTblDoktori() {
        return tblDoktori;
    }

    /**
     * Creates new form FormaPretraziDoktora
     */
    public FormaPretraziDoktora(java.awt.Frame parent, boolean modal) {
        //super(parent, modal);
        initComponents();
       
        initUI();
        tblDoktori.setRowHeight(20);
        tblDoktori.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        gf = (GlavnaForma)parent;
        kontrolerKlijent = new KontrolerKlijent();
        kontrolerKlijent.srediTabeluDoktora(this, tblDoktori);
        kontrolerKlijent.pripremiTabeluDoktoraZaSort(this, tblDoktori, txtPretraziDoktora);
        
    }
private void initUI() {

        setSize(700, 600);
        centerFrame();
        setTitle("Pretraga doktora forma");
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
        tblDoktori = new javax.swing.JTable();
        btnIzmeniDoktora = new javax.swing.JButton();
        btnDodajNovogDoktora = new javax.swing.JButton();
        btnObrisiDoktora = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnOtkazi = new javax.swing.JButton();
        txtPretraziDoktora = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Doktori"));

        tblDoktori.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDoktori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoktoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDoktori);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIzmeniDoktora.setText("Izmeni doktora");
        btnIzmeniDoktora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniDoktoraActionPerformed(evt);
            }
        });

        btnDodajNovogDoktora.setText("Dodaj novog doktora");
        btnDodajNovogDoktora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajNovogDoktoraActionPerformed(evt);
            }
        });

        btnObrisiDoktora.setText("Obrisi doktora");
        btnObrisiDoktora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiDoktoraActionPerformed(evt);
            }
        });

        jLabel1.setText("Pretrazi doktora:");

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        txtPretraziDoktora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPretraziDoktoraActionPerformed(evt);
            }
        });
        txtPretraziDoktora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPretraziDoktoraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addComponent(txtPretraziDoktora, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnIzmeniDoktora)
                                .addGap(29, 29, 29)
                                .addComponent(btnDodajNovogDoktora)
                                .addGap(32, 32, 32)
                                .addComponent(btnObrisiDoktora)
                                .addGap(55, 55, 55))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(btnOtkazi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtPretraziDoktora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnObrisiDoktora)
                            .addComponent(btnDodajNovogDoktora)
                            .addComponent(btnIzmeniDoktora))
                        .addGap(55, 55, 55)))
                .addComponent(btnOtkazi)
                .addGap(54, 54, 54))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzmeniDoktoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniDoktoraActionPerformed
        // TODO add your handling code here:
       int red = tblDoktori.getSelectedRow();
        if(red != -1) {
            ModelTabeleDoktora mtp = (ModelTabeleDoktora) tblDoktori.getModel();
            Doktor d = mtp.getDoktor(tblDoktori.convertRowIndexToModel(red));
            Doktor doktor = kontrolerKlijent.ucitajDoktora(d);
          if (doktor!= null){  
            FormaDodajDoktora fid = new FormaDodajDoktora(doktor, this);
          }
            
        }else {
            JOptionPane.showMessageDialog(rootPane, "Niste izabrali doktora");
            return;
        }
        
    }//GEN-LAST:event_btnIzmeniDoktoraActionPerformed

    private void btnDodajNovogDoktoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajNovogDoktoraActionPerformed
        // TODO add your handling code here:
        FormaDodajDoktora fdd = new FormaDodajDoktora();
        fdd.setFpd(this);
        fdd.setVisible(true);
        
    }//GEN-LAST:event_btnDodajNovogDoktoraActionPerformed

    private void btnObrisiDoktoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiDoktoraActionPerformed
        // TODO add your handling code here
        int red = tblDoktori.getSelectedRow();
        if(red != -1) {
            kontrolerKlijent.obrisiDoktora(this, red, tblDoktori);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Nije odabran doktor!");
            return;
        }
    }//GEN-LAST:event_btnObrisiDoktoraActionPerformed

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        // TODO add your handling code here:
        dispose();
        gf.setVisible(true);
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void txtPretraziDoktoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPretraziDoktoraActionPerformed
        lastSelected = null;
        tblDoktori.clearSelection();
// TODO add your handling code here:
    }//GEN-LAST:event_txtPretraziDoktoraActionPerformed

    public void resetSearch(){
        this.txtPretraziDoktora.setText("");
    }
    
    private void tblDoktoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoktoriMouseClicked
        Object current = ((ModelTabeleDoktora)tblDoktori.getModel()).getDoktor(tblDoktori.getSelectedRow());    
        if (current != null && current == lastSelected) {
            tblDoktori.getSelectionModel().clearSelection();
            lastSelected = null;
        } else 
            lastSelected = current;
    }//GEN-LAST:event_tblDoktoriMouseClicked

    private void txtPretraziDoktoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretraziDoktoraKeyTyped
        lastSelected = null;
        tblDoktori.clearSelection();
    }//GEN-LAST:event_txtPretraziDoktoraKeyTyped

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajNovogDoktora;
    private javax.swing.JButton btnIzmeniDoktora;
    private javax.swing.JButton btnObrisiDoktora;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoktori;
    private javax.swing.JTextField txtPretraziDoktora;
    // End of variables declaration//GEN-END:variables
}
