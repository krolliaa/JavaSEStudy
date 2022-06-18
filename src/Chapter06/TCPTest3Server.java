package Chapter06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStreamReader inputStreamReader = null;
        BufferedWriter bufferedWriter = null;
        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();//socket 只能接收一个且只能接收一次
            inputStreamReader = new InputStreamReader(socket.getInputStream());
            char[] buffer = new char[1024];
            int len;
            bufferedWriter = new BufferedWriter(new FileWriter("textCopy.txt"));
            while ((len = inputStreamReader.read(buffer, 0, buffer.length)) != -1) {
                bufferedWriter.write(new String(buffer, 0, len));
            }
            bufferedWriter.flush();
            //下列代码没有执行：
            System.out.print("成功接收来自客户端的文件！");
            outputStream = socket.getOutputStream();
            outputStream.write("中国出了个毛泽东！".getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
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
