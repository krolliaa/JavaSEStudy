package Chapter03;

import java.util.HashSet;

public class HashSetAdd {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new String("ABC"));
        System.out.println(hashSet.add(new String("ABC")));
        System.out.println("HashSet = " + hashSet);
    }
}
