package Chapter04;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("raf.txt", "rw");
            randomAccessFile.seek(3);
            //先读取然后插入再覆盖
            byte[] buffer = new byte[1024];
            int len;
            StringBuilder stringBuilder = new StringBuilder();
            while ((len = randomAccessFile.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, len));
            }
            randomAccessFile.seek(3);
            randomAccessFile.write("xyz".getBytes());
            randomAccessFile.write(stringBuilder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
