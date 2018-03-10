/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 *
 * @author andres
 */
public class Client {
    public void ejecutaServicio(String ipRmiregistry, int puertoRmiRegistry,String nombreServicio) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String message ="";
            String secondM ="";
            Registry registry = LocateRegistry.getRegistry(ipRmiregistry, puertoRmiRegistry);
            Server echoServer = (Server) registry.lookup(nombreServicio);                                
            
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
            while(message.equals("Goodbye") ){            
                while(echoServer.getNMessage()){
                    if(!secondM.equals(message)){
                        System.out.println(secondM);
                    }                    
                }
                message =in.readLine();                     
                if(!message.equals(secondM)){
                    System.out.println(echoServer.echo(message));      
                    secondM = message;
                }
            }            
        } catch (Exception e) {
            System.err.println("There is a problem:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException{
        Client ec = new Client();
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("Write the IP Direction");            
        String ip=in.readLine(); 
        System.out.println("Write the port of connection");
        String port=in.readLine(); 
        ec.ejecutaServicio("127.0.0.1", 23000, "echoServer");
    }
}
