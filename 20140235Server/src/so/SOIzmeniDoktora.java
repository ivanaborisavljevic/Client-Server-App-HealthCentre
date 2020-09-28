/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Doktor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class SOIzmeniDoktora extends OpstaSO {

    private Doktor doktor;

    public SOIzmeniDoktora(Doktor doktor) {
        super(doktor);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            doktor = (Doktor) objekat;

           
            if (doktor.getImePrezime().isEmpty()) {

             
                throw new Exception("SERVER: *Ime i prezime doktora ne sme biti prazno*");
            }
            if (doktor.getSpecijalizacija() == null) {
               
                throw new Exception("SERVER: *Polje specijalizacija doktora ne sme biti prazno*");
            }
            if (doktor.getSmena() == null) {
               
                throw new Exception("SERVER: *Polje smena doktora ne sme biti prazno*");
            }
           
            if (doktor.getSpecijalizacija().getSpecijalizacijaID() < 0) {
               
                throw new Exception("SERVER: *Polje specijalizacijaID ne sme biti manje od 0*");
            }
            if (doktor.getSmena().getSmenaID() < 0) {
              
                throw new Exception("SERVER: *Polje smenaID ne sme biti manje od 0*");
            }
          

        } catch (Exception ex) {

            
            Logger.getLogger(SOIzmeniDoktora.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("SERVER: Doslo je do izuzetka u klasi SOIzmeniDoktora!");
        }

    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.update(doktor);
    }
}
