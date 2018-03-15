/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION4.EJERCICIO3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andres
 */
public class ImageReader {
    private String pathFile;
    private  File image;
        public ImageReader(String pathFile){
            this.pathFile=pathFile;
            image=new File(pathFile);
        }
        
        public byte[] loadImage(){
            int numOfBytes = (int) image.length();
            try { 
                FileInputStream inFile = new FileInputStream(pathFile);
                byte[] imageInBytes = new byte[numOfBytes];
                inFile.read(imageInBytes);
                return imageInBytes;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ImageReader.class.getName()).log(Level.SEVERE, null, ex);
            } catch(IOException ex){
                
            }  
            
            
            return null;
            
        }
        
        public int getImgLength(){
            return  (int) image.length();
        }
}
