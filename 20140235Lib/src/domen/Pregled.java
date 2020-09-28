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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivana
 */
public class Pregled implements Serializable, OpstiDomenskiObjekat {

    private int pregledID;
    private Date datum;
    private String vreme;
    private VrstaPregleda vrstaPregleda;
    private boolean realizovan;
    private double cena;
    private Doktor doktor;
    private Pacijent pacijent;
    private String opis;
    private Sluzbenik sluzbenik;
    private ArrayList<Terapija> listaTerapija;

    public Pregled(int pregledID, Date datum, String vreme, VrstaPregleda vrstaPregleda, boolean realizovan, double cena, Doktor doktor, Pacijent pacijent, String opis, Sluzbenik sluzbenik, ArrayList<Terapija> listaTerapija) {
        this.pregledID = pregledID;
        this.datum = datum;
        this.vreme = vreme;
        this.vrstaPregleda = vrstaPregleda;
        this.realizovan = realizovan;
        this.cena = cena;
        this.doktor = doktor;
        this.pacijent = pacijent;
        this.opis = opis;
        this.sluzbenik = sluzbenik;
        this.listaTerapija = listaTerapija;
    }

    public Pregled(Date datum, String vreme, VrstaPregleda vrstaPregleda, boolean realizovan, double cena, Doktor doktor, Pacijent pacijent, String opis, Sluzbenik sluzbenik) {

        this.datum = datum;
        this.vreme = vreme;
        this.vrstaPregleda = vrstaPregleda;
        this.realizovan = realizovan;
        this.cena = cena;
        this.doktor = doktor;
        this.pacijent = pacijent;
        this.opis = opis;
        this.sluzbenik = sluzbenik;
    }

    public Pregled(int pregledID, Date datum, String vreme, VrstaPregleda vrstaPregleda, boolean realizovan, double cena, Doktor doktor, Pacijent pacijent, String opis, Sluzbenik sluzbenik) {
        this.pregledID = pregledID;
        this.datum = datum;
        this.vreme = vreme;
        this.vrstaPregleda = vrstaPregleda;
        this.realizovan = realizovan;
        this.cena = cena;
        this.doktor = doktor;
        this.pacijent = pacijent;
        this.opis = opis;
        this.sluzbenik = sluzbenik;
    }

    public Pregled() {
    }

    public int getPregledID() {
        return pregledID;
    }

    public void setPregledID(int pregledID) {
        this.pregledID = pregledID;
    }

    public void setListaTerapija(ArrayList<Terapija> listaTerapija) {
        this.listaTerapija = listaTerapija;
    }

    public List<Terapija> getListaTerapija() {
        return listaTerapija;
    }

    /**
     *
     * /
     *
     **
     * @return the datum
     */
    public Date getDatum() {
        return datum;
    }

    /**
     * @param datum the datum to set
     */
    public void setDatum(Date datum) {
        this.datum = datum;
    }

    /**
     * @return the vreme
     */
    public String getVreme() {
        return vreme;
    }

    /**
     * @param vreme the vreme to set
     */
    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    /**
     * @return the vrstaPregleda
     */
    public VrstaPregleda getVrstaPregleda() {
        return vrstaPregleda;
    }

    /**
     * @param vrstaPregleda the vrstaPregleda to set
     */
    public void setVrstaPregleda(VrstaPregleda vrstaPregleda) {
        this.vrstaPregleda = vrstaPregleda;
    }

    /**
     * @return the realizovan
     */
    public boolean isRealizovan() {
        return realizovan;
    }

    /**
     * @param realizovan the realizovan to set
     */
    public void setRealizovan(boolean realizovan) {
        this.realizovan = realizovan;
    }

    /**
     * @return the cena
     */
    public double getCena() {
        return cena;
    }

    /**
     * @param cena the cena to set
     */
    public void setCena(double cena) {
        this.cena = cena;
    }

    /**
     * @return the doktor
     */
    public Doktor getDoktor() {
        return doktor;
    }

    /**
     * @param doktor the doktor to set
     */
    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    /**
     * @return the pacijent
     */
    public Pacijent getPacijent() {
        return pacijent;
    }

    /**
     * @param pacijent the pacijent to set
     */
    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }

    public void setSluzbenik(Sluzbenik sluzbenik) {
        this.sluzbenik = sluzbenik;
    }

    @Override
    public String toString() {
        return vrstaPregleda.getNaziv() + " " + getDatum() + " " + getVreme() + " " + getCena() + " , doktor:" + getDoktor().getImePrezime() + " , pacijent " + getPacijent() + ", opis: " + getOpis();

    }

    @Override
    public String vratiVrednostiAtributa() {
        Date date = new java.sql.Date(getDatum().getTime());
        int realizovanint;
        if (isRealizovan()) {
            realizovanint = 1;
        } else {
            realizovanint = 0;
        }
        return "('" + date + "','" + getVreme() + "','" + getVrstaPregleda().getVrstaPregledaID() + "','" + realizovanint + "','" + getCena() + "','" + getDoktor().getDoktorID() + "','" + getPacijent().getPacijentID() + "','" + getOpis() + "','" + getSluzbenik().getSluzbenikID() + "')";

    }

    @Override
    public String postaviVrednostiAtributa() {
        int realizovanint;
        if (isRealizovan()) {
            realizovanint = 1;
        } else {
            realizovanint = 0;
        }
        return "realizovan = '" + realizovanint + "', opis='" + getOpis() + "'";
    }

    @Override
    public String vratiImeKlase() {
        return "pregled";
    }

    @Override
    public String vratiAtributeKlase() {

        return "(datum, vreme, vrstaPregledaID, realizovan, cena, doktorID, pacijentID, opis, sluzbenikID)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where pregledID=" + getPregledID();
    }

    @Override
    public String vratiUslovBrisanja() {
        return "where pregledID=" + getPregledID();
    }

    @Override
    public String vratiTabeluPretrage() {
        return "pregled p join vrstapregleda vp on p.vrstaPregledaID = vp.vrstaPregledaID join specijalizacija sp on vp.specijalizacijaID = sp.specijalizacijaID join doktor d on p.doktorID = d.doktorID join smena sme on d.smenaID = sme.smenaID join pacijent pa ON p.pacijentID = pa.pacijentID join sluzbenik sl ON p.sluzbenikID = sl.sluzbenikID";
    }

    @Override
    public String vratiAtributePretrage() {
        return "p.`pregledID` , p.`datum`, p.`vreme`, p.`vrstaPregledaID`, p.`realizovan`, p.`cena` as cenaPregleda, p.`doktorID`, p.`pacijentID`, vp.`naziv` AS nazivVP, vp.`specijalizacijaID`, vp.`cena` as cenaVP, sp.`naziv` AS nazivSP, d.`imePrezime` AS imePrezimeD, d.`smenaID`, sme.`pocetak`, sme.`kraj`, sme.`naziv` AS nazivSM,pa.`imePrezime` AS imePrezimePA, pa.`jmbg`, pa.`datumRodjenja`, pa.`adresa`, pa.`grad`, pa.`telefon`,p.`opis`, p.`sluzbenikID`, sl.`imePrezime` as sluzbenikImePrezime, sl.`korisnickoIme` as sluzbenikKorIme, sl.`lozinka` as sluzbenikLozinka";
    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<Pregled> rezultat = new ArrayList<>();
        try {
            while (rs.next()) {
                int pregledID = rs.getInt("pregledID");
                Date datum = rs.getDate("datum");
                String vreme = rs.getString("vreme");
                boolean realizovan = false;
                if (rs.getInt("realizovan") == 1) {
                    realizovan = true;
                }
                double cena = rs.getDouble("cenaPregleda");
                int vrstaPregledaID = rs.getInt("vrstaPregledaID");
                String nazivVrstePregleda = rs.getString("nazivVP");
                double cenaVP = rs.getDouble("cenaVP");
                int specijalizacijaID = rs.getInt("specijalizacijaID");
                String nazivSpecijalizacije = rs.getString("nazivSP");
                Specijalizacija s = new Specijalizacija(specijalizacijaID, nazivSpecijalizacije);

                VrstaPregleda vp = new VrstaPregleda(vrstaPregledaID, nazivVrstePregleda, s, cenaVP);

                int doktorID = rs.getInt("doktorID");
                String imePrezimeDoktora = rs.getString("imePrezimeD");
                int smenaID = rs.getInt("smenaID");
                String pocetak = rs.getString("pocetak");
                String kraj = rs.getString("kraj");
                String nazivSmene = rs.getString("nazivSM");
                Smena smena = new Smena(smenaID, pocetak, kraj, nazivSmene);

                Doktor d = new Doktor(doktorID, imePrezimeDoktora, s, smena);

                int pacijentID = rs.getInt("pacijentID");
                String imePrezimePacijenta = rs.getString("imePrezimePA");
                String jmbg = rs.getString("jmbg");
                Date datumRodjenja = rs.getDate("datumRodjenja");
                String adresa = rs.getString("adresa");
                String grad = rs.getString("grad");
                String telefon = rs.getString("telefon");
                Pacijent pac = new Pacijent(pacijentID, imePrezimePacijenta, jmbg, datumRodjenja, adresa, grad, telefon);
                String opis = rs.getString("opis");
                int sluzbenikID = rs.getInt("sluzbenikID");
                String sluzImePrezime = rs.getString("sluzbenikImePrezime");
                String sluzKorIme = rs.getString("sluzbenikKorIme");
                String sluzLozinka = rs.getString("sluzbenikLozinka");
                Sluzbenik sluzbenik = new Sluzbenik(sluzbenikID, sluzImePrezime, sluzKorIme, sluzLozinka);

                Pregled p = new Pregled(pregledID, datum, vreme, vp, realizovan, cena, d, pac, opis, sluzbenik);
                rezultat.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pregled.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rezultat;
    }

}
