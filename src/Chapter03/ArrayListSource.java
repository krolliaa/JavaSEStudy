package Chapter03;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }
        for (int i = 11; i <= 15; i++) arrayList.add(i);
        arrayList.add(100);
        arrayList.add(200);
        arrayList.add(null);
    }
}
