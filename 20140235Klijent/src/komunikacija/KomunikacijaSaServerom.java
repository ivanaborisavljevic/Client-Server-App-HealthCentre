/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.Sluzbenik;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivana
 */
public class KomunikacijaSaServerom {
    private Sluzbenik ulogovaniSluzbenik;
    private static KomunikacijaSaServerom instanca;
    Socket s;

    public KomunikacijaSaServerom() throws IOException{
        //s= new Socket("localhost", 9000);
    }
    
    public static KomunikacijaSaServerom getInstanca() throws IOException {
        if(instanca == null) {
            instanca = new KomunikacijaSaServerom();
        }
        return instanca;
    }
    
    public void posaljiZahtev(TransferObjekatZahtev toz) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(toz);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut!");
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            return;
            
        
        }
        
    }
    
    public TransferObjekatOdgovor primiOdgovor() {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();
        
        try {
            ObjectInputStream ois =  new ObjectInputStream(s.getInputStream());
            
            too = (TransferObjekatOdgovor)ois.readObject();
            
            
        } catch (IOException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return too;
    }
    
    //public void poveziSe() {
      //  this.s = s;
    //}

    public Sluzbenik getUlogovaniSluzbenik() {
        return ulogovaniSluzbenik;
    }

    public void setUlogovaniSluzbenik(Sluzbenik ulogovaniSluzbenik) {
        this.ulogovaniSluzbenik = ulogovaniSluzbenik;
    }

    public void poveziSe(Socket s) {
        this.s = s;
    }
    
    
    
}
