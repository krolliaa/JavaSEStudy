package Chapter04;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) {
        /*File file = new File("hello.txt");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        File file3 = new File("world.txt");
        boolean rename = file.renameTo(file3);
        System.out.println(rename);//需要保证 file 存在并且 file3 不存在才能保证 rename 为 true
        File file1 = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy");
        File[] files = file1.listFiles();
        for(File file2 : files) System.out.println(file2.getAbsolutePath());*/
        //file.isDirectory() 判断是否是文件目录
        //file.isFile() 判断是否是文件
        //file.exists() 判断是否存在
        //file.canRead() 判断是否可读
        //file.canWrite() 判断是否可写
        //file.isHidden() 判断是否隐藏
        //boolean file.createNewFile() 创建文件，若文件存在则不创建返回 false
        //boolean file.mkdir() 创建文件目录
        //boolean file.mkdirs() 如果上层文件目录不存在一并创建
        //boolean delete() 删除文件或者文件夹
        File file = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy\\io1\\io2\\io3\\io4\\io5\\io6");
        if(!file.exists()) {
            boolean mkdirs = file.mkdirs();
            System.out.println("文件夹是否创建成功？" + mkdirs);
        }
        file.delete();
        File file1 = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy\\io1\\io2\\io3\\io4\\io5\\hello.txt");
        if(!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file2 = new File("E:\\2022年\\学习\\计算机学习\\Java\\JavaSEStudy\\io1\\io2\\io3\\io4\\io5");
        file2.delete();//内有文件无法删除
        System.out.println(file2.isDirectory());
    }
}
