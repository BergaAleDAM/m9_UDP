package m9_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientUDP {

    public static void main(String[] args) {
        
        try {
           
            int puerto = 2020;
            InetAddress addr = InetAddress.getLocalHost();
            
            byte[] buffer = new byte[1000]; 
            
            DatagramSocket socket = new DatagramSocket();
            
            String seleccion = JOptionPane.showInputDialog( null, "Pon Cosas",JOptionPane.QUESTION_MESSAGE);
            
            
            byte[] cositis = seleccion.getBytes();                                                                                                                                                                                                                                                                                                                                                                                                                                          
            
            
            DatagramPacket enviador = new DatagramPacket(cositis, cositis.length,addr,puerto);
            
            socket.send(enviador);
            
            DatagramPacket paquetillo = new DatagramPacket(buffer, buffer.length);
        
            socket.receive(paquetillo);
            
            
            String str = new String(paquetillo.getData(), "UTF-8");
            
            JOptionPane.showMessageDialog(null, str + " <-  Esto es lo que ha recibido el cliente");
            
            socket.close();
            
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}























