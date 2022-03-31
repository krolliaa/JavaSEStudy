package Chapter03;

import java.util.HashSet;

public class HashSetAdd {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new String("A"));
        hashSet.add(new String("A"));
        System.out.println("HashSet = " + hashSet);
    }
}
