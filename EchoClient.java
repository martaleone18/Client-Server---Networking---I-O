/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.networking.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class EchoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         Socket socket = new Socket("localhost", 10000);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        
        Scanner input = new Scanner(System.in);
        System.out.println("Scrivi la frase da inviare al server");
        String line = input.nextLine();
        
        pw.println(line);
        pw.flush();
        
        
        String echo = br.readLine();
        System.out.println(echo);
    }
    
}
