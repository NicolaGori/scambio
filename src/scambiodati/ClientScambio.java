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
 * @version 25/02/2020 NG
 */
public class ClientScambio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int porta = 25000;  //porta di comunicazione
        String messaggio;
        Socket socket = null;
        
        try{
            //Socket socket =  new Socket("localhost",porta);
            socket =  new Socket("localhost",porta);    //creo il socket per la connessione, passandogli l'IP e la porta da abbinare
            
            //──────────────────────────────────────────────//
            /*
            1- Creo lo strem per ricevere in input i messaggi
            2- Creo lo stream per inviare un messaggio dal client
            3- Creo il messaggio da inviare al server
            4- Accetto il messaggio inviato dal server
            5- Stampo il messaggio del server
            */
            //──────────────────────────────────────────────//
            
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Client");
            messaggio = in.readLine();
            System.out.println("Messaggio del server: " + messaggio);
            
        } catch (IOException ex){
            System.err.println("Errore");   //gestisco gli errori
        } finally {
            try {
                socket.close(); //chiudo il socket
            } catch (IOException ex) {
                System.err.println("Errore in chiusura");   //gestisco errori in chiusura
            }
        }
    }
    
}
