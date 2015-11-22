package org.hq.java.lesson8.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    /**
     * @param args
     * @throws IOException
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException,
        IOException {
        Socket socket = new Socket("127.0.0.1", 80);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        PrintWriter pw = new PrintWriter(out);
        // BufferedReader br = new BufferedReader(new InputStreamReader(in));

        BufferedReader brin = new BufferedReader(new InputStreamReader(
            System.in));
        String line;
        while ((line = brin.readLine()) != null) {
            if (line.equals("bye")) {
                System.out.println(line);
                pw.print(line);
                pw.flush();
                socket.close();
            } else {
                System.out.println(line);
                pw.println(line);
                pw.flush();
            }
        }

    }
}
