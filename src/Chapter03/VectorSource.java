package Chapter03;

import java.util.Vector;

public class VectorSource {
    public static void main(String[] args) {
        Vector vector = new Vector(1, 2);
        for (int i = 1; i <= 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println("Vector = " + vector);
    }
}
