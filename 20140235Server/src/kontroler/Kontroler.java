/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import dbb.DBBroker;
import domen.Doktor;
import domen.Lek;
import domen.Pacijent;
import domen.Pregled;
import domen.Sluzbenik;
import domen.Smena;
import domen.Specijalizacija;

import domen.VrstaPregleda;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import komunikacija.TransferObjekatOdgovor;
import so.SOIzmeniDoktora;
import so.SOIzmeniPacijenta;
import so.SOIzmeniPregled;

import so.SONadjiSluzbenika;
import so.SOObrisiDoktora;
import so.SOObrisiPacijenta;

import so.SOUcitajDoktora;
import so.SOUcitajPacijenta;
import so.SOUcitajPregled;
import so.SOVratiListuDoktora;
import so.SOVratiListuLekova;
import so.SOVratiListuPacijenata;
import so.SOVratiListuPregleda;
import so.SOVratiListuSlobodnihDoktora;
import so.SOVratiListuSmena;
import so.SOVratiListuSpecijalizacija;

import so.SOVratiListuVrstaPregleda;
import so.SOZapamtiDoktora;
import so.SOZapamtiPacijenta;
import so.SOZapamtiPregled;

/**
 *
 * @author Ivana
 */
public class Kontroler {

    private static Kontroler instance;
    private DBBroker db;
    ArrayList<Socket> listaSluzbenika;

    private Kontroler() {
        db = new DBBroker();
        listaSluzbenika = new ArrayList<>();
    }

    public static Kontroler getInstance() {

        if (instance == null) {
            instance = new Kontroler();

        }
        return instance;
    }

    public ArrayList<Socket> getListaSluzbenika() {
        return listaSluzbenika;
    }

    public Sluzbenik nadjiSluzbenika(Sluzbenik sluzbenik) {
        SONadjiSluzbenika so = new SONadjiSluzbenika(sluzbenik);

        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Sluzbenik s = new Sluzbenik(-3, "", "", "");
            // Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
            return s;
        }

        return so.getUlogovani();

    }

    public TransferObjekatOdgovor zapamtiPacijenta(Pacijent pacijent) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();
        try {
            SOZapamtiPacijenta so = new SOZapamtiPacijenta(pacijent);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
            // System.out.println("KONTROLER TO REZULTAT"+too.getRezultat());
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return too;
    }

    public ArrayList<Specijalizacija> vratiSpecijalizacije() {
        SOVratiListuSpecijalizacija so = new SOVratiListuSpecijalizacija();

        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getListaSpecijalizacija();
    }

    public ArrayList<Smena> vratiSmene() {
        SOVratiListuSmena so = new SOVratiListuSmena();

        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getListaSmena();
    }

    public TransferObjekatOdgovor zapamtiDoktora(Doktor doktor) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();
        try {
            SOZapamtiDoktora so = new SOZapamtiDoktora(doktor);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);

        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return too;

    }

    public ArrayList<Pacijent> vratiPacijente() {
        SOVratiListuPacijenata so = new SOVratiListuPacijenata();
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getListaPacijenata();
    }

    public TransferObjekatOdgovor obrisiPacijenta(Pacijent pacijentObrisi) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();

        try {
            SOObrisiPacijenta so = new SOObrisiPacijenta(pacijentObrisi);

            so.opsteIzvrsenjeSO();

            too.setRezultat(true);
        } catch (Exception ex) {

            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public TransferObjekatOdgovor izmeniPacijenta(Pacijent pacijentIzmena) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();
        try {
            SOIzmeniPacijenta so = new SOIzmeniPacijenta(pacijentIzmena);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return too;
    }

    public TransferObjekatOdgovor izmeniDoktora(Doktor doktorIzmena) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();
        try {
            SOIzmeniDoktora so = new SOIzmeniDoktora(doktorIzmena);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return too;
    }

    public ArrayList<Doktor> vratiDoktore() {
        SOVratiListuDoktora so = new SOVratiListuDoktora();
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getListaDoktora();
    }

    public TransferObjekatOdgovor obrisiDoktora(Doktor doktorObrisi) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();

        try {
            SOObrisiDoktora so = new SOObrisiDoktora(doktorObrisi);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return too;
    }

    public ArrayList<Pregled> vratiPreglede(Pacijent p) {
        SOVratiListuPregleda so = new SOVratiListuPregleda(p);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
        return so.getListaPregleda();

    }

    public ArrayList<VrstaPregleda> vratiVrstePregleda() {
        SOVratiListuVrstaPregleda so = new SOVratiListuVrstaPregleda();
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getListaVrstaPregleda();
    }

    public ArrayList<Doktor> vratiSLobodneDoktore(VrstaPregleda vp, Date datumIVreme) {
        SOVratiListuSlobodnihDoktora so = new SOVratiListuSlobodnihDoktora(vp, datumIVreme);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getListaSlobodnihDoktora();
    }

    public TransferObjekatOdgovor zapamtiPregled(Pregled pregled) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();
        try {
            SOZapamtiPregled so = new SOZapamtiPregled(pregled);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);

        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return too;
    }

   

    
    public ArrayList<Pregled> vratiPreglede(Doktor d) {
        SOVratiListuPregleda so = new SOVratiListuPregleda(d);
        try {
            so.opsteIzvrsenjeSO();
            
        } catch (Exception ex) {
            
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so.getListaPregleda();
    }

    public Pacijent ucitajPacijenta(Pacijent p) {
        SOUcitajPacijenta so = new SOUcitajPacijenta(p);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        return so.getPacijent();
    }

    public Doktor ucitajDoktora(Doktor d) {
        SOUcitajDoktora so = new SOUcitajDoktora(d);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        return so.getDoktor();

    }

    public Pregled ucitajPregled(Pregled p) {
        SOUcitajPregled so = new SOUcitajPregled(p);
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
        
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        return so.getPregled();

    }

    public ArrayList<Lek> vratiLekove() {
        SOVratiListuLekova so = new SOVratiListuLekova();
        try {
            so.opsteIzvrsenjeSO();
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
        return so.getListaLekova();
    }

    public TransferObjekatOdgovor izmeniPregled(Pregled pregledIzmena) {
        TransferObjekatOdgovor too = new TransferObjekatOdgovor();
        try {
            SOIzmeniPregled so = new SOIzmeniPregled(pregledIzmena);
            so.opsteIzvrsenjeSO();
            too.setRezultat(true);
        } catch (Exception ex) {
            too.setRezultat(false);
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return too;

    }

    
}
