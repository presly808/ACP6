package ua.artcode.week9.day1.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by serhii on 20.06.15.
 */
public class TestHttp {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("uk.wikipedia.org",80);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("GET /wiki/HTTP HTTP/1.1\n" +
                "Host: uk.wikipedia.org\n");
        pw.flush();


        readStream(socket.getInputStream());









    }

    private static void readStream(InputStream inputStream) throws IOException {
        Scanner sc = new Scanner(inputStream);

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
