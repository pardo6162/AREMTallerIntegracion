/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION3.EJERCICIO2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author 2115237
 */
public class URLBrowser {
    private static String url="";
    private static URL page=null;
    private static FileWriter writer;
    public static void main(String[] args){        
        try(BufferedReader reader
              = new BufferedReader(new InputStreamReader(System.in))){
            url=reader.readLine();
            if(url==null) url="";
        }catch(IOException x){
            x.printStackTrace();
        }
        try {
            page = new URL(url);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        try{
            writer = new FileWriter("./src/EJERCICIO2/index.html");
        }catch(IOException ex){
            ex.getStackTrace();
        }
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(page.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                writer.write(inputLine);
            }
             writer.close();
        } catch (IOException x) {
         x.printStackTrace();
     }
       
    }
}
