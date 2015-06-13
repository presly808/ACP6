package ua.artcode.week8.ioc.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.artcode.week8.ioc.di.ClientLogic;

/**
 * Created by serhii on 13.06.15.
 */
public class InitAppContext {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("week8/app-context.xml");

        for(String beanName : applicationContext.getBeanDefinitionNames()){
            System.out.println(beanName);
        }

        ClientLogic cl = applicationContext.getBean("client", ClientLogic.class);
        cl.run();
    }
}
