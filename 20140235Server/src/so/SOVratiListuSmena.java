/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Smena;
import domen.Specijalizacija;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class SOVratiListuSmena extends OpstaSO{
     private ArrayList<Smena> listaSmena;
     

    @Override
    protected void proveriPreduslov() throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaSmena =  (ArrayList<Smena>) db.select(new Smena());
    }

    public ArrayList<Smena> getListaSmena() {
        return listaSmena;
    }
}
