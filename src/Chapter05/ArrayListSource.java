package Chapter05;

import java.util.ArrayList;

public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        arrayList.add(11);
        System.out.println(arrayList.size());
        System.out.println(arrayList.toArray().length);
    }
}
