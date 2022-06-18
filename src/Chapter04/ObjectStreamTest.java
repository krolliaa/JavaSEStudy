package Chapter04;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(new String("我爱北京天安门"));
            objectOutputStream.flush();
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object str = objectInputStream.readObject();
            System.out.println(str);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
