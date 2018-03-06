/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION4.EJERCICIO3;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author 2115237
 */
public class PageReader {
    private File page=null;
    private String filePath;
    
    public  PageReader(String filePath){
        System.out.printf("%s",filePath);
        page=new File(filePath);
        this.filePath=filePath;
    }
    
    public String loadPage(){
        String result="";
        try{
            FileReader fReader= new FileReader(page);
            BufferedReader bReader = new BufferedReader(fReader);
            String line;
            while((line = bReader.readLine())!= null)
                result+=line;
            bReader.close();
        }catch(FileNotFoundException ex){
            System.err.println("El recurso solicitado"+filePath +"no existe"+page.getPath()+page);
            ex.printStackTrace();
            
        }catch(IOException ex){
            System.err.println("Error en la lectura del Buffer");
            ex.printStackTrace();
        }
        
        return result;
    }
}
