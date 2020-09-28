/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Doktor;
import domen.Pregled;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class SOObrisiDoktora extends OpstaSO {

    private Doktor doktor;

    public SOObrisiDoktora(Doktor doktorObrisi) {
        super(doktorObrisi);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            doktor = (Doktor) objekat;

            if (doktor == null) {

                throw new Exception("SERVER: Objekat doktor kojeg zelimo da izbrisemo ne postoji, stoga ne moze da se obrise");
            }

            if (doktor.getDoktorID() < 0) {

                throw new Exception("SERVER: ID doktora kojeg zelimo da obrisemo je manji od 0, stoga ne moze da se obrise");
            }
            List<Pregled> pregledi = (List<Pregled>) db.select(new Pregled(), "where p.doktorID =" + doktor.getDoktorID());
            if (pregledi == null) {
                throw new Exception("SERVER: Pregledi doktora ne mogu biti vraceni");

            }
            if (pregledi.size() > 0) {
                throw new Exception("SERVER: Doktor kojeg zelimo da obrisemo ima preglede, tako da ne mozemo");
            }
        } catch (Exception ex) {
            throw new Exception("SERVER: Doslo je do izuzetka u klasi SOObrisiDoktora");
        }

    }

    @Override
    protected void izvrsiOperaciju() throws Exception {

        db.delete(doktor);
    }
}
