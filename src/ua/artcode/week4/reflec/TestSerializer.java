package ua.artcode.week4.reflec;

import java.util.Date;

/**
 * Created by serhii on 16.05.15.
 */
public class TestSerializer {

    public static final String PATH = "/home/serhii/IdeaProjects/ACP6/temp/man.txt";

    public static void main(String[] args) {
        Man man = new Man(23,"Yuriy", new Date());
        ReflectSerializer.save(man, PATH);

        //Man loaded = (Man) ReflectSerializer.read(PATH);

        //System.out.println(loaded);
    }
}
