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
 * @author Stefan
 */
public class Terapija implements Serializable, OpstiDomenskiObjekat {
    int terapijaID;
    double doza;
    Pregled pregled;
    Lek lek;
    String opis;
Sluzbenik sluzbenik;
    public Terapija(int terapijaID, double doza, Pregled pregled, Lek lek, String opis, Sluzbenik sluzbenik) {
        this.terapijaID = terapijaID;
        this.doza = doza;
        this.pregled = pregled;
        this.lek = lek;
        this.opis = opis;
        this.sluzbenik = sluzbenik;
    }
public Terapija(double doza, Pregled pregled, Lek lek, String opis, Sluzbenik sluzbenik) {
       
        this.doza = doza;
        this.pregled = pregled;
        this.lek = lek;
        this.opis = opis;
        this.sluzbenik = sluzbenik;
    }
    public Terapija() {
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }

    public void setSluzbenik(Sluzbenik sluzbenik) {
        this.sluzbenik = sluzbenik;
    }

    public Sluzbenik getSluzbenik() {
        return sluzbenik;
    }

    public double getDoza() {
        return doza;
    }

    public Lek getLek() {
        return lek;
    }

    public Pregled getPregled() {
        return pregled;
    }

    public int getTerapijaID() {
        return terapijaID;
    }

    public void setDoza(double doza) {
        this.doza = doza;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }

    public void setTerapijaID(int terapijaID) {
        this.terapijaID = terapijaID;
    }
    

    @Override
    public String vratiVrednostiAtributa() {
        return "('"+getDoza()+"','"+getPregled().getPregledID()+"','"+getLek().getLekID()+"','"+getOpis()+"','"+getSluzbenik().getSluzbenikID()+"')";
    }

    @Override
    public String postaviVrednostiAtributa() {
        return "";
    }

    @Override
    public String vratiImeKlase() {
        return "terapija";
    }

    @Override
    public String vratiAtributeKlase() {
        return "(doza, pregledID, lekID, opis, sluzbenikID)";
    }

    @Override
    public String vratiUslovPretrage() {
        return "";
    }

    @Override
    public String vratiUslovIzmene() {
        return "where terapijaID="+getTerapijaID()+"";
    }

    @Override
    public String vratiUslovBrisanja() {
        return "where terapijaID ="+getTerapijaID();
        }

    @Override
    public String vratiTabeluPretrage() {
        return "terapija t join pregled p on t.pregledID = p.pregledID join vrstapregleda vp on p.vrstaPregledaID = vp.vrstaPregledaID join specijalizacija sp on vp.specijalizacijaID = sp.specijalizacijaID join doktor d on p.doktorID = d.doktorID join smena sme on d.smenaID = sme.smenaID join pacijent pa ON p.pacijentID = pa.pacijentID join sluzbenik sl ON p.sluzbenikID = sl.sluzbenikID join lek l on t.lekID = l.lekID join sluzbenik sluz on t.sluzbenikID = sluz.sluzbenikID ";
    }

    @Override
    public String vratiAtributePretrage() {
        return "sluz.`sluzbenikID` as sluzID ,sluz.`imePrezime` as sluzImePrez,  sluz.`korisnickoIme` as sluzKorIme, sluz.`lozinka` as sluzLozinka, t.terapijaID, t.`doza`, t.`opis` as opisTerapije, p.`pregledID` , p.`datum`, p.`vreme`, p.`vrstaPregledaID`, p.`realizovan`, p.`cena` as cenaPregleda, p.`doktorID`, p.`pacijentID`, vp.`naziv` AS nazivVP, vp.`specijalizacijaID`, vp.`cena` as cenaVP, sp.`naziv` AS nazivSP, d.`imePrezime` AS imePrezimeD, d.`smenaID`, sme.`pocetak`, sme.`kraj`, sme.`naziv` AS nazivSM,pa.`imePrezime` AS imePrezimePA, pa.`jmbg`, pa.`datumRodjenja`, pa.`adresa`, pa.`grad`, pa.`telefon`,p.`opis`, p.`sluzbenikID`, sl.`imePrezime` as sluzbenikImePrezime, sl.`korisnickoIme` as sluzbenikKorIme, sl.`lozinka` as sluzbenikLozinka,l.`lekID`, l.`naziv` as nazivLeka, l.`proizvodjac`, l.`oboljenje`";

    }

    @Override
    public ArrayList<?> napuni(ResultSet rs) {
        ArrayList<Terapija> rezultat = new ArrayList<>();
        try {
             while (rs.next()) {
                 int sluzId = rs.getInt("sluzID");
                 String sluzImePrez = rs.getString("sluzImePrez");
                 String sluzKorIme = rs.getString("sluzKorIme");
                 String sluzLozinka = rs.getString("sluzLozinka");
                 Sluzbenik sluz = new Sluzbenik(sluzId, sluzImePrez, sluzKorIme, sluzLozinka);
                int terapijaID = rs.getInt("terapijaID");
                double doza = rs.getDouble("doza");
                String opisT = rs.getString("opisTerapije");
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
                String sluzbenikKorIme = rs.getString("sluzbenikKorIme");
                String sluzbenikLozinka = rs.getString("sluzbenikLozinka");
                Sluzbenik sluzbenik = new Sluzbenik(sluzbenikID, sluzImePrezime, sluzbenikKorIme, sluzbenikLozinka);

                Pregled p = new Pregled(pregledID, datum, vreme, vp, realizovan, cena, d, pac, opis, sluzbenik);
                int lekID = rs.getInt("lekID");
                String nazivLeka = rs.getString("nazivLeka");
                String proizvodjac = rs.getString("proizvodjac");
                String oboljenje = rs.getString("oboljenje");
                Lek l = new Lek(lekID, nazivLeka, proizvodjac, oboljenje);
                Terapija t = new Terapija(terapijaID, doza, p, l, opisT, sluz);
                rezultat.add(t);
                 
                 
                 
                 
                 
                 
                 
                 
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Smena.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
     @Override
    public boolean equals(Object obj) {
        Terapija t;
        if (obj instanceof Terapija){
        t = (Terapija)obj;
        return t.lek.equals(this.lek); //To change body of generated methods, choose Tools | Templates.

        }
        return false;
    }    
}
