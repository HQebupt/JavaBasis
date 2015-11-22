package org.hq.java.lesson8.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(10080);

        String line = "are you there?";
        byte[] b = line.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(b, b.length,
            new InetSocketAddress("localhost", 10081));
        socket.send(sendPacket);
    }

}
