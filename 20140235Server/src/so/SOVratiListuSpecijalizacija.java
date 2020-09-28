/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Specijalizacija;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class SOVratiListuSpecijalizacija extends OpstaSO{
     private ArrayList<Specijalizacija> listaSpecijalizacija;

    @Override
    protected void proveriPreduslov() throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaSpecijalizacija =  (ArrayList<Specijalizacija>) db.select(new Specijalizacija());
    }

    public ArrayList<Specijalizacija> getListaSpecijalizacija() {
        return listaSpecijalizacija;
    }
    
    
}
