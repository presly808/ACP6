package ua.artcode.week10.soap.ws;

import ua.artcode.week10.soap.model.Robot;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MyService {

    @WebMethod
    Robot getRobot(int id);

}
