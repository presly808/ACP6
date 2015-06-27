package ua.artcode.week10.soap;

import ua.artcode.week10.soap.ws.MyServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by serhii on 27.06.15.
 */
public class Run {


    public static void main(String[] args) {
        Endpoint.publish("http://192.168.1.45:9999/ws/robot",new MyServiceImpl());
    }
}
