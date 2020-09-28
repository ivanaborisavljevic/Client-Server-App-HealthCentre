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
public class Specijalizacija implements Serializable, OpstiDomenskiObjekat{
    private int specijalizacijaID;
    private String naziv;

    public Specijalizacija() {
    }

    public Specijalizacija(int specijalizacijaID, String naziv) {
        this.specijalizacijaID = specijalizacijaID;
        this.naziv = naziv;
    }

    /**
     * @return the specijalizacijaID
     */
    public int getSpecijalizacijaID() {
        return specijalizacijaID;
    }

    /**
     * @param specijalizacijaID the specijalizacijaID to set
     */
    public void setSpecijalizacijaID(int specijalizacijaID) {
        this.specijalizacijaID = specijalizacijaID;
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
        return "('"+getNaziv()+"')";
    }

    @Override
    public String postaviVrednostiAtributa() {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "specijalizacija";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(naziv)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where specijalizacijaID="+getSpecijalizacijaID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
        return "specijalizacija";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<Specijalizacija> rezultat = new ArrayList<>();
        try {
             while (rs.next()) {
                int specijalizacijaID = rs.getInt(1);
                String naziv = rs.getString(2);
                Specijalizacija s = new Specijalizacija(specijalizacijaID, naziv);
                rezultat.add(s);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Specijalizacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    } 

    @Override
    public boolean equals(Object obj) {
        Specijalizacija o;
        if (obj instanceof Specijalizacija){
        o = (Specijalizacija)obj;
        return o.naziv.equals(this.naziv); //To change body of generated methods, choose Tools | Templates.

        }
        return false;
    }
    
}
