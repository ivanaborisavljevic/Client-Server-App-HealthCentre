/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Pacijent;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class SOVratiListuPacijenata extends OpstaSO{
    private ArrayList<Pacijent> listaPacijenata;
   

    @Override
    protected void proveriPreduslov() throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaPacijenata = (ArrayList<Pacijent>) db.select(new Pacijent());
        
    }

    public ArrayList<Pacijent> getListaPacijenata() {
        return listaPacijenata;
    }

    
}
