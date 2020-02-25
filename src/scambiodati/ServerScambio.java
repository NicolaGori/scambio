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
        int porta = 25000; //Porta TCP e UDP per far avvenire una chat room - per ulteriori dettagli guardare la dispensa
        String messaggio;
        ServerSocket sSocket = null;
        
        try{
            //ServerSocket sSocket =  new ServerSocket(porta);
            sSocket =  new ServerSocket(porta); //Istanzio il Server Socket passandogli la Porta
            System.out.println("Server in attesa...");

            Socket connessione; //creo il Socket per la connessione
            connessione=sSocket.accept();   //Attesa fino ad effettiva connessione 
            System.out.println("Server e Client sono connessi..."); //confermo che la connessione è avvenuta
            System.out.println("");

            //---------------------------------------------------------------------------//
            BufferedReader in = new BufferedReader(new InputStreamReader(connessione.getInputStream()));    //Stream or. Caratteri per ricevere il messaggio del client
            PrintWriter out = new PrintWriter(connessione.getOutputStream(), true); //Stream di Output, per inviare il messaggio del server

            messaggio = in.readLine();  //acquisisco il messaggio del client
            System.out.println("Messaggio del Client: "+ messaggio);    //stampo il messaggio del client

            out.println("Server");  //messaggio del server da inviare
            
        } catch (IOException ex){
            System.err.println("Errore");   //gestisce gli errori
        } finally {
            try {
                sSocket.close();    //chiusura del socket
            } catch (IOException ex) {
                System.err.println("Errore in chiusura");   //gestione dell'errore di chiusura
            }
        }
    }
    
}
