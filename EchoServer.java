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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author tss
 */
public class EchoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("--------Echo server started------- ");
        
        while (true) {

            try (Socket clientSocket = serverSocket.accept();) {

                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream());
                String line;
                line = br.readLine();
                System.out.println("ricevuta la frase" + line);
                pw.println("ECHO----" + line);
                pw.flush();

            }
        }

    }
}
