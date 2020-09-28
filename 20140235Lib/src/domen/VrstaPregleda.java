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
 * @author Ivana
 */
public class VrstaPregleda implements Serializable, OpstiDomenskiObjekat{
    private int vrstaPregledaID;
    private String naziv;
    private Specijalizacija specijalizacija;
private double cena = 0.0;
    public VrstaPregleda() {
    }

    public VrstaPregleda(int vrstaPregledaID, String naziv, Specijalizacija specijalizacija, double cena) {
        this.vrstaPregledaID = vrstaPregledaID;
        this.naziv = naziv;
        this.specijalizacija = specijalizacija;
        this.cena = cena;
    }

    /**
     * @return the vrstaPregledaID
     */
    
    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public int getVrstaPregledaID() {
        return vrstaPregledaID;
    }

    /**
     * @param vrstaPregledaID the vrstaPregledaID to set
     */
    public void setVrstaPregledaID(int vrstaPregledaID) {
        this.vrstaPregledaID = vrstaPregledaID;
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

    /**
     * @return the specijalizacija
     */
    public Specijalizacija getSpecijalizacija() {
        return specijalizacija;
    }

    /**
     * @param specijalizacija the specijalizacija to set
     */
    public void setSpecijalizacija(Specijalizacija specijalizacija) {
        this.specijalizacija = specijalizacija;
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
        return "vrstapregleda";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(naziv, specijalizacijaID, cena)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where vrstaPregledaID="+getVrstaPregledaID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
        return "vrstapregleda vp join specijalizacija s on vp.specijalizacijaID=s.specijalizacijaID";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<VrstaPregleda> rezultat = new ArrayList<>();
        try {
             while (rs.next()) {
                int vrstaPregledaID = rs.getInt(1);
                String naziv = rs.getString(2);
                double cena = rs.getDouble(4);
                int specijalizacijaID = rs.getInt(5);
                
                String nazivSpecijalizacije = rs.getString(6);
                Specijalizacija s = new Specijalizacija(specijalizacijaID, nazivSpecijalizacije);
                VrstaPregleda vp = new VrstaPregleda(vrstaPregledaID, naziv, s, cena);
                rezultat.add(vp);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Specijalizacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }        
}
