package Chapter06;

import java.io.*;
import java.net.ServerSocket;

public class TCPTest2Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        InputStreamReader inputStreamReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            serverSocket = new ServerSocket(8888);
            inputStreamReader = new InputStreamReader(serverSocket.accept().getInputStream());
            char[] buffer = new char[1024];
            int len;
            bufferedWriter = new BufferedWriter(new FileWriter("textCopy.txt"));
            while ((len = inputStreamReader.read(buffer, 0, buffer.length)) != -1) {
                bufferedWriter.write(new String(buffer, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
