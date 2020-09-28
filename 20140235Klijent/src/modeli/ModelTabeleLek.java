/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Lek;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Stefan
 */
public class ModelTabeleLek extends AbstractTableModel{
 ArrayList<Lek> lista;

    public ModelTabeleLek(ArrayList<Lek> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        if(lista==null) 
            return 0;
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Lek l = lista.get(rowIndex);
        switch(columnIndex) {
            case 0: return l.getNaziv();
            case 1: return l.getProizvodjac();
            case 2: return l.getOboljenje();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Naziv";
            case 1: return "Proizvodjac";
            case 3: return "Oboljenje";
            default: return "n/a";
        }
    }
    
    public Lek getLek(int red) {
        return lista.get(red);
    }
    
    public void obrisi(int red){
        lista.remove(red);
        fireTableDataChanged();
    }

    
  
    
}
