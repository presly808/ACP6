package ua.artcode.week4.reflec;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by serhii on 16.05.15.
 */
public class Test {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);

        System.out.println("out");

        Man man = new Man(24,"Ivan",new Date());

        Class manClass = man.getClass();
        showClassStructure(manClass);

        Field ageField = manClass.getDeclaredField("age");
        ageField.setAccessible(true);
        Object obj = ageField.get(man);
        System.out.println(obj);

    }

    public static void showClassStructure(Class cl) throws NoSuchFieldException, NoSuchMethodException {
        System.out.println(cl.getName());
        Field field = cl.getField("name");
        System.out.println(field.toString());

        Method method = cl.getMethod("setName",String.class);
        System.out.println(method.toString());
    }
}
