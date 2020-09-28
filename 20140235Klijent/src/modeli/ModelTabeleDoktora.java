/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Doktor;
import domen.Pacijent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Stefan
 */
public class ModelTabeleDoktora extends AbstractTableModel{
    ArrayList<Doktor> listaDoktora;
    private KontrolerKlijent kontrolerKlijent;

    public void setListaDoktora(ArrayList<Doktor> listaDoktora) {
        this.listaDoktora = listaDoktora;
    }

    public ModelTabeleDoktora(ArrayList<Doktor> listaDoktora) {
        this.listaDoktora = listaDoktora;
        kontrolerKlijent = new KontrolerKlijent();
        
    }
    
    @Override
    public int getRowCount() {
        if(listaDoktora == null) {
            return 0;
        }
        return listaDoktora.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doktor d = listaDoktora.get(rowIndex);
            switch(columnIndex) {
            case 0: return d.getImePrezime();
            case 1: return d.getSpecijalizacija().getNaziv();
            case 2: return d.getSmena().getNaziv();
            
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Ime i prezime";
            case 1: return "Specijalizacija";
            case 2: return "Smena";
            
            default: return "n/a";
        }
    }

    public ArrayList<Doktor> getListaDoktora() {
        return listaDoktora;
    }
    
    public void obrisi(int red) {
        listaDoktora.remove(red);
        fireTableDataChanged();
    }
    
    public Doktor getDoktor(int red) {
        return listaDoktora.get(red);
    }
    
    
    
}
