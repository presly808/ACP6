package ua.artcode.week3.day3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by serhii on 11.05.15.
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8888);
        while(true){
            try {
                Socket client = ss.accept();

                Thread clientReadTread = new Thread(new InputClientMessageThread(client.getInetAddress().toString(),
                        client.getPort(),client.getInputStream()));
                clientReadTread.start();

                Thread clientWriteThread = new Thread(new OutputClientMessageThread(client.getInetAddress().toString(),
                        client.getPort(),client.getOutputStream()));
                clientWriteThread.start();



                String message = String.format("ip %s, port %s\n",
                        client.getInetAddress(),
                        client.getPort());



                System.out.println(message);

            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}


class OutputClientMessageThread implements Runnable {

    private PrintWriter pw;
    private String ip;
    private int port;

    public OutputClientMessageThread(String ip, int port,OutputStream inputStream) {
        this.ip = ip;
        this.port = port;
        pw = new PrintWriter(inputStream);
    }

    @Override
    public void run() {
        /*while(true){
                pw.println("Hello from server time is " + new Date().toString());
                pw.flush();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}

class InputClientMessageThread implements Runnable {

    private BufferedReader bf;
    private String ip;
    private int port;

    public InputClientMessageThread(String ip, int port,InputStream inputStream) {
        this.ip = ip;
        this.port = port;
        bf = new BufferedReader(new InputStreamReader(inputStream));
    }

    @Override
    public void run() {
        while(true){
            try {
                String s = bf.readLine();
                if(s != null){
                    System.out.println(ip + ":" + ":" + port + " -> " + s);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}


