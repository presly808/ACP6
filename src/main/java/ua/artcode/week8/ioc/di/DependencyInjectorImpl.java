package ua.artcode.week8.ioc.di;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by serhii on 13.06.15.
 */
public class DependencyInjectorImpl implements DependencyInjector {

    private static final String PATH =
            "/home/serhii/IdeaProjects/ACP6/temp/week8/context.properties";

    private Map<String,Object> context = new HashMap<>();

    public DependencyInjectorImpl() {
        initContext();
    }

    private void initContext() {
        Properties ps = new Properties();
        try {
            ps.load(new FileInputStream(PATH));

            for(String name : ps.stringPropertyNames()){
                Class cl = Class.forName(ps.getProperty(name));
                Object instance = cl.newInstance();
                context.put(name, instance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void doInjection(Object o) {
        Class cl = o.getClass();

        for(Field field : cl.getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(ForInject.class)){
                String fieldType = field.getType().getTypeName();
                Object forInject = context.get(fieldType);
                try {
                    field.set(o,forInject);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
