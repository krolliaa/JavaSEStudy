package Chapter06;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest1Client {
    public static void main(String[] args) {
        client();
    }

    //客户端
    public static void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //向谁发 ---> 套接字 IP + Port
            socket = new Socket(inetAddress, 9527);
            outputStream = socket.getOutputStream();
            outputStream.write("Hello World!".getBytes());
            outputStream.flush();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
