/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import dbb.UcitavanjePodesavanja;
import gui.ServerskaForma;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import kontroler.Kontroler;

/**
 *
 * @author Ivana
 */
public class PokreniServer extends Thread{

    ServerskaForma sf;

    public PokreniServer(ServerskaForma sf) {
        this.sf = sf;
    }

    @Override
    public void run() {
        try {
            int port =Integer.parseInt(UcitavanjePodesavanja.getInstanca().getProperty("port"));
            ServerSocket ss = new ServerSocket(port);
            sf.serverPokrenut();
            
            NitZatvaranje nz = new NitZatvaranje(ss, this);
            nz.start();
            
            while (!isInterrupted()) { 
                
                Socket s = ss.accept();
                Kontroler.getInstance().getListaSluzbenika().add(s);
                ObradaZahteva oz = new ObradaZahteva(s);
                oz.start();
            }
            
        } catch (IOException ex) {
            //ex.printStackTrace();
            System.out.println("Zaustavljen server");
            sf.serverNijePokrenut();
        }
    }

}
