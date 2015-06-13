package ua.artcode.week8.ioc.di;

import java.util.Date;

/**
 * Created by serhii on 13.06.15.
 */
public class ClientLogic {

    private Service service = new ServiceBImpl();

    public void run(){
        System.out.println(service.format(new Date()));
    }

}
