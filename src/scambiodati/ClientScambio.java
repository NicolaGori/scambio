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
 * @version 14/02/2020
 */
public class ClientScambio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int porta = 25000;
        String messaggio;
        Socket socket = null;
        
        try{
            //Socket socket =  new Socket("localhost",porta);
            socket =  new Socket("localhost",porta);
            
            //---------------------------------------------------------------------------//
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Client");
            messaggio = in.readLine();
            System.out.println("Messaggio del server: " + messaggio);
            
        } catch (IOException ex){
            System.err.println("Errore");
        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println("Errore in chiusura");
            }
        }
    }
    
}
