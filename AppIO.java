/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javaio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class AppIO {

    /**
     * @param args the command line arguments
     */
    //Leggo come Stream di byte
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        FileInputStream in = new FileInputStream("/home/tss/test.txt");
        int data;
        while ((data = in.read()) != -1) {
            System.out.println(data);
        }
        in.close();

        System.out.println("lettura stream caratteri");

        //leggo come Stream di caratteri
        FileReader rd = new FileReader("/home/tss/test.txt");
        while ((data = rd.read()) != -1) {
            System.out.println(data);
        }
        rd.close();

        System.out.println("lettura stream di caratteri a righe");
        BufferedReader br = new BufferedReader(new FileReader("/home/tss/test.txt"));

        String riga = null;
        while ((riga = br.readLine()) != null) {
            System.out.println(riga);
        }
        br.close();

        br = new BufferedReader(new FileReader("/home/tss/test.txt"));

        System.out.println("cerca la parola file");
        br.lines().filter(v -> v.contains("file")).forEach(System.out::println);

        br.close();
        
        Scanner scanner = new Scanner (System.in);
        PrintWriter pw = new PrintWriter ( new FileOutputStream("/home/tss/echo.txt"));
        String line = "";
        while (!(line=scanner.nextLine()).equals("fine")){
            pw.println(line);
        }
       pw.close();
        duplicateFile1("/home/tss/test.txt", "/home/tss/test(copia).txt");
    }

    private static void duplicateFile2(String src, String dest) {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream(src);
            out = new FileOutputStream(dest);
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException ex) {
                System.out.println("Errore nella chiusura del file");
            }

        }
    }

    private static void duplicateFile1(String src, String dest) {
        try {
            FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dest);
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
            out.close();
            in.close();;
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    private static void duplicateFile3(String src, String dest) {

        try (FileInputStream in = new FileInputStream(src);
                FileOutputStream out = new FileOutputStream(dest)) {

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
