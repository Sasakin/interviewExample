package org.example.hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class MainHashMap {
    public static void main(String[] args) {

        HashMap<HashMapKey, Cat> map = new HashMap<>();

        map.put(new HashMapKey("Кузя"), new Cat("Кузя"));
        map.put(new HashMapKey("Кузя1"), new Cat("Кузя1"));
        map.put(new HashMapKey("Кузя"), new Cat("Кузя"));
        map.put(new HashMapKey("Кузя"), new Cat("Кузя"));

        HashSet<HashMapKey> set = new HashSet<>();

        set.add(new HashMapKey("Кузя"));
        set.add(new HashMapKey("Кузя"));
        set.add(new HashMapKey("Вася"));

        System.out.println(set);
        /*HashMap<MyClass, String> map = new HashMap<>();

        map.put(new MyClass("test1"), "test1Value"); //
        map.put(new MyClass("test2"), "test2Value");
        map.put(new MyClass("test3"), "test3Value");

        map.get(new MyClass("test3"));

        System.out.println(map);

        HashSet set = new HashSet();
        set.add()*/

       /* HashSet<Main.User> users = new HashSet<>();
        users.add(new Main.User("1", "12", "2"));
        users.add(new Main.User("1", "1", "23"));

        if(true) {
            int w = 0;
        }*/

    }
}
