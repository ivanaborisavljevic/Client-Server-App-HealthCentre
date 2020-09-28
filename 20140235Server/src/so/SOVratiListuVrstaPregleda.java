/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Specijalizacija;
import domen.VrstaPregleda;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class SOVratiListuVrstaPregleda extends OpstaSO{
    private ArrayList<VrstaPregleda> listaVrstaPregleda;
    

    @Override
    protected void proveriPreduslov() throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaVrstaPregleda =  (ArrayList<VrstaPregleda>) db.select(new VrstaPregleda());
    }

    public ArrayList<VrstaPregleda> getListaVrstaPregleda() {
        return listaVrstaPregleda;
    }
    
    
}
