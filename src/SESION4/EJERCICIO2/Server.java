/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SESION4.EJERCICIO2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author andres
 */
public class Server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        String fun= "fun:cos";
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(
                    clientSocket.getInputStream()));
        String inputLine, outputLine;
        while((inputLine = in.readLine())!=null){
            System.out.println("Recibido: " + inputLine);
            if(inputLine.contains("fun:")){
                System.out.println(inputLine);
                fun=inputLine;
                out.println("Funcion cambiada a: "+inputLine.replaceAll("fun:",""));
            }
            else{
                System.out.println("entra");
                double resp=0;
                if(fun.equals("fun:cos"))resp = Math.cos(Double.parseDouble(inputLine));
                else if(fun.equals("fun:sin")){
                    
                    resp = Math.sin(Double.parseDouble(inputLine));
                }
                else if(fun.equals("fun:tan")) resp = Math.tan(Double.parseDouble(inputLine));
                outputLine = "Respuesta: " + resp  ;
                out.println(outputLine);
            }
            
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
