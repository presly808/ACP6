package ua.artcode.week8.ioc.di;

/**
 * Created by serhii on 13.06.15.
 */
public class TestDI {


    public static void main(String[] args) {
        DependencyInjector dependencyInjector = new DependencyInjectorImpl();

        ClientLogic clientLogic = new ClientLogic();

        dependencyInjector.doInjection(clientLogic);

        clientLogic.run();
    }
}
