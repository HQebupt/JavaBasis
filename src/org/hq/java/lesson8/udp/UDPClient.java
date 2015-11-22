package org.hq.java.lesson8.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {

    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(10081);
        byte[] buf = new byte[1000];
        int length = buf.length;
        DatagramPacket p = new DatagramPacket(buf, length);
        socket.receive(p);
        String line = new String(buf, 0, p.getLength());
        System.out.println(line);
    }

}
