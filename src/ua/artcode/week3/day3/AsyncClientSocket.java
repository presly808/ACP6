package ua.artcode.week3.day3;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by serhii on 11.05.15.
 */
public class AsyncClientSocket {

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket("192.168.1.38",8888);
        // client write message
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    PrintWriter pw = new PrintWriter(socket.getOutputStream());
                    Scanner console = new Scanner(System.in);
                    while(true){
                        String message = console.nextLine();
                        pw.println(message);
                        pw.flush();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Scanner input = new Scanner(socket.getInputStream());
                    while(true){
                        if(input.hasNextLine()){
                            System.out.println(input.nextLine());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }).start();
    }
}
