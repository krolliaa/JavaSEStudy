package Chapter03;

import java.util.TreeSet;

public class TreeSetStudy {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("A"));
        treeSet.add(new Person("B"));
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }
}