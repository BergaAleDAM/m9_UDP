package m9_udp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VectorStringServer {

    private static final int PORT = 2020;
    private static String corrrecto = "Ok!";
    private static byte[] correctoBytes = corrrecto.getBytes();

    public static void main(String[] args) throws ClassNotFoundException {

        byte[] buffer = new byte[1000];

        try {
            System.out.println("Server:");
            DatagramSocket socketUDP = new DatagramSocket(PORT, InetAddress.getLocalHost());
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);

            socketUDP.receive(dp);

            ByteArrayInputStream bais = new ByteArrayInputStream(dp.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            VectorStringClasse5 vs = (VectorStringClasse5) ois.readObject();

            for (String string : vs.getV()) {
                System.out.println(string);
            }

            DatagramPacket paquetillo = new DatagramPacket(correctoBytes, correctoBytes.length, dp.getAddress(), dp.getPort());
            socketUDP.send(paquetillo);

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
