package ua.artcode.week10.soap.ws;

import ua.artcode.week10.soap.model.Robot;

import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebService(endpointInterface = "ua.artcode.week10.soap.ws.MyService")
public class MyServiceImpl implements MyService {

    private Map<Integer,Robot> map = new HashMap<>();

    public MyServiceImpl() {
        map.put(1, new Robot(1,"ANsdf", 10000,new Date()));
        map.put(2, new Robot(2,"GGOG", 9990,new Date()));
        map.put(3, new Robot(3,"ghghh", 2342,new Date()));
    }

    @Override
    public Robot getRobot(int id) {
        return map.get(id);
    }
}
