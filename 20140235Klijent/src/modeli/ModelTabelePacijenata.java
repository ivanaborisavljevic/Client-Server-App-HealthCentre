/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Pacijent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Stefan
 */
public class ModelTabelePacijenata extends AbstractTableModel {

    private ArrayList<Pacijent> listaPacijenata;

    public ModelTabelePacijenata(ArrayList<Pacijent> listaPacijenata) {
        this.listaPacijenata = listaPacijenata;
    }
    

    @Override
    public int getRowCount() {
        if(getListaPacijenata() == null) {
            return 0;
        }
        return getListaPacijenata().size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pacijent p = getListaPacijenata().get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        switch(columnIndex) {
            case 0: return p.getImePrezime();
            case 1: return p.getJmbg();
            case 2: return sdf.format(p.getDatumRodjenja());
            case 3: return p.getAdresa();
            case 4: return p.getGrad();
            case 5: return p.getTelefon();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Ime i prezime";
            case 1: return "JMBG";
            case 2: return "Datum rodjenja";
            case 3: return "Adresa";
            case 4: return "Grad";
            case 5: return "Telefon";
            default: return "n/a";
        }
    }

    public ArrayList<Pacijent> getListaPacijenata() {
        return listaPacijenata;
    }

    public void setListaPacijenata(ArrayList<Pacijent> listaPacijenata) {
        this.listaPacijenata = listaPacijenata;
    }
    
    
    
    public void obrisi(int red) {
        getListaPacijenata().remove(red);
        fireTableDataChanged();
    }
    
    public Pacijent getPacijent(int red) {
        
        return getListaPacijenata().get(red);
    }
    
}
