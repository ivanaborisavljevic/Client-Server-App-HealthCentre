/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Sluzbenik;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ivana
 */
public class SONadjiSluzbenika extends OpstaSO{
    private Sluzbenik sluzbenik;
    private Sluzbenik ulogovani = null;
    private ArrayList<Sluzbenik> listaSluzbenika;

    public SONadjiSluzbenika(Object object) {
        super(object);
        
    }


    @Override
    protected void proveriPreduslov() throws Exception {
        try { 
            sluzbenik = (Sluzbenik) objekat;
            
        if (sluzbenik == null){
       
         throw new Exception("SERVER: Sluzbenik na osnovu koga se vrsi provera ne postoji");
        }
           if (sluzbenik.getSluzbenikID()<0){
          
           throw new Exception("SERVER:ID sluzbenika kojeg zelimo da proverimo nije validan, tj <0");
           } }
        catch (Exception ex){
        throw new Exception ("SERVER: Doslo je do bacanja izuzetka u klasi SONadjiSluzbenika!");
        }
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaSluzbenika = (ArrayList<Sluzbenik>) db.select(sluzbenik);
        
        if(!listaSluzbenika.isEmpty()) {
            ulogovani = listaSluzbenika.get(0);
        }
        
        else return;
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }
    
    public Sluzbenik getUlogovani() {
        return ulogovani;
    }

    
}
