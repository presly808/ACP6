package ua.artcode.week3.day3;

import java.io.*;
import java.net.Socket;

/**
 * Created by serhii on 11.05.15.
 */
public class ClientSocketTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        InputStream is = socket.getInputStream();
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        InputStreamReader adapter = new InputStreamReader(is);
        BufferedReader bf = new BufferedReader(adapter);


        pw.println("Serhii");
        pw.flush();


        String remoteMessage = bf.readLine();
        System.out.println(remoteMessage);


    }
}
