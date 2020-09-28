/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Pregled;
import domen.Terapija;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Stefan
 */
public class SOUcitajPregled extends OpstaSO {

    Pregled pregled;
    List<Pregled> listaPregleda;

    public SOUcitajPregled(Pregled p) {
        super(p);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            pregled = (Pregled) objekat;
            if (pregled == null) {
                
                throw new Exception("SERVER: Pregled na osnovu koga se ucitavaju podaci ne postoji");
            }
            if (pregled.getPregledID() < 0) {
                
                throw new Exception("SERVER: ID pregleda kojeg zelimo da ucitamo nije validan, tj <0");
            }
        } catch (Exception ex) {
            throw new Exception("SERVER: Doslo je do izuzetka u klasi SOUcitajPregled");
        }
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        
        String uslov = "where p.pregledID = " + pregled.getPregledID();
        listaPregleda = (List<Pregled>) db.select(new Pregled(), uslov);
        ArrayList<Terapija> listaTerapija  = new ArrayList();
        
        String uslovZaTerapije = "where t.pregledID = " + listaPregleda.get(0).getPregledID();
        listaTerapija = (ArrayList<Terapija>) db.select(new Terapija(), uslovZaTerapije);
        listaPregleda.get(0).setListaTerapija(listaTerapija);
      
        

    }

    public Pregled getPregled() {
        return listaPregleda.get(0);
    }

}
