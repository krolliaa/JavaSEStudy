package Chapter06;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class TCPTest1Server {
    public static void main(String[] args) {
        TCPTest1Server tcpTest11 = new TCPTest1Server();
        tcpTest11.server();
    }

    //服务端
    public void server() {
        //获取套接字发送过来的消息
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(9527);
            inputStream = serverSocket.accept().getInputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
            System.out.println("谁给我发的？" + serverSocket.getInetAddress().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
