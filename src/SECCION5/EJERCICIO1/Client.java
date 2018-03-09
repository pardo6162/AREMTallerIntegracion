/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION5.EJERCICIO1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2115237
 */
public class Client {
    public static void main(String[] args) {
        byte[] sendBuf = new byte[256];
        String received=null;
        while(true){
            try {
                DatagramSocket socket = new DatagramSocket();
                byte[] buf = new byte[256];
                InetAddress address = InetAddress.getByName("127.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
                socket.send(packet);
                packet = new DatagramPacket(buf, buf.length);
                socket.setSoTimeout(1000);
                
                try{
                    socket.receive(packet);
                    received = new String(packet.getData(), 0, packet.getLength());            
                    System.out.println("Date: " + received);
                }catch(SocketTimeoutException e){
                    System.out.println("Date: " + received);
                    socket.close();
                    
                }
                Thread.sleep(5000);
           } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SocketException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
}
