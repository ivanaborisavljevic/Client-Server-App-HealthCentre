/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Doktor;
import domen.Pacijent;
import domen.Pregled;
import domen.Smena;
import domen.VrstaPregleda;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Stefan
 */
public class SOVratiListuSlobodnihDoktora extends OpstaSO {

    private ArrayList<Doktor> listaDoktora;
    private ArrayList<Doktor> listaSlobodnihDoktora = new ArrayList<>();

    private ArrayList<Pregled> listaPregledaDoktora = new ArrayList<>();
    VrstaPregleda vrstaPregleda;
    Date datumIVreme;

    public SOVratiListuSlobodnihDoktora(VrstaPregleda vp, Date datumIVreme) {
        super(vp, datumIVreme);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {

            vrstaPregleda = (VrstaPregleda) objekat;

            datumIVreme = (Date) objekat2;
           
            if (vrstaPregleda == null) {
               
                throw new Exception("SERVER:Polje vrsta pregleda ne sme biti null");
            }
            if (datumIVreme == null) {
               
                throw new Exception("SERVER:Polje datum i vreme ne sme biti null");
            }

            if (vrstaPregleda.getVrstaPregledaID() < 0) {
               
                throw new Exception("SERVER:ID vrste pregleda pri prikazu slobodnih doktora ne sme biti <0");
            }

            
           

                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(Calendar.YEAR, 1);
                Date datumGodinuOdSad = cal.getTime();

                if (datumIVreme.after(datumGodinuOdSad)) {
                  
                    throw new Exception("SERVER:*Pregledi se mogu zakazivati godinu dana od sadasnjeg trenutka*");
                }

                List<Smena> smene = (List<Smena>) db.select(new Smena());
                if (smene == null) {
                    throw new Exception("SERVER:Sistem ne može da nađe smene!");
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
                    
                    throw new Exception("SERVER:Ne mogu da se parsiraju pocetak i kraj smene");
                }

                int sati = (int) datumIVreme.getHours();
                int minuti = (int) datumIVreme.getMinutes();
                int godina = (int) pocetakRadnogVr.getYear();
                int mesec = (int) pocetakRadnogVr.getMonth();
                int dan = (int) pocetakRadnogVr.getDate();
                Date vreme1 = new Date(godina, mesec, dan, sati, minuti, 0);

                if (vreme1.before(pocetakRadnogVr) || vreme1.after(krajRadnogVr)) {

                    throw new Exception("SERVER:*Vreme mora biti u okviru radnog vremena, od " + pocetakRadnogVr.getHours() + " h " + pocetakRadnogVr.getMinutes() + " min, do " + krajRadnogVr.getHours() + " h " + krajRadnogVr.getMinutes() + " min*");
                }

                if (datumIVreme.before(new Date())) {
                   
                    throw new Exception("SERVER:Datum i vreme ne mogu biti pre sadasnjeg trenutka");
                }
               

            
        } catch (Exception ex) {
            throw new Exception("SERVER: Doslo je do izuzetka u klasi SOVratiSlobodneDoktore");

        }
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        listaDoktora = (ArrayList<Doktor>) db.select(new Doktor());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date datVr = new Date(datumIVreme.getYear(), datumIVreme.getMonth(), datumIVreme.getDate(), datumIVreme.getHours(), datumIVreme.getMinutes());
        Date zakVreme = sdf.parse(datumIVreme.getHours() + ":" + datumIVreme.getMinutes());

        for (Doktor doktor : listaDoktora) {
            if (doktor.getSpecijalizacija().getSpecijalizacijaID() == vrstaPregleda.getSpecijalizacija().getSpecijalizacijaID()) {

                Date pocetakSmene = sdf.parse(doktor.getSmena().getPocetak());
                Date krajSmene = sdf.parse(doktor.getSmena().getKraj());
                boolean test = true;
                String uslov = "where p.doktorID =" + doktor.getDoktorID();

                listaPregledaDoktora = (ArrayList<Pregled>) db.select(new Pregled(), uslov);

                if (zakVreme.after(pocetakSmene) && zakVreme.before(krajSmene)) {

                    test = true;
                } else {
                    test = false;
                }
                for (Pregled p : listaPregledaDoktora) {

                    Date vremePregleda = sdf.parse(p.getVreme());
                    Date datVr2 = new Date(p.getDatum().getYear(), p.getDatum().getMonth(), p.getDatum().getDate(), vremePregleda.getHours(), vremePregleda.getMinutes());
                    if ((datVr.equals(datVr2))) {

                        test = false;

                    }
                }

                if (test == true) {

                    listaSlobodnihDoktora.add(doktor);
                }
            }

        }

    }

    public ArrayList<Doktor> getListaSlobodnihDoktora() {
        return listaSlobodnihDoktora;
    }

}
