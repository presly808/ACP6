package ua.artcode.week3.day3;

import org.omg.CORBA.portable.*;

import java.io.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by serhii on 11.05.15.
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(8888);
        ClientsContainerObserver observer = new ClientsContainerObserver();

        while(true){
            try {
                Socket client = ss.accept();

                observer.addNewStream(client.getOutputStream());

                Thread clientReadTread = new Thread(
                        new InputClientMessageThread(observer,
                                client.getInputStream(),
                                client.getInetAddress().toString(),
                                client.getPort()));
                clientReadTread.start();

                String message = String.format("New client connection ip %s, port %s\n",
                        client.getInetAddress(),
                        client.getPort());

                System.out.println(message);

            } catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}

class ClientsContainerObserver {

    private List<PrintWriter> clientOutputStreamList = new LinkedList<>();

    public void addNewStream(OutputStream oos) {
        clientOutputStreamList.add(new PrintWriter(oos));
    }

    public synchronized void sendMessage(String message){
        for (PrintWriter pw : clientOutputStreamList){
            pw.println(message);
            pw.flush();
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

    private ClientsContainerObserver observer;
    private BufferedReader bf;
    private String ip;
    private int port;

    public InputClientMessageThread(String ip, int port,InputStream inputStream) {
        this.ip = ip;
        this.port = port;
        bf = new BufferedReader(new InputStreamReader(inputStream));
    }

    public InputClientMessageThread(ClientsContainerObserver observer, InputStream bf,
                                    String ip, int port) {
        this.observer = observer;
        this.bf = new BufferedReader(new InputStreamReader(bf));
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        while(true){
            try {
                String s = bf.readLine();
                if(s != null){
                    String message = ip + ":" + ":" + port + " -> " + s;
                    observer.sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}


