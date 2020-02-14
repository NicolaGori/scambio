/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scambiodati;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

//

/**
 *
 * @author gorin
 */
public class ServerScambio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int porta = 25000;
        String messaggio;
        ServerSocket sSocket = null;
        
        try{
            //ServerSocket sSocket =  new ServerSocket(porta);
            sSocket =  new ServerSocket(porta);
            System.out.println("Server in attesa...");

            Socket connessione;
            connessione=sSocket.accept();
            System.out.println("Server e Client sono connessi...");
            System.out.println("");

            //---------------------------------------------------------------------------//
            BufferedReader in = new BufferedReader(new InputStreamReader(connessione.getInputStream()));
            PrintWriter out = new PrintWriter(connessione.getOutputStream(), true);

            messaggio = in.readLine();
            System.out.println("Messaggio del Client: "+ messaggio);

            out.println("Server");
        } catch (IOException ex){
            System.err.println("Errore");
        } finally {
            try {
                sSocket.close();
            } catch (IOException ex) {
                System.err.println("Errore in chiusura");
            }
        }
    }
    
}
