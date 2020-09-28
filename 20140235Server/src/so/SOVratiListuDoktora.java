/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Doktor;
import domen.OpstiDomenskiObjekat;

import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class SOVratiListuDoktora extends OpstaSO{
     private ArrayList<Doktor> listaDoktora;
    

    @Override
    protected void proveriPreduslov() throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaDoktora = (ArrayList<Doktor>) db.select(new Doktor());
        
    }

    public ArrayList<Doktor> getListaDoktora() {
        return listaDoktora;
    }

}
