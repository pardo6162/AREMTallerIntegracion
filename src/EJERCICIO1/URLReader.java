/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJERCICIO1;
import java.net.*;

/**
 *
 * @author 2115237
 */
public class URLReader {
    public static void main(String[] args){
        try{
            URL moodle= new URL("http://campusvirtual.escuelaing.edu.co:80/moodle/course/view.php?id=892#id2018"); 
            System.out.printf("getProtocol %s%ngetAuthority %s%ngetHost %s%ngetPort %s%ngetPath %s%ngetQuery %s%ngetFile %s%ngetRef %s%n", moodle.getProtocol(),moodle.getAuthority(),moodle.getHost(),moodle.getPort(),moodle.getPath(),moodle.getQuery(),moodle.getFile(),moodle.getRef());
        }catch(MalformedURLException ex){
            ex.printStackTrace();
        }
        
    }
}
