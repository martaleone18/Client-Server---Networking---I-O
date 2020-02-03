/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class AppNetworking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            URL url = new URL("https://www.google.it");
            URLConnection cn = url.openConnection();
            BufferedReader br = new BufferedReader (new InputStreamReader(cn.getInputStream()));
            br.lines().forEach(System.out::println);
           
            br.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    
}
