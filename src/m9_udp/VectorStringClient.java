package m9_udp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VectorStringClient {
    
    private static final int PORT = 2020;

     public static void main(String[] args){

        byte[] buffer = new byte[1000];
        String[] mensajesEscrito = new String[5];
       
        try {
            
            
            InetAddress addr = InetAddress.getLocalHost();
            
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            System.out.println("Client:");
            DatagramSocket socketUDP = new DatagramSocket();

           for (int i = 0; i < 5; i++) {
                mensajesEscrito[i] = JOptionPane.showInputDialog(null, "Introduce el mensaje", 1);
            }
           
           oos.writeObject(new VectorStringClasse5(mensajesEscrito));
            //oos.flush();

            byte[] arrayBytes = baos.toByteArray();

            DatagramPacket dp = new DatagramPacket(arrayBytes, arrayBytes.length, addr, PORT);
            socketUDP.send(dp);
            

            DatagramPacket paquetillo = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(paquetillo);

            System.out.println(new String(paquetillo.getData()));
            socketUDP.close();
            
            
        } catch (SocketException ex) {
            System.out.println(ex);
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
