/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION4.EJERCICIO3;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author 2115237
 */
public class HTTPServer {
    public static void main(String[] args) throws IOException {
        while(true){
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(35000);
            } catch (IOException e) {
                System.err.println("Could not listen on port: 35000.");
                System.exit(1);
            }
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }   
            BufferedWriter out =new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
            String inputLine="";
            String outputLine;
            String page="";
            String components[]= null;
            int count=0;
            try{
                while ((inputLine = in.readLine()) != null) {
                    if(count==0){
                        components=inputLine.split(" ");
                        count+=1;
                    }   
                    System.out.println("Received: " + inputLine);
                    if (!in.ready()) {
                        break;
                    }
                }
            }catch(IOException  ex){
                    System.err.println("Error en la lectura del archivo");
            }
            page=components[1];
            String root;
            String filePath;
            if(page.endsWith(".html")){
                root="./pages";
                filePath= root+page;
                PageReader  pr  =new PageReader(filePath);
                String content=pr.loadPage();
                outputLine ="HTTP/1.1 200 OK \r\n"
                +"Content-Type: text/html\r\n"
                +"\r\n"
                + content                                   
                + inputLine;
                out.write(outputLine);
            }else if(page.endsWith(".jpg")){
                root="./img";
                filePath=root+page;
                ImageReader ir=new ImageReader(filePath);
                byte[] data = ir.loadImage();
                DataOutputStream binaryOut  =new DataOutputStream(clientSocket.getOutputStream());
                binaryOut.writeBytes("HTTP/1.1 200 OK \r\n");
                binaryOut.writeBytes("Content-Type: image/jpeg\r\n");
                binaryOut.writeBytes("Content-Length: " + data.length);
                binaryOut.writeBytes("\r\n\r\n");
                binaryOut.write(data);
                binaryOut.close();
            }    
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }
    }
}
