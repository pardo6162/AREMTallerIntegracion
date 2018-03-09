/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECCION4.EJERCICIO3;

/**
 *
 * @author andres
 */
public class ImageReader {
    //BufferedImage img = ImageIO.read(new URL("http://stackoverflow.com/content/img/so/logo.png"));
    /**void readImage() throws IOException
{
    socket = new Socket("upload.wikimedia.org", 80);


    DataOutputStream bw = new DataOutputStream(new DataOutputStream(socket.getOutputStream()));
    bw.writeBytes("GET /wikipedia/commons/8/80/Knut_IMG_8095.jpg HTTP/1.1\n");
    bw.writeBytes("Host: wlab.cs.bilkent.edu.tr:80\n\n");

    DataInputStream in = new DataInputStream(socket.getInputStream());

    File file = new File("imgg.jpg");
    file.createNewFile();
    DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
    int count;
    byte[] buffer = new byte[8192];
    while ((count = in.read(buffer)) > 0)
    {
      dos.write(buffer, 0, count);
      dos.flush();
    }
    dos.close();
    System.out.println("image transfer done");

    socket.close();     
}**/
}
