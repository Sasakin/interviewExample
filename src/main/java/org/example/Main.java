package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

public class Main {


    public static void main(String[] args) {
        /*HashMap<MyClass, String> map = new HashMap<>();

        map.put(new MyClass("test1"), "test1Value"); //
        map.put(new MyClass("test2"), "test2Value");
        map.put(new MyClass("test3"), "test3Value");

        map.get(new MyClass("test3"));

        System.out.println(map);

        HashSet set = new HashSet();
        set.add()*/

        HashSet<User> users = new HashSet<>();
        users.add(new User("1", "12", "2"));
        users.add(new User("1", "1", "23"));

        if(true) {
            int w = 0;
        }

    }

    public void createEntity() {

    }

    static class User {
        String login;
        String name;
        String sirname;

        public User(String login, String name, String sirname) {
            this.login = login;
            this.name = name;
            this.sirname = sirname;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(login, user.login);
        }

        @Override
        public int hashCode() {
            return Objects.hash(login);
        }
    }


}