package Chapter03;

import java.util.HashSet;
import java.util.Objects;

public class CollectionAndMapHomeWork6 {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        MyPerson p1 = new MyPerson(1001, "AA");
        MyPerson p2 = new MyPerson(1002, "BB");
        set.add(p1);
        set.add(p2);
        System.out.println("set = " + set);
        p1.name = "CC";
        System.out.println("set = " + set);
        set.remove(p1);
        System.out.println("set = " + set);
        set.add(new MyPerson(1001, "CC"));
        System.out.println("set = " + set);
        set.add(new MyPerson(1001, "AA"));
        System.out.println("set = " + set);
    }
}

class MyPerson {
    Integer id;
    String name;

    public MyPerson(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyPerson myPerson = (MyPerson) o;
        return Objects.equals(id, myPerson.id) && Objects.equals(name, myPerson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "MyPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}