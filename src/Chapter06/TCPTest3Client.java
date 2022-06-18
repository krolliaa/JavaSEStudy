package Chapter06;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest3Client {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        InputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(new FileReader("text.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                outputStreamWriter.write(line + "\n");
            }
            outputStreamWriter.flush();
            //这里传输完数据需要手动关闭下输出流
            socket.shutdownOutput();
            //客户端接收服务端发送的消息
            inputStream = socket.getInputStream();
            int len;
            byte[] buffer = new byte[1024];
            System.out.print("收到了来自服务端的消息：");
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
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
