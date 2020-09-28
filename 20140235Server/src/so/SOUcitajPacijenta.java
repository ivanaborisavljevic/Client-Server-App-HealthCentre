/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Pacijent;
import domen.Pregled;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class SOUcitajPacijenta extends OpstaSO {

    Pacijent pacijent;
    List<Pacijent> listaPacijenata;

    public SOUcitajPacijenta(Pacijent p) {
        super(p);

    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            pacijent = (Pacijent) objekat;

            if (pacijent == null) {
               
                throw new Exception("SERVER: Pacijent na osnovu koga se ucitavaju podaci ne postoji");
            }
            if (pacijent.getPacijentID() < 0) {
               
                throw new Exception("SERVER: ID pacijenta kojeg zelimo da ucitamo nije validan, tj <0");
            }
        } catch (Exception ex) {
            throw new Exception("SERVER: Doslo je do izuzetka u klasi SOUcitajPacijenta");
        }
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {

        String uslov = "where pacijentID = " + pacijent.getPacijentID();

        listaPacijenata = (List<Pacijent>) db.select(new Pacijent(), uslov);

    }

    public Pacijent getPacijent() {

        return listaPacijenata.get(0);
    }

}
