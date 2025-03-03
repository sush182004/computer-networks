/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.net.*;

public class udpserver {
    public static void main(String[] args) {
        DatagramSocket skt = null;
        int port = 2401;  // Or choose another available port
        
        try {
            skt = new DatagramSocket(port);  // Bind the socket to a specific port
            System.out.println("Server is running on port " + port);

            byte[] buffer = new byte[1000];
            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                skt.receive(request);  // Receive a packet from the client

                // Process and send a reply
                String response = "Message received: " + new String(request.getData(), 0, request.getLength());
                DatagramPacket reply = new DatagramPacket(response.getBytes(), response.length(),
                        request.getAddress(), request.getPort());
                skt.send(reply);  // Send reply to the client
            }
        } catch (BindException e) {
            System.err.println("Port " + port + " is already in use. Please try a different port.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (skt != null && !skt.isClosed()) {
                skt.close();
            }
        }
    }
}


