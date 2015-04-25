package ua.artcode.ds.hash;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by serhii on 19.04.15.
 */
public class TestHashMap {

    public static void main(String[] args) {
        Date birthday = new Date();
        User user1 = new User(23,"134", birthday, 234, 12312);
        User user2 = new User(23,"134", birthday, 234, 12312);
        User user3 = new User(23,"096", birthday, 4656, 1231232);

        System.out.println("user1.equals(user2) " + user1.equals(user2));
        System.out.println("user1.hashCode() == user2.hashCode() " +
                (user1.hashCode() == user2.hashCode()));

        Map<User,String> map = new HashMap<>();
        map.put(user1,"Kolia");
        map.put(user2,"Vasia");
        map.put(user3,"Andrey");

        System.out.println(map.size());


        // problems
        FailEnt f1 = new FailEnt(23,"sdfs");
        FailEnt f2 = new FailEnt(23,"sdfs");
        FailEnt f3 = new FailEnt(23,"sdfs");

        Map<FailEnt,String> map2 = new HashMap<>();
        map2.put(f1,"value1");
        map2.put(f2,"value2");
        map2.put(f3,"value3");

        System.out.println(map2.size());
        // end

    }


}

class FailEnt {

    int age;
    String name;

    public FailEnt(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
