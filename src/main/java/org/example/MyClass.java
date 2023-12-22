package org.example;

import java.util.Objects;

public class MyClass implements Comparable<MyClass> {

    String name;

    public MyClass(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(name, myClass.name);
    }

    @Override
    public int compareTo(MyClass o) {

        return 0;
    }
}
