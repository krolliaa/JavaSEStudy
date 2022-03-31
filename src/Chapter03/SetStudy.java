package Chapter03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetStudy {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("john");
        set.add("lucy");
        set.add("kate");
        set.add("john");
        set.add(null);
        set.add(null);
        System.out.println("set = " + set);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println("iterator = " + object);
        }
        for (Object object : set) {
            System.out.println("for++ = " + object);
        }
        //无法使用普通for循环便利 Set
    }
}
