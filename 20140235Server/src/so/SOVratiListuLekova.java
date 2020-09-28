/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Lek;
import java.util.ArrayList;

/**
 *
 * @author Stefan
 */
public class SOVratiListuLekova extends OpstaSO{
    private ArrayList<Lek> listaLekova;
   

    @Override
    protected void proveriPreduslov() throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaLekova = (ArrayList<Lek>) db.select(new Lek());
        
    }

    public ArrayList<Lek> getListaLekova() {
        return listaLekova;
    }
}
