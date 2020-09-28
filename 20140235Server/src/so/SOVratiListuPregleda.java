/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Doktor;
import domen.Pacijent;
import domen.Pregled;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Stefan
 */
public class SOVratiListuPregleda extends OpstaSO {

    private ArrayList<Pregled> listaPotrebnihPregleda = new ArrayList<>();
    Pacijent pacijent;
    Doktor doktor;

    public SOVratiListuPregleda(Pacijent p) {
        super(p);
        this.pacijent = p;
        this.doktor = null;
    }

    public SOVratiListuPregleda(Doktor d) {
        super(d);
        this.doktor = d;
        this.pacijent = null;

    }

    @Override
    protected void proveriPreduslov() throws Exception {

        if (pacijent != null && doktor == null) {
            pacijent = (Pacijent) objekat;
            if (pacijent.getPacijentID() < 0) {
               
                throw new Exception("SERVER: Objekat pacijent na osnovu koga se vracaju pregledi nema validan id, tj id<0");
            }

        } else if (doktor != null && pacijent == null) {
            doktor = (Doktor) objekat;
            if (doktor.getDoktorID() < 0) {
               
                throw new Exception("SERVER: Objekat doktor na osnovu koga se vracaju pregledi nema validan id, tj id<0");
            }
        } else if (doktor == null && pacijent == null) {
           
            throw new Exception("SERVER: Ne postoji objekat na osnovu koga se vracaju pregledi");
        }

    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        if (pacijent != null) {
            String uslov = "where p.pacijentID = " + pacijent.getPacijentID();
            listaPotrebnihPregleda = (ArrayList<Pregled>) db.select(new Pregled(), uslov);

        } else {
            izvrsiOperaciju2();
        }
    }

    public void izvrsiOperaciju2() throws Exception {
        String uslov = "where p.doktorID = " + doktor.getDoktorID();
        listaPotrebnihPregleda = (ArrayList<Pregled>) db.select(new Pregled(), uslov);

    }

    public ArrayList<Pregled> getListaPregleda() {
        return listaPotrebnihPregleda;
    }

}
