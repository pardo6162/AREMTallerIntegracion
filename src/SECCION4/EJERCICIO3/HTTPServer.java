/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION4.EJERCICIO3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author 2115237
 */
public class HTTPServer {
    public static void main(String[] args) throws IOException {
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
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        //BufferedWriter out =new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        BufferedReader in = new BufferedReader(
        new InputStreamReader(
            clientSocket.getInputStream()
        ));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }
        }
        outputLine ="HTTP/1.1 200 OK \r\n"
                +"Content-Type: text/html; charset=utf-8\r\n"
                +"Cache-Control: public, max-age=60, s-maxage=300\r\n"
                +"Vary: Accept-Encoding\r\n"
                +"Content-Encoding: raw\r\n"
                +"Server: DPS/1.3.5\r\n"
                +"X-SiteId: 2000\r\n"
                +"Set-Cookie: dps_site_id=2000; path=/\r\n"
                +"ETag: a1be084ec13bc207c17c49955f875fab\r\n"
                +"Date: Mon, 26 Feb 2018 21:47:54 GMT\r\n"
                +"Connection: keep-alive\r\n"
                +"Transfer-Encoding: chunked\r\n"  
                +"<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset=\"UTF-8\">"
                    + "<title>Title of the document</title>\r\n"
                    + "</head>"
                    + "<body>"
                    + "My Web Site"
                    + "</body>"
                    + "</html>" + inputLine;
        out.println(outputLine);
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
