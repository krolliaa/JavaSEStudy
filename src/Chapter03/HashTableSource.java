package Chapter03;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Objects;

public class HashTableSource {
    public static void main(String[] args) {
        HashMap hashtable = new HashMap();
        hashtable.put(new Dog("no1", 11), 1);
        hashtable.put(new Dog("no2", 11), 2);
        hashtable.put(new Dog("no3", 11), 3);
        hashtable.put(new Dog("no4", 11), 3);
        hashtable.put(new Dog("no5", 11), 3);
        hashtable.put(new Dog("no6", 11), 3);
        hashtable.put(new Dog("no7", 11), 3);
        hashtable.put(new Dog("no8", 11), 3);
        hashtable.put(new Dog("no9", 11), 3);
        hashtable.put(new Dog("no10", 11), 3);
        hashtable.put(new Dog("no11", 11), 3);
        hashtable.put(new Dog("no12", 11), 3);
    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return 1;
    }
}