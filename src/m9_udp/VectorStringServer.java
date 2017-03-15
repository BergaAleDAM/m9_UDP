package m9_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VectorStringServer {

    public static void main(String[] args) {
       try {
        
           
           //ByteArrayOutputStream/Input
           //ObjectOutputStream/Input
           
           
           //object.readobject
            int puerto = 2020;
        
            byte[] buffer = new byte[1000];
            
            DatagramSocket socket = new DatagramSocket(puerto);
            
            
            DatagramPacket paquetillo = new DatagramPacket(buffer, buffer.length);
        
            socket.receive(paquetillo);
            String str = new String(paquetillo.getData(), "UTF-8").toUpperCase();
            
            //JOptionPane.showMessageDialog(null, str + "  <-  Esto es lo que el servidor va a pasar");
            
            System.out.println(str);
            byte[] mensaje = str.getBytes();
            
            DatagramPacket enviador = new DatagramPacket(mensaje, mensaje.length, paquetillo.getAddress(),paquetillo.getPort());
            
            socket.send(enviador);
            
            socket.close();
        
        } catch (SocketException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServidorUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
       
    }

}
