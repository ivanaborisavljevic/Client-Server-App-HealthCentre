/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivana
 */
public class Smena implements Serializable, OpstiDomenskiObjekat {
    private int smenaID;
    private String pocetak;
    private String kraj;
    private String naziv;

    public Smena(int smenaID, String pocetak, String kraj, String naziv) {
        this.smenaID = smenaID;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.naziv = naziv;
    }

    public Smena() {
    }

    /**
     * @return the smenaID
     */
    public int getSmenaID() {
        return smenaID;
    }

    /**
     * @param smenaID the smenaID to set
     */
    public void setSmenaID(int smenaID) {
        this.smenaID = smenaID;
    }

    /**
     * @return the pocetak
     */
    public String getPocetak() {
        return pocetak;
    }

    /**
     * @param pocetak the pocetak to set
     */
    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    /**
     * @return the kraj
     */
    public String getKraj() {
        return kraj;
    }

    /**
     * @param kraj the kraj to set
     */
    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
@Override
    public String toString() {
        return naziv;   
    
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "('"+getPocetak()+"','"+getKraj()+"',"+getNaziv()+")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "";
    }

    @Override
    public String vratiImeKlase() {
        return "smena";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(pocetak, kraj, naziv)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where smenaID="+getSmenaID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
        return "smena";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<Smena> rezultat = new ArrayList<>();
        try {
             while (rs.next()) {
                int smenaID = rs.getInt(1);
                String pocetak = rs.getString(2);
                String kraj = rs.getString(3);
                String naziv = rs.getString(4);
                Smena s = new Smena(smenaID, pocetak, kraj, naziv);
                rezultat.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Smena.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
     @Override
    public boolean equals(Object obj) {
        Smena o;
        if (obj instanceof Smena){
        o = (Smena)obj;
        return o.naziv.equals(this.naziv); //To change body of generated methods, choose Tools | Templates.

        }
        return false;
    }    
}
