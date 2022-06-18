package Chapter04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamAndOutputStreamTest {
    public static void main(String[] args) {
        fileInputOutputM3();
    }

    public static void fileInputOutputM1() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("19.jpg");
            int data;
            while ((data = fileInputStream.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileInputOutputM2() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("19.jpg");
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer, 0, buffer.length)) != -1) {
                //for (int i = 0; i < len; i++) System.out.print((char)buffer[i]);
                System.out.print(new String(buffer, 0, len));
            }
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileInputOutputM3() {
        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("19.jpg");
            fileOutputStream = new FileOutputStream("19copy.jpg");
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer, 0, buffer.length)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print((char) buffer[i]);
                    fileOutputStream.write(buffer[i]);
                }
                //System.out.print(new String(buffer, 0, len));
            }
            fileOutputStream.flush();
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
