/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javaio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author tss
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Path path = Paths.get ("/home/tss/echo.txt");
        System.out.println(path.getFileName());
    }
    
}
