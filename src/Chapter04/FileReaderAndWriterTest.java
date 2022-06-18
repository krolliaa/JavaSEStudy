package Chapter04;

import java.io.*;

public class FileReaderAndWriterTest {
    public static void main(String[] args) {
        fileReaderM4();
    }

    public static void fileReaderM1() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("hello.txt");
            int data = -1;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileReaderM2() {
        FileReader fileReader = null;
        char[] cBuf = new char[5];
        try {
            fileReader = new FileReader("hello.txt");
            int len;
            while ((len = fileReader.read(cBuf, 0, cBuf.length)) != -1) {
                for (int i = 0; i < len; i++) System.out.print(cBuf[i]);
            }
            while ((len = fileReader.read(cBuf)) != -1) {
                //for (int i = 0; i < len; i++) System.out.print(cBuf[i]);
                String str = new String(cBuf, 0, len);
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void fileReaderM3() {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("hello.txt", true);
            fileWriter.write("!!!\n1234567890");
            //fileWriter.write("hello world");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileReaderM4() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File file = new File("text.txt");
            fileWriter = new FileWriter(file, false);
            fileWriter.write("This is a Reader and Writer text!!!\nYeah Yeah Yeah!!!");
            fileWriter.flush();
            fileReader = new FileReader(file);
            char[] cBuf = new char[5];
            int len;
            while ((len = fileReader.read(cBuf, 0, cBuf.length)) != -1) {
                //for (int i = 0; i < len; i++) System.out.print(cBuf[i]);
                System.out.print(new String(cBuf, 0, len));
            }
            System.out.println("\n文件长度：" + file.length());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
