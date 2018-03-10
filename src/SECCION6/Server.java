/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION6;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author 2115237
 */
public interface Server extends Remote{
    public String echo(String cadena) throws RemoteException;
    public String getLMessage() throws RemoteException;
    public boolean getNMessage() throws RemoteException;
}
