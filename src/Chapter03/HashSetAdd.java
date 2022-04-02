package Chapter03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class HashSetAdd {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new People("AAA"));
        hashSet.add(new People("BBB"));
        hashSet.add(new People("BBB"));

        HashMap hashMap = new HashMap();
        System.out.println("-----------------");
        System.out.println(hashMap.put("aaa", "aaa"));
        System.out.println(hashMap.put("bbb", "bbb"));
        System.out.println(hashMap.put("bbb", "ccc"));
        System.out.println("-----------------");


        System.out.println(hashMap.get("aaa"));
        System.out.println(hashMap.get("bbb"));

        System.out.println("HashSet = " + hashSet);
    }
}

class People {
    private String name;

    public People(String name) {
        this.name = name;
    }

    public int hashCode() {
        return 111;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(name, people.name);
    }
}
