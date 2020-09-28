/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Pacijent;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import komunikacija.Operacije;

/**
 *
 * @author Ivana
 */
public class SOZapamtiPacijenta extends OpstaSO {

    Pacijent pacijent;

    public SOZapamtiPacijenta(Pacijent pacijent) {
        super(pacijent);
    }

    @Override
    protected void proveriPreduslov() throws Exception {
        try {
            pacijent = (Pacijent) objekat;

            if (pacijent.getImePrezime().isEmpty()) {
              
                throw new Exception("SERVER: Polje ime i prezime ne sme biti prazno*");
            }
            if (pacijent.getJmbg().isEmpty()) {
               
                throw new Exception("SERVER: Polje jmbg ne sme biti prazno*");
            }

            if (pacijent.getDatumRodjenja() == null) {
               
                throw new Exception("SERVER: Polje datum rodjenja ne sme biti prazno*");
            }
            if (pacijent.getAdresa().isEmpty()) {

              
                throw new Exception("SERVER: Polje adresa ne sme biti prazno*");
            }
            if (pacijent.getGrad().isEmpty()) {

               
                throw new Exception("SERVER: Polje grad ne sme biti prazno*");
            }

            if (pacijent.getTelefon().isEmpty()) {

               
                throw new Exception("SERVER: Polje telefon ne sme biti prazno*");
            }
           

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            String jmbg = pacijent.getJmbg();
            Date datumRodjenja = pacijent.getDatumRodjenja();

            String telefon = pacijent.getTelefon();
            Pattern p = Pattern.compile("[0]([0-9]{2})[/]{1}[0-9]{3,4}-[0-9]{3,4}");//. represents single character.
            Matcher m = p.matcher(telefon);
            boolean b = m.matches();
            Pattern j = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$");
            Matcher k = j.matcher(jmbg);
            boolean l = k.matches();
            boolean testdatum = true;

            if (datumRodjenja.after(new Date())) {
              
                throw new Exception("SERVER: Datum mora biti pre danasnjeg!");
            }
            if ((datumRodjenja.getYear() + 1900) < 1900) {

              
                throw new Exception("SERVER: Godina rodjenja mora biti posle 1900!");
            }

            long cifra;
            if (l == false) {
               
                throw new Exception("SERVER: JMBG mora biti u formatu: ddmmyyyxxxxxx!");
            }

            if (jmbg.length() != 13) {
              
                throw new Exception("SERVER: JMBG mora imati tacno 13 cifara!");
            }

            try {
                cifra = Long.parseLong(jmbg);
            } catch (NumberFormatException ex) {

               
                throw new Exception("SERVER: JMBG mora sadrzati samo cifre!");
            }

            if (b == false) {

             
                throw new Exception("SERVER: Telfon mora biti u formatu 0xx/xxx(x)-xxx(x)!");
            }
            if (testdatum == false) {

                String god = ("" + (datumRodjenja.getYear() + 1900)).substring(1);
                String mesec = "" + (datumRodjenja.getMonth() + 1);
                if (mesec.length() == 1) {
                    mesec = "0" + mesec;
                }
                String dan = "" + datumRodjenja.getDate();
                if (dan.length() == 1) {
                    dan = "0" + dan;
                }
                String s = "" + dan + "" + mesec + "" + god;

                if (jmbg.length() == 13) {
                    if (s.equals(jmbg.substring(0, 7)) == false) {
                     
                        throw new Exception("SERVER: Datum rodjenja mora da se poklapa sa jmbgom!");
                    }
                }

            }
          
        } catch (Exception ex) {

            Logger.getLogger(SOZapamtiPacijenta.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("SERVER: Desio se izuzetak u klasi SOZapamtiPacijenta!");
        }
    }

    @Override
    protected void izvrsiOperaciju() throws Exception {
        db.insert(pacijent);
    }
}
