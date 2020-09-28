/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Doktor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class SOUcitajDoktora extends OpstaSO {

    Doktor doktor;
    List<Doktor> listaDoktora;

    public SOUcitajDoktora(Doktor d) {
        super(d);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            doktor = (Doktor) objekat;

            if (doktor== null) {
                
                throw new Exception("SERVER: Doktor na osnovu koga se ucitavaju podaci ne postoji");
            }

            if (doktor.getDoktorID() < 0) {
                
                throw new Exception("SERVER: ID doktora kojeg zelimo da ucitamo nije validan, tj <0");
            }
        } catch (Exception ex) {
            throw new Exception("SERVER: Doslo je do izuzetka u klasi SOUcitajDoktora");
        }

    }

    @Override
    protected void izvrsiOperaciju() throws Exception {

        String uslov = "where doktorID = " + doktor.getDoktorID();
        listaDoktora = (List<Doktor>) db.select(new Doktor(), uslov);

    }

    public Doktor getDoktor() {

        return listaDoktora.get(0);
    }

}
