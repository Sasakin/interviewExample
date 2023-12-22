package org.example.hashmap;

import java.util.Objects;

public class HashMapKey {

    private String key;

    public HashMapKey(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (key == null ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashMapKey that = (HashMapKey) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public String toString() {
        return "HashMapKey{" +
                "key='" + key + '\'' +
                '}';
    }
}
