package org.hq.java.lesson8.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            ServerSocket server = new ServerSocket(80);
            System.out.println("SERVER UP");
            Socket socket = server.accept();// 阻塞在这，直到有人来联系
            System.out.println("CLIENT COMMING:");

            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            PrintWriter pw = new PrintWriter(out);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            String line = br.readLine();
            while (!line.equals("bye")) {
                System.out.println(line);
                line = br.readLine();
                pw.println(line);
                System.out.println(line);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
