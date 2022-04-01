package Chapter03;

import java.util.HashSet;

public class HashSetAdd {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        for (int i = 1; i <= 16; i++) {
            hashSet.add(i);
        }
        System.out.println("HashSet = " + hashSet);
    }
}
