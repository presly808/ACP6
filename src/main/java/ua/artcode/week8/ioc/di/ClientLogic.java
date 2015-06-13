package ua.artcode.week8.ioc.di;

import java.util.Date;

/**
 * Created by serhii on 13.06.15.
 */
public class ClientLogic {

    @ForInject
    private Service service;

    public ClientLogic() {
    }

    public ClientLogic(Service service) {
        this.service = service;
    }

    public void run(){
        System.out.println(service.format(new Date()));
    }

    public void setService(Service service) {
        this.service = service;
    }
}
