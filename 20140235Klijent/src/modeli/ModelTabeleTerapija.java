/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Lek;
import domen.Pregled;
import domen.Terapija;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import komunikacija.KomunikacijaSaServerom;
import kontroler.KontrolerKlijent;

/**
 *
 * @author Stefan
 */
public class ModelTabeleTerapija extends AbstractTableModel {

    ArrayList<Terapija> listaTerapija;
    private KontrolerKlijent kontrolerKlijent;
    private boolean promenljivo = true;

    public boolean isPromenljivo() {
        return promenljivo;
    }

    public void setPromenljivo(boolean promenljivo) {
        this.promenljivo = promenljivo;
    }

    public void setListaTerapija(ArrayList<Terapija> listaTerapija) {
        this.listaTerapija = listaTerapija;
    }

    public ModelTabeleTerapija(ArrayList<Terapija> listaTerapija) {
        this.listaTerapija = listaTerapija;
        kontrolerKlijent = new KontrolerKlijent();

    }

    @Override
    public int getRowCount() {
        if (listaTerapija == null) {
            return 0;
        }
        return listaTerapija.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Terapija t = listaTerapija.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getLek().getNaziv();
            case 1:
                return t.getDoza();
            case 2:
                return t.getOpis();
            case 3:
                return t.getLek().getOboljenje();

            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Lek";
            case 1:
                return "Doza(mg)";
            case 2:
                return "Uputstvo";
            case 3:
                return "Oboljenje";

            default:
                return "n/a";
        }
    }

    public ArrayList<Terapija> getListaTerapija() {
        return listaTerapija;
    }

    public void obrisi(int red) {
        listaTerapija.remove(red);
        fireTableDataChanged();
    }

    public Terapija getTerapija(int red) {
        return listaTerapija.get(red);
    }

    public void dodaj(Lek l, Pregled pregled) throws IOException {

        Terapija t = new Terapija(0.0, pregled, l, "", KomunikacijaSaServerom.getInstanca().getUlogovaniSluzbenik());
        listaTerapija.add(t);
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (promenljivo == true && columnIndex == 1 || columnIndex == 2) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Terapija t = listaTerapija.get(rowIndex);

        switch (columnIndex) {
            case 1:
                String doza = (String) aValue;

                double dozaDouble;
                try {
                    dozaDouble = Double.parseDouble(doza);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Vrednost doze mora biti u brojevima!");
                    return;

                }
                if (dozaDouble < 0.0) {
                    t.setDoza(0.0);
                    JOptionPane.showMessageDialog(null, "Vrednost doze mora biti pozitivna!");
                    return;
                }
                t.setDoza(dozaDouble);
                fireTableCellUpdated(rowIndex, 1);
                break;
            case 2:
                String uputstvo = (String) aValue;

                t.setOpis(uputstvo);
                fireTableCellUpdated(rowIndex, 2);
                break;

        }

    }

}
