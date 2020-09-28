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
public class Doktor implements Serializable, OpstiDomenskiObjekat {
    private int doktorID;
    private String imePrezime;
    private Specijalizacija specijalizacija;
    private Smena smena;

    public Doktor() {
    }

    public Doktor(int doktorID, String imePrezime, Specijalizacija specijalizacija, Smena smena) {
        this.doktorID = doktorID;
        this.imePrezime = imePrezime;
        this.specijalizacija = specijalizacija;
        this.smena = smena;
    }

    /**
     * @return the doktorID
     */
    public int getDoktorID() {
        return doktorID;
    }

    /**
     * @param doktorID the doktorID to set
     */
    public void setDoktorID(int doktorID) {
        this.doktorID = doktorID;
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

    /**
     * @return the smena
     */
    public Smena getSmena() {
        return smena;
    }

    /**
     * @param smena the smena to set
     */
    public void setSmena(Smena smena) {
        this.smena = smena;
    }
 @Override
    public String toString() {
        return imePrezime;   
    
    }

    @Override
    public String vratiVrednostiAtributa() {
        return "('"+getImePrezime()+"','"+getSpecijalizacija().getSpecijalizacijaID()+"','"+getSmena().getSmenaID()+"')";
    }

    @Override
    public String postaviVrednostiAtributa() {
          return "imePrezime='"+getImePrezime()+"',specijalizacijaID='"+getSpecijalizacija().getSpecijalizacijaID()+"',smenaID='"+getSmena().getSmenaID()+"'";
    }

    @Override
    public String vratiImeKlase() {
        return "doktor";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(imePrezime, specijalizacijaID, smenaID)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where doktorID="+getDoktorID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
        return "where doktorID="+getDoktorID()+"";
    }

    @Override
    public String vratiTabeluPretrage() {
        return "doktor d join specijalizacija s on d.specijalizacijaID =s.specijalizacijaID join smena sm on d.smenaID=sm.smenaID";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }
    
    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<Doktor> rezultat = new ArrayList<>();
        try {
             while (rs.next()) {
                int doktorID = rs.getInt(1);
                String imePrezime = rs.getString(2);
                int specijalizacijaID = rs.getInt(5);
                String nazivSpecijalizacije = rs.getString(6);
                Specijalizacija s = new Specijalizacija(specijalizacijaID, nazivSpecijalizacije);
                int smenaID = rs.getInt(7);
                String pocetak = rs.getString(8);
                String kraj = rs.getString(9);
                String nazivSmene = rs.getString(10);
                Smena sm = new Smena(smenaID, pocetak, kraj, nazivSmene);
                Doktor d = new Doktor(doktorID, imePrezime, s, sm);
                rezultat.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Doktor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }    
}
