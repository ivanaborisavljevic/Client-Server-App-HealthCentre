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
public class Pacijent implements Serializable, OpstiDomenskiObjekat{
    private int pacijentID;
    private String imePrezime;
    private String jmbg;
    private Date datumRodjenja;
    private String adresa;
    private String grad;
    private String telefon;

    public Pacijent() {
    }

    public Pacijent(int pacijentID, String imePrezime, String jmbg, Date datumRodjenja, String adresa, String grad, String telefon) {
        this.pacijentID = pacijentID;
        this.imePrezime = imePrezime;
        this.jmbg = jmbg;
        this.datumRodjenja = datumRodjenja;
        this.adresa = adresa;
        this.grad = grad;
        this.telefon = telefon;
    }

    
    /**
     * @return the pacijentID
     */
    public int getPacijentID() {
        return pacijentID;
    }

    /**
     * @param pacijentID the pacijentID to set
     */
    public void setPacijentID(int pacijentID) {
        this.pacijentID = pacijentID;
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
     * @return the jmbg
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * @param jmbg the jmbg to set
     */
    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    /**
     * @return the datumRodjenja
     */
    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    /**
     * @param datumRodjenja the datumRodjenja to set
     */
    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    /**
     * @return the adresa
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * @param adresa the adresa to set
     */
    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    /**
     * @return the grad
     */
    public String getGrad() {
        return grad;
    }

    /**
     * @param grad the grad to set
     */
    public void setGrad(String grad) {
        this.grad = grad;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    @Override
    public String toString() {
        return imePrezime;   
    
    }

    @Override
    public String vratiVrednostiAtributa() {
        Date date=new java.sql.Date(getDatumRodjenja().getTime());
        return "('"+getImePrezime()+"','"+getJmbg()+"','"+date+"','"+getAdresa()+"','"+getGrad()+"','"+getTelefon()+ "')";
    }

    @Override
    public String postaviVrednostiAtributa() {
      Date datum= new java.sql.Date(getDatumRodjenja().getTime());
        
        return "imePrezime='"+getImePrezime()+"',jmbg='"+getJmbg()+"',datumRodjenja='"+datum+"',adresa='"+getAdresa()+"',grad='"+getGrad()+"',telefon='"+getTelefon()+"'";
      
    }

    @Override
    public String vratiImeKlase() {
        return "pacijent";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(imePrezime, jmbg, datumRodjenja, adresa, grad, telefon)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where pacijentID="+getPacijentID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
       return "where pacijentID="+getPacijentID()+"";
    }

    @Override
    public String vratiTabeluPretrage() {
        return "pacijent";
    }

    @Override
    public String vratiAtributePretrage() {
        return "*";
    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<Pacijent> rezultat = new ArrayList<>();
        try {
             while (rs.next()) {
                int pacijentID = rs.getInt(1);
                String imePrezime = rs.getString(2);
                String jmbg = rs.getString(3);
                Date datumRodjenja = rs.getDate(4);
                String adresa = rs.getString(5);
                String grad = rs.getString(6);
                String telefon =  rs.getString(7);
                Pacijent p = new Pacijent(pacijentID, imePrezime, jmbg, datumRodjenja, adresa, grad, telefon);
                rezultat.add(p);
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pacijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
    
}
