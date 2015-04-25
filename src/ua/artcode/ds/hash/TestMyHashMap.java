package ua.artcode.ds.hash;

import java.util.Map;

/**
 * Created by serhii on 25.04.15.
 */
public class TestMyHashMap {
    public static void main(String[] args) {
        Map<String,Integer> map = new MyHashMap<>();
        map.put("oleg",12);
        map.put("ivan",12);
        map.put("john",12);

        int hash = -2345;
        System.out.println(hash < 0 ? (hash * (-1) % 10) : hash % 10);

    }
}
