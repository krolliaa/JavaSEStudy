package Chapter07;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesAndClassLoader {
    public static void main(String[] args) throws IOException {
        //1.传统方式获取配置文件
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("userCopy.properties");//这里最好使用 try-catch 不过懒得写了，相对路径以 module 模块开头
        properties.load(fileInputStream);
        String name1 = properties.getProperty("name");
        String password1 = properties.getProperty("password");
        System.out.println("传统方式获取配置文件 ---> " + name1 + ":" + password1);
        //2.类加载器获取配置文件
        ClassLoader classLoader = PropertiesAndClassLoader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("user.properties");//相对路径以 src 目录开头
        properties.load(inputStream);
        String name2 = properties.getProperty("name");
        String password2 = properties.getProperty("password");
        System.out.println("类加载器获取配置文件 ---> " + name2 + ":" + password2);
    }
}
