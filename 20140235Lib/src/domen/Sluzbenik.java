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
public class Sluzbenik implements Serializable, OpstiDomenskiObjekat{
    private int sluzbenikID;
    private String imePrezime;
    private String korisnickoIme;
    private String lozinka;

    public Sluzbenik() {
    }

   

    public Sluzbenik (int sluzbenikID, String imePrezime, String korisnickoIme, String lozinka) {
        this.sluzbenikID = sluzbenikID;
        this.imePrezime = imePrezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public Sluzbenik (String korisnickoIme, String lozinka) {
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getSluzbenikID() {
        return sluzbenikID;
    }

    /**
     * @param sluzbenikID the sluzbenikID to set
     */
    public void setSluzbenikID(int sluzbenikID) {
        this.sluzbenikID = sluzbenikID;
    }

    /**
     * @return the imePrezime
     */
    public String getImePrezime() {
        return imePrezime;
    }

    /**
     * @param imePrezime the imePrezime to set
     */
    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    /**
     * @return the korisnickoIme
     */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    /**
     * @param korisnickoIme the korisnickoIme to set
     */
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    /**
     * @return the lozinka
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * @param lozinka the lozinka to set
     */
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    } 
    
    @Override
    public String toString() {
        return getImePrezime();
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "('"+getKorisnickoIme()+"','"+getLozinka()+"')";
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiImeKlase() {
        return "sluzbenik";
    }

    @Override
    public String vratiAtributeKlase() {
        return "";
    }

    @Override
    public String vratiUslovPretrage() {
        return "where korisnickoIme='"+getKorisnickoIme()+"' and lozinka='"+getLozinka()+"'";
    }

    @Override
    public String vratiUslovIzmene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovBrisanja() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiTabeluPretrage() {
        return "sluzbenik s";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        Sluzbenik ulogovaniSluzbenik;
        ArrayList<Sluzbenik> rezultat = new ArrayList<>();
        
        try {
            while(rs.next()) {
                int sluzbenikID = rs.getInt("sluzbenikID");
                String imePrezime = rs.getString("imePrezime");
                String korisnickoIme = rs.getString("korisnickoIme");
                String lozinka = rs.getString("lozinka");
                
                ulogovaniSluzbenik = new Sluzbenik(sluzbenikID, imePrezime, korisnickoIme, lozinka);
                rezultat.add(ulogovaniSluzbenik);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sluzbenik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }

    /**
     * @return the sluzbenikID
     */
   
    

}
