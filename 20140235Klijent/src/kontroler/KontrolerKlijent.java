/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Doktor;
import domen.Lek;
import domen.OpstiDomenskiObjekat;
import domen.Pacijent;
import domen.Pregled;
import domen.Sluzbenik;
import domen.Smena;
import domen.Specijalizacija;
import domen.Terapija;
import domen.VrstaPregleda;
import gui.FormaDodajDoktora;
import gui.FormaDodajPacijenta;
import gui.FormaLek;
import gui.FormaPretraziDoktora;
import gui.FormaPretraziPacijenta;
import gui.FormaUcitajPregled;
import gui.FormaZakaziPregled;
import gui.GlavnaForma;
import gui.LoginForma;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import komunikacija.KomunikacijaSaServerom;
import komunikacija.TransferObjekatOdgovor;
import komunikacija.Operacije;
import komunikacija.TransferObjekatZahtev;
import modeli.ModelTabeleDoktora;
import modeli.ModelTabeleLek;
import modeli.ModelTabelePacijenata;
import modeli.ModelTabelePregleda;
import modeli.ModelTabeleTerapija;

/**
 *
 * @author Ivana
 */
public class KontrolerKlijent {

    public static void ucitajKomboSpecijalizacija(FormaDodajDoktora aThis, JComboBox<Object> cbSpecijalizacija) {

        try {
            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setOperacija(Operacije.VRATI_SPECIJALIZACIJE);
            KomunikacijaSaServerom.getInstanca().posaljiZahtev(toz);
            TransferObjekatOdgovor too = KomunikacijaSaServerom.getInstanca().primiOdgovor();

            ArrayList<Specijalizacija> lista = (ArrayList<Specijalizacija>) too.getRezultat();

            cbSpecijalizacija.removeAllItems();
            for (Specijalizacija s : lista) {
            }
            for (Specijalizacija specijalizacija : lista) {
                cbSpecijalizacija.addItem(specijalizacija);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ucitajKomboSmena(FormaDodajDoktora aThis, JComboBox<Object> cbSmena) {

        try {
            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setOperacija(Operacije.VRATI_SMENE);
            KomunikacijaSaServerom.getInstanca().posaljiZahtev(toz);
            TransferObjekatOdgovor too = KomunikacijaSaServerom.getInstanca().primiOdgovor();
            ArrayList<Smena> lista = (ArrayList<Smena>) too.getRezultat();
            cbSmena.removeAllItems();

            for (Smena smena : lista) {
                cbSmena.addItem(smena);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void ucitajKomboVrstaPregleda(FormaZakaziPregled aThis, JComboBox<Object> cbVrstaPregleda) {
        try {
            TransferObjekatZahtev toz = new TransferObjekatZahtev();
            toz.setOperacija(Operacije.VRATI_VRSTE_PREGLEDA);
            KomunikacijaSaServerom.getInstanca().posaljiZahtev(toz);
            TransferObjekatOdgovor too = KomunikacijaSaServerom.getInstanca().primiOdgovor();
            ArrayList<VrstaPregleda> lista = (ArrayList<VrstaPregleda>) too.getRezultat();
            cbVrstaPregleda.removeAllItems();

            for (VrstaPregleda vp : lista) {
                cbVrstaPregleda.addItem(vp);
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void nadjiSluzbenika(LoginForma aThis, JTextField txtKorisnickoIme, JTextField txtSifra, JButton btnLogin) {
        try {
            boolean test = false;

            String username = txtKorisnickoIme.getText().trim();
            String password = txtSifra.getText().trim();
          
            if (password.isEmpty()) {
                aThis.getLblValSifraPrazno().setForeground(Color.red);
                aThis.getLblValSifraPrazno().setText("Morate uneti lozinku");
                test = true;
            }
            if (username.isEmpty()) {
                aThis.getLblValKorisnickoImePrazno().setForeground(Color.red);
                aThis.getLblValKorisnickoImePrazno().setText("Morate uneti korisnicko ime");
                test = true;
            }
            if (test == false) {
                Sluzbenik sluzbenik = new Sluzbenik(username, password);
                
                Sluzbenik ulogovaniSluzbenik = (Sluzbenik) posaljiZahtevIPrimiOdgovor(sluzbenik, Operacije.LOGIN);
                if (ulogovaniSluzbenik != null) {
                    if (ulogovaniSluzbenik.getSluzbenikID() == -3) {

                        JOptionPane.showMessageDialog(null, "Sistem ne može da nađe službenika!");
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Uspešna prijava na sistem!");
                    GlavnaForma gf = new GlavnaForma();
                    KomunikacijaSaServerom.getInstanca().setUlogovaniSluzbenik(ulogovaniSluzbenik);
                    gf.setUlogovani(ulogovaniSluzbenik);
                    gf.setVisible(true);
                    aThis.setVisible(false);
                } else if (ulogovaniSluzbenik == null) {

                    aThis.getLblValNijeTacno().setForeground(Color.red);
                    aThis.getLblValNijeTacno().setText("*Korisnicko ime ili lozinka nisu dobri, pokusajte ponovo*");
                    txtSifra.setText("");
                }

            } else {
                return;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zapamtiPacijenta(FormaDodajPacijenta aThis, JTable tblPacijenti, JTextField txtImePrezime, JTextField txtJMBG, JTextField txtDatumRodjenja, JTextField txtAdresa, JTextField txtGrad, JTextField txtTelefon) {
        try {
            boolean test = false;
            if (txtImePrezime.getText().isEmpty()) {
                aThis.getLblValImePrezime().setForeground(Color.red);
                aThis.getLblValImePrezime().setText("*Polje ime i prezime ne sme biti prazno*");
                test = true;
            }

            if (txtJMBG.getText().isEmpty()) {
                aThis.getLblValJmbgPrazno().setForeground(Color.red);
                aThis.getLblValJmbgPrazno().setText("*Polje jmbg ne sme biti prazno*");
                test = true;
            }

            if (txtDatumRodjenja.getText().isEmpty()) {
                aThis.getLblValDatumPrazno().setForeground(Color.red);
                aThis.getLblValDatumPrazno().setText("*Polje datum rodjenja ne sme biti prazno*");
                test = true;
            }
            if (txtAdresa.getText().isEmpty()) {

                aThis.getLblValAdresaPrazno().setForeground(Color.red);
                aThis.getLblValAdresaPrazno().setText("*Polje adrese ne sme biti prazno*");
                test = true;
            }
            if (txtGrad.getText().isEmpty()) {
                aThis.getLblValGradPrazno().setForeground(Color.red);
                aThis.getLblValGradPrazno().setText("*Polje grad ne sme biti prazno*");
                test = true;
            }
            if (txtTelefon.getText().isEmpty()) {

                aThis.getLblValTelefonPrazno().setForeground(Color.red);
                aThis.getLblValTelefonPrazno().setText("*Polje telefon ne sme biti prazno*");
                test = true;
            }
            if (test == true) {
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String imePrezime = txtImePrezime.getText();
            String jmbg = txtJMBG.getText();
            String datum = txtDatumRodjenja.getText();
            Date datumRodjenja = null;
            String adresa = txtAdresa.getText();
            String grad = txtGrad.getText();
            String telefon = txtTelefon.getText();
            Pattern p = Pattern.compile("[0]([0-9]{2})[/]{1}[0-9]{3,4}-[0-9]{3,4}");//. represents single character.
            Matcher m = p.matcher(telefon);
            boolean b = m.matches();
            Pattern j = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$");
            Matcher k = j.matcher(jmbg);
            boolean l = k.matches();
            boolean testdatum = true;
            try {
                datumRodjenja = sdf.parse(datum);
                testdatum = false;

            } catch (ParseException ex) {

                aThis.getLblValDatumFormat().setForeground(Color.red);
                aThis.getLblValDatumFormat().setText("*Datum nije u odgovarajucem formatu*");
                test = true;
            }

            if (test == false && datumRodjenja.after(new Date())) {
                aThis.getLblValDatumPosleDanas().setForeground(Color.red);
                aThis.getLblValDatumPosleDanas().setText("*Datum mora biti pre danasnjeg*");
                test = true;
            }
            if (test == false && ((datumRodjenja.getYear() + 1900) < 1900)) {
                aThis.getLblValDatumPre1900().setForeground(Color.red);
                aThis.getLblValDatumPre1900().setText("*Godina rodjenja mora biti posle 1900**");
                test = true;
            }

            long cifra;
            if (l == false) {
                aThis.getLblValJmbgPrazno().setForeground(Color.red);
                aThis.getLblValJmbgPrazno().setText("*JMBG mora biti u formatu: ddmmyyyxxxxxx*");
                test = true;
            }

            if (jmbg.length() != 13) {
                aThis.getLblJmbgValBrCifara().setForeground(Color.red);
                aThis.getLblJmbgValBrCifara().setText("*JMBG mora imati tacno 13 cifara*");

                test = true;
            }

            try {
                cifra = Long.parseLong(jmbg);
            } catch (NumberFormatException ex) {

                aThis.getLblJmbgValSamoCifre().setForeground(Color.red);
                aThis.getLblJmbgValSamoCifre().setText("*JMBG mora sadrzati samo cifre*");
                test = true;
            }

            if (b == false) {
                aThis.getLblValTelefonPrazno().setForeground(Color.red);
                aThis.getLblValTelefonPrazno().setText("*Telfon mora biti u formatu 0xx/xxx(x)-xxx(x)*");
                test = true;
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
                        aThis.getLblValDatumPrazno().setForeground(Color.red);
                        aThis.getLblValDatumPrazno().setText("*Datum rodjenja mora da se poklapa sa jmbgom*");
                        test = true;
                    }
                }

            }
            if (test == false) {
                Pacijent pacijent = new Pacijent(-1, imePrezime, jmbg, datumRodjenja, adresa, grad, telefon);

                boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(pacijent, Operacije.SACUVAJ_PACIJENTA);

                if (uspesno) {
                    JOptionPane.showMessageDialog(aThis, "Sistem je zapamtio pacijenta");

                    srediTabeluPacijenta(aThis.getFpp());
                    aThis.dispose();
                    return;
                } else {
                    JOptionPane.showMessageDialog(aThis, "Sistem ne moze da zapamti pacijenta");
                    return;
                }
            } else {

                return;
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void zapamtiDoktora(JTable tblDoktori, FormaDodajDoktora aThis, JTextField txtImePrezimeDoktora, Object selectedItem, Object selectedItem0) {
        try {
            boolean test = false;
            if (txtImePrezimeDoktora.getText().isEmpty()) {
                //JOptionPane.showMessageDialog(aThis, "Niste popunili ime doktora");
                aThis.getLblValImePrezime().setForeground(Color.red);
                aThis.getLblValImePrezime().setText("*Ime i prezime doktora ne sme biti prazno*");
                test = true;
            }

            String imePrezime = txtImePrezimeDoktora.getText();
            Specijalizacija specijalizacija = (Specijalizacija) selectedItem;
            Smena smena = (Smena) selectedItem0;
            Doktor doktor = new Doktor(-1, imePrezime, specijalizacija, smena);
            if (test == false) {
                boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(doktor, Operacije.SACUVAJ_DOKTORA);

                if (uspesno) {
                    JOptionPane.showMessageDialog(aThis, "Sistem je zapamtio doktora");
                    srediTabeluDoktora2(aThis.getFpd(), tblDoktori);
                    aThis.dispose();
                } else {
                    JOptionPane.showMessageDialog(aThis, "Sistem ne moze da zapamti doktora");
                }
            } else {
                return;
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void srediTabeluPacijenata(FormaPretraziPacijenta aThis, JTable tblPacijenti) {
        try {

            ArrayList<Pacijent> lista = (ArrayList<Pacijent>) posaljiZahtevIPrimiOdgovor(null, Operacije.VRATI_PACIJENTE);
            if (lista == null) {
                JOptionPane.showMessageDialog(null, "Sistem ne može da vrati pacijente!");

            } else {
                ModelTabelePacijenata mtp = new ModelTabelePacijenata(lista);
                tblPacijenti.setModel(mtp);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(aThis, "Sistem nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void pripremiTabeluPacijenataZaSort(FormaPretraziPacijenta aThis, JTable tblPacijenti, JTextField txtPretraziPacijenta) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblPacijenti.getModel());
        tblPacijenti.setRowSorter(rowSorter);

        txtPretraziPacijenta.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                String filter = txtPretraziPacijenta.getText();

                if (filter.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filter, 0));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtPretraziPacijenta.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void srediFormuPrikaziPacijenta(Pacijent pacijent, JTextField txtImePrezime, JTextField txtJMBG, JTextField txtDatumRodjenja, JTextField txtAdresa, JTextField txtGrad, JTextField txtTelefon, JButton btnSacuvaj, JButton btnSacuvajIzmene, JButton btnOtkazi) {
        btnSacuvaj.setVisible(false);
        btnSacuvajIzmene.setVisible(true);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtImePrezime.setText(pacijent.getImePrezime());
        txtImePrezime.setEditable(true);
        txtJMBG.setText(pacijent.getJmbg());
        txtJMBG.setEditable(true);

        txtDatumRodjenja.setText(sdf.format(pacijent.getDatumRodjenja()));
        txtDatumRodjenja.setEditable(true);
        txtAdresa.setText(pacijent.getAdresa());
        txtAdresa.setEditable(true);
        txtGrad.setText(pacijent.getGrad());
        txtGrad.setEditable(true);
        txtTelefon.setText(pacijent.getTelefon());
        txtTelefon.setEditable(true);

    }

    public void obrisiPacijenta(FormaPretraziPacijenta aThis, JTable tblIstorijaPregleda, int red, JTable tblPacijenti) {
        try {
            ModelTabelePacijenata mtp = (ModelTabelePacijenata) tblPacijenti.getModel();
            ModelTabelePregleda mtpr = (ModelTabelePregleda) tblIstorijaPregleda.getModel();
            Pacijent p = mtp.getPacijent(tblPacijenti.convertRowIndexToModel(red));
            ArrayList<Pregled> pregledi = vratiPreglede(p);

            if (!pregledi.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Sistem ne može da obriše pacijenta koji ima preglede");
                return;
            }
            boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(p, Operacije.OBRISI_PACIJENTA);
            if (uspesno == true) {
                mtp.obrisi(red);
                mtpr.setListaPregleda(new ArrayList<Pregled>());
                mtpr.fireTableDataChanged();
                aThis.resetPretraga();
                srediTabeluPacijenta(aThis);

                JOptionPane.showMessageDialog(aThis, "Sistem je obrisao pacijenta");
            } else {
                JOptionPane.showMessageDialog(aThis, "Sistem ne može da obriše pacijenta");
                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sacuvajIzmenePacijenta(JTable tblPacijenti, FormaDodajPacijenta aThis, Pacijent pacijent, JTextField txtImePrezime, JTextField txtJMBG, JTextField txtDatumRodjenja, JTextField txtAdresa, JTextField txtGrad, JTextField txtTelefon) {

        try {
            boolean test = false;
            if (txtImePrezime.getText().isEmpty()) {
                aThis.getLblValImePrezime().setForeground(Color.red);
                aThis.getLblValImePrezime().setText("*Polje ime i prezime ne sme biti prazno*");
                test = true;
            }

            if (txtJMBG.getText().isEmpty()) {
                aThis.getLblValJmbgPrazno().setForeground(Color.red);
                aThis.getLblValJmbgPrazno().setText("*Polje jmbg ne sme biti prazno*");
                test = true;
            }

            if (txtDatumRodjenja.getText().isEmpty()) {
                aThis.getLblValDatumPrazno().setForeground(Color.red);
                aThis.getLblValDatumPrazno().setText("*Polje datum rodjenja ne sme biti prazno*");
                test = true;
            }
            if (txtAdresa.getText().isEmpty()) {

                aThis.getLblValAdresaPrazno().setForeground(Color.red);
                aThis.getLblValAdresaPrazno().setText("*Polje adrese ne sme biti prazno*");
                test = true;
            }
            if (txtGrad.getText().isEmpty()) {
                aThis.getLblValGradPrazno().setForeground(Color.red);
                aThis.getLblValGradPrazno().setText("*Polje grad ne sme biti prazno*");
                test = true;
            }
            if (txtTelefon.getText().isEmpty()) {

                aThis.getLblValTelefonPrazno().setForeground(Color.red);
                aThis.getLblValTelefonPrazno().setText("*Polje telefon ne sme biti prazno*");
                test = true;
            }
            if (test == true) {
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String imePrezime = txtImePrezime.getText();
            String jmbg = txtJMBG.getText();
            String datum = txtDatumRodjenja.getText();
            Date datumRodjenja = null;
            String adresa = txtAdresa.getText();
            String grad = txtGrad.getText();
            String telefon = txtTelefon.getText();
            Pattern p = Pattern.compile("[0]([0-9]{2})[/]{1}[0-9]{3,4}-[0-9]{3,4}");//. represents single character.
            Matcher m = p.matcher(telefon);
            boolean b = m.matches();
            Pattern j = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])[0-9]{9}$");
            Matcher k = j.matcher(jmbg);
            boolean l = k.matches();
            boolean testdatum = true;

            try {
                datumRodjenja = sdf.parse(datum);
                testdatum = false;

            } catch (ParseException ex) {

                aThis.getLblValDatumFormat().setForeground(Color.red);
                aThis.getLblValDatumFormat().setText("*Datum nije u odgovarajucem formatu*");
                test = true;
            }

            if (test == false && datumRodjenja.after(new Date())) {
                aThis.getLblValDatumPosleDanas().setForeground(Color.red);
                aThis.getLblValDatumPosleDanas().setText("*Datum mora biti pre danasnjeg*");
                test = true;
            }
            if (test == false && ((datumRodjenja.getYear() + 1900) < 1900)) {
                aThis.getLblValDatumPre1900().setForeground(Color.red);
                aThis.getLblValDatumPre1900().setText("*Godina rodjenja mora biti posle 1900**");
                test = true;
            }

            long cifra;
            if (l == false) {
                aThis.getLblValJmbgPrazno().setForeground(Color.red);
                aThis.getLblValJmbgPrazno().setText("*JMBG mora biti u formatu: ddmmyyyxxxxxx*");
                test = true;
            }
            if (jmbg.length() != 13) {
                aThis.getLblJmbgValBrCifara().setForeground(Color.red);
                aThis.getLblJmbgValBrCifara().setText("*JMBG mora imati tacno 13 cifara*");

                test = true;
            }

            try {
                cifra = Long.parseLong(jmbg);
            } catch (NumberFormatException ex) {

                aThis.getLblJmbgValSamoCifre().setForeground(Color.red);
                aThis.getLblJmbgValSamoCifre().setText("*JMBG mora sadrzati samo cifre*");
                test = true;
            }
            if (b == false) {
                aThis.getLblValTelefonPrazno().setForeground(Color.red);
                aThis.getLblValTelefonPrazno().setText("*Telfon mora biti u formatu 0xx/xxx(x)-xxx(x)*");
                test = true;
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
                        aThis.getLblValDatumPrazno().setForeground(Color.red);
                        aThis.getLblValDatumPrazno().setText("*Datum rodjenja mora da se poklapa sa jmbgom*");
                        test = true;
                    }
                }

            }

            if (test == false) {

                pacijent.setImePrezime(imePrezime);
                pacijent.setJmbg(jmbg);
                pacijent.setDatumRodjenja(datumRodjenja);
                pacijent.setAdresa(adresa);
                pacijent.setGrad(grad);
                pacijent.setTelefon(telefon);

                boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(pacijent, Operacije.IZMENI_PACIJENTA);
                if (uspesno) {
                    JOptionPane.showMessageDialog(aThis, "Sistem je izmenio pacijenta");

                    srediTabeluPacijenta(aThis.getFpp());
                    aThis.dispose();
                    return;
                } else {
                    JOptionPane.showMessageDialog(aThis, "Sistem ne moze da izmeni pacijenta");
                    return;
                }
            } else {

                return;
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private Object posaljiZahtevIPrimiOdgovor(OpstiDomenskiObjekat objekat, Object parametar2, int operacija) throws Exception {
        TransferObjekatZahtev toz = new TransferObjekatZahtev();
        toz.setOperacija(operacija);
        toz.setParametar(objekat);
        toz.setParametar2(parametar2);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(toz);
        TransferObjekatOdgovor too = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        return too.getRezultat();

    }

    public Object posaljiZahtevIPrimiOdgovor(OpstiDomenskiObjekat objekat, int operacija) throws Exception {
        TransferObjekatZahtev toz = new TransferObjekatZahtev();
        toz.setOperacija(operacija);
        toz.setParametar(objekat);
       
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(toz);
        TransferObjekatOdgovor too = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        return too.getRezultat();

    }

    public void srediTabeluDoktora(FormaPretraziDoktora aThis, JTable tblDoktori) {
        try {

            ArrayList<Doktor> lista = (ArrayList<Doktor>) posaljiZahtevIPrimiOdgovor(null, Operacije.VRATI_DOKTORE);

            ModelTabeleDoktora mtp = new ModelTabeleDoktora(lista);
            tblDoktori.setModel(mtp);
            tblDoktori.revalidate();
            tblDoktori.repaint();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(aThis, "Sistem nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void srediTabeluDoktora2(FormaPretraziDoktora aThis, JTable tblDoktori) {
        try {
            ArrayList<Doktor> lista = (ArrayList<Doktor>) posaljiZahtevIPrimiOdgovor(null, Operacije.VRATI_DOKTORE);
            ModelTabeleDoktora mtp = (ModelTabeleDoktora) tblDoktori.getModel();
            mtp.setListaDoktora(lista);
            mtp.fireTableDataChanged();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(aThis, "Sistem nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void pripremiTabeluDoktoraZaSort(FormaPretraziDoktora aThis, JTable tblDoktori, JTextField txtPretraziDoktora) {
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tblDoktori.getModel());
        tblDoktori.setRowSorter(rowSorter);

        txtPretraziDoktora.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                String filter = txtPretraziDoktora.getText();

                if (filter.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + filter, 0));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = txtPretraziDoktora.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, 0));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void obrisiDoktora(FormaPretraziDoktora aThis, int red, JTable tblDoktori) {
        try {
            ModelTabeleDoktora mtd = (ModelTabeleDoktora) tblDoktori.getModel();
            Doktor d = mtd.getDoktor(tblDoktori.convertRowIndexToModel(red));

            ArrayList<Pregled> pregledi = vratiPreglede(d);

            if (!pregledi.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ne možete obrisati doktora koji ima preglede!");
                return;
            }
            boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(d, Operacije.OBRISI_DOKTORA);
            if (uspesno) {
                aThis.resetSearch();
                srediTabeluDoktora2(aThis, tblDoktori);
                JOptionPane.showMessageDialog(aThis, "Sistem je obrisao doktora");
            } else {
                JOptionPane.showMessageDialog(aThis, "Sistem ne može da obriše doktora");
            }
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private ArrayList<Pregled> vratiPreglede(Doktor d) {
        ArrayList<Pregled> lista = null;
        try {

            lista = (ArrayList<Pregled>) posaljiZahtevIPrimiOdgovor(d, Operacije.VRATI_LISTU_PREGLEDA_D);
        } catch (Exception ex) {
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void srediFormuPrikaziDoktora(Doktor doktor, JTextField txtImePrezimeDoktora, JComboBox<Object> cbSpecijalizacija, JComboBox<Object> cbSmena, JButton btnSacuvajIzmene, JButton btnSacuvaj, JButton btnOtkazi) {
        btnSacuvaj.setVisible(false);
        btnSacuvajIzmene.setVisible(true);
        txtImePrezimeDoktora.setText(doktor.getImePrezime());
        txtImePrezimeDoktora.setEditable(true);

        cbSpecijalizacija.setSelectedItem(doktor.getSpecijalizacija());
        cbSpecijalizacija.setEnabled(true);
        cbSmena.setSelectedItem(doktor.getSmena());
        cbSmena.setEnabled(true);

    }

    public void sacuvajIzmeneDoktora(JTable tblDoktori, FormaDodajDoktora aThis, Doktor doktor, JTextField txtImePrezimeDoktora, Object selectedItem, Object selectedItem0) {
        try {
            String imePrezime = txtImePrezimeDoktora.getText();
            Specijalizacija specijalizacija = (Specijalizacija) selectedItem;
            Smena smena = (Smena) selectedItem0;
            boolean test = false;
            if (imePrezime.isEmpty()) {
                aThis.getLblValImePrezime().setForeground(Color.red);
                aThis.getLblValImePrezime().setText("Morate uneti ime i prezime doktora");

                test = true;
            }

            doktor.setImePrezime(imePrezime);
            doktor.setSpecijalizacija(specijalizacija);
            doktor.setSmena(smena);
            if (test == false) {
                boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(doktor, Operacije.IZMENI_DOKTORA);
                if (uspesno) {
                    JOptionPane.showMessageDialog(aThis, "Sistem je izmenio doktora");
                    srediTabeluDoktora2(aThis.getFpd(), tblDoktori);
                    aThis.dispose();
                    return;
                } else {
                    JOptionPane.showMessageDialog(aThis, "Sistem ne može da izmeni doktora!");
                    return;
                }
            } else {
                return;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    private void srediTabeluPacijenta(FormaPretraziPacijenta aThis) {
        try {

            ArrayList<Pacijent> lista = (ArrayList<Pacijent>) posaljiZahtevIPrimiOdgovor(null, Operacije.VRATI_PACIJENTE);

            ModelTabelePacijenata mtp = (ModelTabelePacijenata) aThis.getTblPacijenti().getModel();
            mtp.setListaPacijenata(lista);
            mtp.fireTableDataChanged();


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(aThis, "Sistem nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void srediTabeluPregleda(JTable tblPacijenti, JTable tblIstorijaPregleda) {
        try {

            if (tblPacijenti.getSelectedRow() != -1) {
                Pacijent pacijent = ((ModelTabelePacijenata) (tblPacijenti.getModel())).getPacijent(tblPacijenti.convertRowIndexToModel(tblPacijenti.getSelectedRow()));

                ArrayList<Pregled> lista = (ArrayList<Pregled>) posaljiZahtevIPrimiOdgovor(pacijent, Operacije.VRATI_LISTU_PREGLEDA);

                if (lista == null) {
                    JOptionPane.showMessageDialog(null, "Sistem ne može da vrati podatke o izabranom pacijentu!");
                    return;
                }

                ModelTabelePregleda mtpr = new ModelTabelePregleda(lista);
                tblIstorijaPregleda.setModel(mtpr);
                tblIstorijaPregleda.revalidate();
                tblIstorijaPregleda.repaint();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void srediTabeluSlobodnihDoktora(VrstaPregleda vp, Date datum, Date vreme, JTable tblSlobodniDoktori) {
        try {
            Date datumIVreme = new Date(datum.getYear(), datum.getMonth(), datum.getDate(), vreme.getHours(), vreme.getMinutes());

            ArrayList<Doktor> lista = (ArrayList<Doktor>) posaljiZahtevIPrimiOdgovor(vp, datumIVreme, Operacije.VRATI_SLOBODNE_DOKTORE);

            ModelTabeleDoktora mtp = new ModelTabeleDoktora(lista);
            tblSlobodniDoktori.setModel(mtp);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void zapamtiPregled(FormaPretraziPacijenta fpp, FormaZakaziPregled fzp, Pacijent pacijent, JTextField txtDatum, JTextField txtVreme, VrstaPregleda vp, boolean realizovan, JTable tblSlobodniDoktori, Sluzbenik sluzbenik) {
        try {
            boolean test = false;

            String vreme = txtVreme.getText();
            SimpleDateFormat sdfv = new SimpleDateFormat("HH:mm");

            Date vreme1 = null;
            try {
                vreme1 = sdfv.parse(vreme);

            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ne moze da se parsira vreme");
                return;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datum = null;
            try {
                datum = sdf.parse(txtDatum.getText());
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ne moze da se parsira datum");
                return;

            }

            realizovan = false;

            double cena = vp.getCena();
            Doktor doktor = null;
            if (tblSlobodniDoktori.getSelectedRow() == -1) {

                fzp.getLblValDoktori().setForeground(Color.red);
                fzp.getLblValDoktori().setText("*Morate odabrati doktora*");
                test = true;
            } else {
                ModelTabeleDoktora mts = (ModelTabeleDoktora) tblSlobodniDoktori.getModel();

                doktor = mts.getDoktor(tblSlobodniDoktori.getSelectedRow());
            }

            if (test == false) {

                Pregled pregled = new Pregled(-1, datum, vreme, vp, realizovan, cena, doktor, pacijent, "", sluzbenik);

                boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(pregled, Operacije.SACUVAJ_PREGLED);

                if (uspesno) {
                    JOptionPane.showMessageDialog(null, "Sistem je zapamtio pregled");
                    ModelTabelePregleda mtp = (ModelTabelePregleda) fpp.getTblIstorijaPregleda().getModel();
                    mtp.getListaPregleda().add(pregled);
                    mtp.fireTableDataChanged();

                    srediTabeluPregleda(fpp.getTblPacijenti(), fpp.getTblIstorijaPregleda());
                    fzp.dispose();
                    fpp.setVisible(true);
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Sistem ne moze da zapamti pregled");
                    return;
                }
            } else {

                return;
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private ArrayList<Pregled> vratiPreglede(Pacijent p) {
        ArrayList<Pregled> lista = null;
        try {

            lista = (ArrayList<Pregled>) posaljiZahtevIPrimiOdgovor(p, Operacije.VRATI_LISTU_PREGLEDA);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Server nije pokrenut!");

            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public Pacijent ucitajPacijenta(Pacijent p) {
        Pacijent pacijent = null;
        try {

            pacijent = (Pacijent) posaljiZahtevIPrimiOdgovor(p, Operacije.VRATI_PACIJENTA);
            if (pacijent == null) {
                JOptionPane.showMessageDialog(null, "Sistem ne može da nađe podatke o izabranom pacijentu");
                return null;
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Server nije pokrenut!");

            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacijent;
    }

    public Doktor ucitajDoktora(Doktor d) {
        Doktor doktor = null;
        try {

            doktor = (Doktor) posaljiZahtevIPrimiOdgovor(d, Operacije.VRATI_DOKTORA);
            if (doktor == null) {
                JOptionPane.showMessageDialog(null, "Sistem ne može da nađe podatke o izabranom doktoru");
                return null;
            }
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Server nije pokrenut!");

            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doktor;
    }

    public Pregled ucitajPregled(Pregled p) {

        Pregled pregled = null;
        try {

            pregled = (Pregled) posaljiZahtevIPrimiOdgovor(p, Operacije.VRATI_PREGLED);
            if (pregled == null){
            JOptionPane.showMessageDialog(null, "Sistem ne može da nađe podatke o izabranom pregledu");
            return null;
            }
            
        } catch (Exception ex) {
            
      JOptionPane.showMessageDialog(null, "Server nije pokrenut!");

            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pregled;

    }

    public void srediTabeluDodajTerapije(FormaLek aThis, JTable tblLekovi, ArrayList<Terapija> listaTerapija) throws Exception {
        try {

            ArrayList<Lek> listaLekova = (ArrayList<Lek>) posaljiZahtevIPrimiOdgovor(null, Operacije.VRATI_LEKOVE);
            ArrayList<Lek> listaPomocna = new ArrayList<>();
            for (Lek lek : listaLekova) {
                boolean dodat = false;
                for (Terapija terapija : listaTerapija) {
                    if (terapija.getLek().getLekID() == lek.getLekID()) {
                        dodat = true;

                    }
                }
                if (dodat == false) {
                    listaPomocna.add(lek);
                }

            }

            ModelTabeleLek mtl = new ModelTabeleLek(listaPomocna);
            tblLekovi.setModel(mtl);
            if (listaPomocna.isEmpty()) {
                JOptionPane.showMessageDialog(aThis, "Uneti su svi mogući lekovi");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(aThis, "Server nije pokrenut");
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean sacuvajIzmenePregleda(JTable tblTerapija, Pregled pregled, JTextArea txtAreaOpis, JCheckBox chbDa, JCheckBox chbNe) {
        pregled.setOpis(txtAreaOpis.getText());
        boolean obavljen = false;
        if (chbDa.isSelected() && !chbNe.isSelected()) {
            obavljen = true;
        } else if (chbNe.isSelected() && !chbDa.isSelected()) {
            obavljen = false;
        }
        pregled.setRealizovan(obavljen);
        ModelTabeleTerapija mtt = (ModelTabeleTerapija) tblTerapija.getModel();
        pregled.setListaTerapija(mtt.getListaTerapija());

        try {

            boolean uspesno = (boolean) posaljiZahtevIPrimiOdgovor(pregled, Operacije.IZMENI_PREGLED);

            return uspesno;
        } catch (Exception e) {
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

    }

    public void srediTabeluTerapija(FormaUcitajPregled aThis, JTable tblTerapija) {
        ArrayList<Terapija> terapije = (ArrayList<Terapija>) aThis.getPregled().getListaTerapija();

        ModelTabeleTerapija mtt = new ModelTabeleTerapija(terapije);
        tblTerapija.setModel(mtt);
        mtt.setListaTerapija(terapije);
        tblTerapija.revalidate();
        tblTerapija.repaint();

    }

}
