/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Doktor;
import domen.Pregled;
import domen.Smena;
import domen.VrstaPregleda;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Operacije;

/**
 *
 * @author Stefan
 */
public class SOZapamtiPregled extends OpstaSO {

    Pregled pregled;

    public SOZapamtiPregled(Pregled pregled) {
        super(pregled);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            pregled = (Pregled) objekat;

            
            if (pregled.getDoktor() == null) {
               
                throw new Exception("SERVER: Doktor ne sme biti null kada se cuva pregled");
            }
            if (pregled.getSluzbenik() == null) {

               
                
                throw new Exception("SERVER: Sluzbenik ne sme biti null kada se cuva pregled");
            }
            if (pregled.getSluzbenik() == null) {

             

                throw new Exception("SERVER: Sluzbenik ne sme biti null kada se cuva pregled");
               

            }
            if (pregled.getSluzbenik().getSluzbenikID() < 0) {
               
                throw new Exception("SERVER: Polje sluzbenik id ne sme biti negativno pri cuvanju pregleda");
            }
            if (pregled.getPacijent() == null) {
              
                throw new Exception("SERVER: Pacijent ne sme biti null kada se cuva pregled");
            }

            if (pregled.getDoktor().getDoktorID() < 0) {
               
                throw new Exception("Polje doktor id ne sme biti <0 pri cuvanju pregleda ");
            }

            if (pregled.getVrstaPregleda() == null) {
             
                throw new Exception("SERVER: Polje vrsta pregleda ne sme biti null kada se cuva pregled");
            }

            if (pregled.getDatum() == null) {
               
                throw new Exception("SERVER: Polje datum ne sme biti null");
            }
            if (pregled.getVreme().isEmpty()) {

                
                throw new Exception("Polje vreme ne sme biti prazno");
            }

            if (pregled.getVrstaPregleda().getVrstaPregledaID() < 0) {
               
                throw new Exception("SERVER: ID vrste pregleda pri cuvanju pregleda ne sme biti <0");
            }

           
           
                int sati = (int) Integer.parseInt(pregled.getVreme().split(":")[0]);
                int minuti = (int) Integer.parseInt(pregled.getVreme().split(":")[1]);
                Date datumIVreme = new Date((int) pregled.getDatum().getYear(), (int) pregled.getDatum().getMonth(), (int) pregled.getDatum().getDate(), sati, minuti);

                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.YEAR, 1);
                Date datumGodinuOdSad = cal.getTime();

                if (datumIVreme.after(datumGodinuOdSad)) {
                  
                    throw new Exception("SERVER: *Pregledi se mogu zakazivati do godinu dana od sadasnjeg trenutka*");
                }

                List<Smena> smene = (List<Smena>) db.select(new Smena());
                if (smene == null) {
                    throw new Exception("SERVER: Sistem ne može da nađe smene!");
                }
                Smena maxKraj = smene.get(0);
                Smena minPocetak = smene.get(smene.size() - 1);
                for (int i = 0; i < smene.size(); i++) {
                    if (Integer.parseInt(smene.get(i).getPocetak().split(":")[0]) < Integer.parseInt(minPocetak.getPocetak().split(":")[0])
                            || (Integer.parseInt(smene.get(i).getPocetak().split(":")[0]) == Integer.parseInt(minPocetak.getPocetak().split(":")[0]))
                            && Integer.parseInt(smene.get(i).getPocetak().split(":")[1]) < Integer.parseInt(minPocetak.getPocetak().split(":")[1])) {

                        minPocetak = smene.get(i);

                    }

                    if (Integer.parseInt(smene.get(i).getPocetak().split(":")[0]) > Integer.parseInt(minPocetak.getPocetak().split(":")[0])
                            || (Integer.parseInt(smene.get(i).getPocetak().split(":")[0]) == Integer.parseInt(minPocetak.getPocetak().split(":")[0]))
                            && Integer.parseInt(smene.get(i).getPocetak().split(":")[1]) > Integer.parseInt(minPocetak.getPocetak().split(":")[1])) {

                        maxKraj = smene.get(i);

                    }

                }
                SimpleDateFormat sdfv = new SimpleDateFormat("HH:mm");
                sdfv.setLenient(false);
                Date pocetakRadnogVr = null;
                Date krajRadnogVr = null;
                try {
                    krajRadnogVr = sdfv.parse(maxKraj.getKraj());
                    pocetakRadnogVr = sdfv.parse(minPocetak.getPocetak());
                } catch (ParseException ex) {
                   
                    throw new Exception("SERVER: Ne mogu da se parsiraju pocetak i kraj smene");
                }

                int sati1 = (int) datumIVreme.getHours();
                int minuti1 = (int) datumIVreme.getMinutes();
                int godina = (int) pocetakRadnogVr.getYear();
                int mesec = (int) pocetakRadnogVr.getMonth();
                int dan = (int) pocetakRadnogVr.getDate();
                Date vreme1 = new Date(godina, mesec, dan, sati1, minuti1, 0);

                if (vreme1.before(pocetakRadnogVr) || vreme1.after(krajRadnogVr)) {

                   
                    throw new Exception("SERVER: *Vreme mora biti u okviru radnog vremena, od " + pocetakRadnogVr.getHours() + " h " + pocetakRadnogVr.getMinutes() + " min, do " + krajRadnogVr.getHours() + " h " + krajRadnogVr.getMinutes() + " min*");
                }

                if (datumIVreme.before(new Date())) {
                    
                    throw new Exception("SERVER: Datum i vreme ne mogu biti pre sadasnjeg trenutka");
                }

                List<Pregled> pregledi = (List<Pregled>) db.select(new Pregled(), "where p.pacijentID=" + pregled.getPacijent().getPacijentID());
                for (Pregled p : pregledi) {
                    int satiP = Integer.parseInt(p.getVreme().split(":")[0]);
                    int minutiP = Integer.parseInt(p.getVreme().split(":")[1]);
                    Date datumVreme = new Date(p.getDatum().getYear(), p.getDatum().getMonth(), p.getDatum().getDate(), satiP, minutiP);
                    if (datumVreme.equals(datumIVreme)) {
                        
                        throw new Exception("SERVER: *Pacijent vec ima zakazan pregled u to vreme, unesite drugi termin*");
                    }

                }

           
        } catch (Exception ex) {

            Logger.getLogger(SOZapamtiPregled.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("SERVER: Doslo je do izuzetka u klasi SOZapamtiPregled");
        }

    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.insert(pregled);
    }
}
