/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Pacijent;
import domen.Pregled;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class SOObrisiPacijenta extends OpstaSO {

    private Pacijent pacijent;

    public SOObrisiPacijenta(Pacijent pacijentObrisi) {
        super(pacijentObrisi);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            pacijent = (Pacijent) objekat;

            if (pacijent == null) {

                throw new Exception("SERVER:Objekat pacijent kojeg zelimo da izbrisemo ne postoji, stoga ne moze da se obrise");
            }

            if (pacijent.getPacijentID() < 0) {

                throw new Exception("SERVER:Id pacijenta je manji od 0, stoga ne moze da se obrise");
            }
            List<Pregled> pregledi = (List<Pregled>) db.select(new Pregled(), "where p.pacijentID =" + pacijent.getPacijentID());
            if (pregledi == null) {
                throw new Exception("SERVER: Pregledi pacijenta ne mogu biti vraceni");

            }
            if (pregledi.size() > 0) {
                throw new Exception("SERVER: Pacijent kojeg zelimo da obrisemo ima preglede, tako da ne mozemo");
            }

        } catch (Exception ex) {
            throw new Exception("SERVER: Doslo je do bacanja izuzetka u klasi ObrisiPacijenta");
        }
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {

        db.delete(pacijent);
    }
}
