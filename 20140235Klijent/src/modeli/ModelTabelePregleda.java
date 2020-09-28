/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Doktor;
import domen.Pacijent;
import domen.Pregled;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import komunikacija.KomunikacijaSaServerom;

/**
 *
 * @author Stefan
 */
public class ModelTabelePregleda extends AbstractTableModel {

    ArrayList<Pregled> listaPregleda;
    ArrayList<Pregled> listaIzmenjenihPregleda = new ArrayList<>();
    private boolean promenljivo = false;
    private boolean test = false;

    public void setTest(boolean test) {
        this.test = test;
    }

    public ModelTabelePregleda() {
        listaPregleda = new ArrayList<>();
    }

    public ModelTabelePregleda(ArrayList<Pregled> listaPregleda) {
        this.listaPregleda = listaPregleda;
    }

    @Override
    public int getRowCount() {
        if (listaPregleda == null) {
            return 0;
        }
        return listaPregleda.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pregled pregled = listaPregleda.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return pregled.getVrstaPregleda().getNaziv();
            case 1:
                return pregled.getVrstaPregleda().getSpecijalizacija().getNaziv();
            case 2:
                return pregled.getDatum();
            case 3:
                return pregled.getVreme();
            case 4:
                return pregled.getDoktor().getImePrezime();
            case 5:
                return pregled.getCena();
            case 6:
                return pregled.getOpis();
            case 7:
                return pregled.isRealizovan();
            default:
                return "n/a";
        }
    }

    @Override
    //ova metoda se sama poziva kada kliknemo na editable polje, a ovde je jedino editable obavljen tako da nema potrebe da oznacavamo koje je polje
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (rowIndex != -1) {
            
            listaPregleda.get(rowIndex).setRealizovan((Boolean) aValue);
            
            //Pregled p = listaPregleda.get(rowIndex);
            //listaIzmenjenihPregleda.add(p);
                    
            
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Vrsta pregleda";
            case 1:
                return "Specijalizacija";
            case 2:
                return "Datum";
            case 3:
                return "Vreme";
            case 4:
                return "Doktor";
            case 5:
                return "Cena";
            case 6:
                return "Opis";
            case 7:
                return "Obavljen";

            default:
                return "n/a";
        }
    }

    public ArrayList<Pregled> getListaPregleda() {
        return listaPregleda;
    }

    public void obrisi(int red) {
        listaPregleda.remove(red);
        fireTableDataChanged();
    }

    public boolean isPromenljivo() {
        return promenljivo;
    }

    public void setPromenljivo(boolean promenljivo) {
        this.promenljivo = promenljivo;
    }

    public void setListaPregleda(ArrayList<Pregled> listaPregleda) {
        this.listaPregleda = listaPregleda;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass(); //To change body of generated methods, choose Tools | Templates.
    }

    public Pregled getPregled(int red) {

        return getListaPregleda().get(red);
    }

    public void setListaIzmenjenihPregleda(ArrayList<Pregled> listaIzmenjenihPregleda) {
        this.listaIzmenjenihPregleda = listaIzmenjenihPregleda;
    }

    public ArrayList<Pregled> getListaIzmenjenihPregleda() {
        return listaIzmenjenihPregleda;
    }

    public void proslediParametre(boolean test) {

        this.test = test;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //if (test && (columnIndex == 6 || columnIndex == 7)) {
          //  return true; //Or whatever column index you want to be editable
        //}
        return false;
    }

}
