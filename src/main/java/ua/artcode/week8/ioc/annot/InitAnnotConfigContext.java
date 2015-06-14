package ua.artcode.week8.ioc.annot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by serhii on 14.06.15.
 */
public class InitAnnotConfigContext {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("ua.artcode.week8.ioc");


        A a = (A) applicationContext.getBean("a");

        for(String beanName : applicationContext.getBeanDefinitionNames())
        {
            System.out.println(beanName);
        }


    }
}
