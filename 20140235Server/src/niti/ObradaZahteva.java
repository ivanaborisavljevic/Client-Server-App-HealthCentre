/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domen.Doktor;
import domen.Lek;
import domen.Pacijent;
import domen.Pregled;
import domen.Sluzbenik;
import domen.Smena;
import domen.Specijalizacija;

import domen.VrstaPregleda;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.TransferObjekatOdgovor;
import komunikacija.Operacije;
import komunikacija.TransferObjekatZahtev;
import kontroler.Kontroler;

/**
 *
 * @author Ivana
 */
public class ObradaZahteva extends Thread {

    Socket s;

    public ObradaZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            TransferObjekatZahtev toz = primiZahtev();
            TransferObjekatOdgovor too = new TransferObjekatOdgovor();

            switch (toz.getOperacija()) {
                case Operacije.LOGIN:
                    Sluzbenik sluzbenik = (Sluzbenik) toz.getParametar();
                    Sluzbenik ulogovani = Kontroler.getInstance().nadjiSluzbenika(sluzbenik);
                    too.setRezultat(ulogovani);
                    break;
                case Operacije.SACUVAJ_PACIJENTA:

                    Pacijent pacijent = (Pacijent) toz.getParametar();
                    too = Kontroler.getInstance().zapamtiPacijenta(pacijent);

                    break;
                case Operacije.SACUVAJ_PREGLED:

                    Pregled pregled = (Pregled) toz.getParametar();
                    too = Kontroler.getInstance().zapamtiPregled(pregled);

                    break;
                case Operacije.VRATI_SPECIJALIZACIJE:
                    ArrayList<Specijalizacija> lista = Kontroler.getInstance().vratiSpecijalizacije();
                    too.setRezultat(lista);
                    break;
                case Operacije.VRATI_VRSTE_PREGLEDA:
                    ArrayList<VrstaPregleda> listavp = Kontroler.getInstance().vratiVrstePregleda();
                    too.setRezultat(listavp);
                    break;
                case Operacije.VRATI_SMENE:
                    ArrayList<Smena> listasm = Kontroler.getInstance().vratiSmene();
                    too.setRezultat(listasm);
                    break;
                     case Operacije.VRATI_LEKOVE:
                    ArrayList<Lek> listalekova = Kontroler.getInstance().vratiLekove();
                    too.setRezultat(listalekova);
                    break;
                case Operacije.SACUVAJ_DOKTORA:
                    Doktor doktor = (Doktor) toz.getParametar();
                    too = Kontroler.getInstance().zapamtiDoktora(doktor);
                   
                    break;
                case Operacije.VRATI_PACIJENTE:
                    ArrayList<Pacijent> pacijenti = Kontroler.getInstance().vratiPacijente();
                    too.setRezultat(pacijenti);
                    break;
                case Operacije.OBRISI_PACIJENTA:
                    Pacijent pacijentObrisi = (Pacijent) toz.getParametar();
                    too = Kontroler.getInstance().obrisiPacijenta(pacijentObrisi);
                    break;
               
                case Operacije.VRATI_PACIJENTA:
                    Pacijent pacijentZaVracanje = (Pacijent)toz.getParametar();
                    Pacijent pac = Kontroler.getInstance().ucitajPacijenta(pacijentZaVracanje);
                    too.setRezultat(pac);
                    break;
                    case Operacije.VRATI_DOKTORA:
                    Doktor doktorZaVracanje = (Doktor)toz.getParametar();
                    Doktor dok = Kontroler.getInstance().ucitajDoktora(doktorZaVracanje);
                    too.setRezultat(dok);
                    break;
                    case Operacije.VRATI_PREGLED:
                    Pregled pregledZaVracanje = (Pregled)toz.getParametar();
                    Pregled pre = Kontroler.getInstance().ucitajPregled(pregledZaVracanje);
                    too.setRezultat(pre);
                    break;
                case Operacije.IZMENI_PACIJENTA:
                    Pacijent pacijentIzmena = (Pacijent) toz.getParametar();
                    too = Kontroler.getInstance().izmeniPacijenta(pacijentIzmena);
                    break;
                     case Operacije.IZMENI_PREGLED:
                    Pregled pregledIzmena = (Pregled) toz.getParametar();
                    too = Kontroler.getInstance().izmeniPregled(pregledIzmena);
                    break;
                case Operacije.IZMENI_DOKTORA:
                    Doktor doktorIzmena = (Doktor) toz.getParametar();
                    too = Kontroler.getInstance().izmeniDoktora(doktorIzmena);
                    break;
                

                case Operacije.VRATI_DOKTORE:
                    ArrayList<Doktor> doktori = Kontroler.getInstance().vratiDoktore();
                    too.setRezultat(doktori);
                    break;
                case Operacije.VRATI_SLOBODNE_DOKTORE:
                    VrstaPregleda vp = (VrstaPregleda) toz.getParametar();
                    Date datumIVreme = (Date) toz.getParametar2();
                    ArrayList<Doktor> slobodniDoktori = Kontroler.getInstance().vratiSLobodneDoktore(vp, datumIVreme);
                    too.setRezultat(slobodniDoktori);
                    break;
                case Operacije.OBRISI_DOKTORA:
                    Doktor doktorObrisi = (Doktor) toz.getParametar();
                    too = Kontroler.getInstance().obrisiDoktora(doktorObrisi);
                    break;
                case Operacije.VRATI_LISTU_PREGLEDA:
                    Pacijent p = (Pacijent) toz.getParametar();
                    ArrayList<Pregled> pregledi = Kontroler.getInstance().vratiPreglede(p);
                    too.setRezultat(pregledi);
                    break;
                case Operacije.VRATI_LISTU_PREGLEDA_D:
                    Doktor d = (Doktor) toz.getParametar();
                    ArrayList<Pregled> pregledid = Kontroler.getInstance().vratiPreglede(d);
                    too.setRezultat(pregledid);
                    break;
                   

            }

            posaljiOdgovor(too);

        }
    }

    private TransferObjekatZahtev primiZahtev() {
        TransferObjekatZahtev toz = new TransferObjekatZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
//ovde se javlja greska ako ili soket nij ekonektovan ili je greska u kreiranju input stream-a
            toz = (TransferObjekatZahtev) ois.readObject();
            
            
        } catch (IOException ex) {
            Kontroler.getInstance().getListaSluzbenika().remove(s);
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toz;
    }

    private void posaljiOdgovor(TransferObjekatOdgovor too) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(too);

        } catch (IOException ex) {

            Kontroler.getInstance().getListaSluzbenika().remove(s);

            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
