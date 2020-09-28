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
public class SOIzmeniPregled extends OpstaSO{
      private Pregled pregled;

    public SOIzmeniPregled(Pregled pregled) {
        super(pregled);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        pregled=(Pregled)objekat;
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.update(pregled);
        ArrayList<Terapija> listaSvihTerapija = (ArrayList<Terapija>)db.select(new Terapija(), "where t.pregledID="+pregled.getPregledID());
      
       for(Terapija t: listaSvihTerapija)
           db.delete(t);
       for(Terapija t: pregled.getListaTerapija())
       db.insert(t);
}
}