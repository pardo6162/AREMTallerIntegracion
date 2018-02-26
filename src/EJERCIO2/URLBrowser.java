/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJERCIO2;
import java.io.BufferedReader;
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
    public static void main(String[] args){        
        try(BufferedReader reader
              = new BufferedReader(new InputStreamReader(System.in))){
            url=reader.readLine();
            if(url==null) url="";
        }catch(IOException x){
            x.printStackTrace();
        }
       /** try {
            page = new URL(url);
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        try (BufferedReader reader
              = new BufferedReader(new InputStreamReader(url.openStream()))) {
        String inputLine = null;
        while ((inputLine = reader.readLine()) != null) {
     System.out.println(inputLine);
        }
     } catch (IOException x) {
         x.printStackTrace();
     }**/
    }
}
