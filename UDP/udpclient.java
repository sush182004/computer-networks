import java.io.*;
import java.net.*;

public class udpclient {
    public static void main(String[] args) {
        DatagramSocket skt = null;
        try {
            // Create a DatagramSocket
            skt = new DatagramSocket();
            
            // Message to send to the server
            String msg = "text message";
            byte[] b = msg.getBytes();

            // Get the IP address of the server (localhost in this case)
            InetAddress host = InetAddress.getByName("127.0.0.1");
            int serverPort = 2401;

            // Create a DatagramPacket to send the message to the server
            DatagramPacket request = new DatagramPacket(b, b.length, host, serverPort);
            skt.send(request);

            // Prepare to receive a reply
            byte[] buffer = new byte[1000];
            DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
            skt.receive(reply);

            // Print the received message from the server
            System.out.println("Client received: " + new String(reply.getData(), 0, reply.getLength()));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Close the socket
            if (skt != null && !skt.isClosed()) {
                skt.close();
            }
        }
    }
}

