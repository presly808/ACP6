package ua.artcode.week10.soap.ws;

/**
 * Created by serhii on 27.06.15.
 */
public class RunClient {
    public static void main(String[] args) {

        MyServiceImplService robotService = new MyServiceImplService();
        MyService service = robotService.getMyServiceImplPort();
        Robot robot = service.getRobot(1);

        System.out.printf("robot id %d, model %s, price %.3f",
                robot.getId(),robot.getModel(), robot.getPrice());


    }
}
