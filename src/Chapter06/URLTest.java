package Chapter06;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baidu.com/example/test.txt");
            System.out.println("获取URL协议名：" + url.getProtocol());
            System.out.println("获取URL主机名：" + url.getHost());
            System.out.println("获取URL端口号：" + url.getPort());
            System.out.println("获取URL文件名：" + url.getFile());
            System.out.println("获取URL文件路径：" + url.getPath());
            System.out.println("获取URL查询名：" + url.getQuery());
            URLConnection urlConnection = url.openConnection();//获取到 HTTP 连接
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            //连接
            httpURLConnection.connect();
            InputStream inputStream = httpURLConnection.getInputStream();
            //后面就是拷贝数据的操作了，不再多加阐述
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //进行资源关闭
        }
    }
}
