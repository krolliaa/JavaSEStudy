package Chapter03;

import java.util.LinkedHashSet;

public class LinkedHashSetSource {
    public static void main(String[] args) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new String("AAA"));
        linkedHashSet.add(456);
        linkedHashSet.add(456);
        linkedHashSet.add(new Customer(1001, "Z"));
        linkedHashSet.add(123);
        linkedHashSet.add("XML");
        System.out.println(linkedHashSet);
    }
}

class Customer {
    private int no;
    private String name;

    public Customer(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}