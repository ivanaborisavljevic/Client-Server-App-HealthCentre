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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefan
 */
public class Lek implements Serializable, OpstiDomenskiObjekat{
    int lekID;
    String naziv;
    String proizvodjac;
    String oboljenje;

    public Lek() {
    }

    public Lek(int lekID, String naziv, String proizvodjac, String oboljenje) {
        this.lekID = lekID;
        this.naziv = naziv;
        this.proizvodjac = proizvodjac;
        this.oboljenje = oboljenje;
    }

    public int getLekID() {
        return lekID;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOboljenje() {
        return oboljenje;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setLekID(int lekID) {
        this.lekID = lekID;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOboljenje(String oboljenje) {
        this.oboljenje = oboljenje;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }
    @Override
    public String toString() {
        return naziv;   
    
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "('"+getNaziv()+"','"+getProizvodjac()+"',"+getOboljenje()+")";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "";
    }

    @Override
    public String vratiImeKlase() {
        return "lek";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(naziv, proizvodjac, oboljenje)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where lekID="+getLekID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
        return "lek";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<Lek> rezultat = new ArrayList<>();
        try {
             while (rs.next()) {
                int lekID = rs.getInt(1);
                String naziv = rs.getString(2);
                String  proizvodjac= rs.getString(3);
                String oboljenje = rs.getString(4);
               Lek l = new Lek(lekID, naziv, proizvodjac, oboljenje);
                rezultat.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Smena.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
     @Override
    public boolean equals(Object obj) {
        Lek l;
        if (obj instanceof Lek){
        l = (Lek)obj;
        return l.naziv.equals(this.naziv) && l.proizvodjac.equals(this.proizvodjac); //To change body of generated methods, choose Tools | Templates.

        }
        return false;
    }    
}
