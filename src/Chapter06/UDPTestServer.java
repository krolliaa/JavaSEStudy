package Chapter06;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPTestServer {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            datagramSocket = new DatagramSocket(8888);
            byte[] data = new byte[1024];
            datagramPacket = new DatagramPacket(data, 0, data.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("服务端接收到的 UDP 数据：" + new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) datagramSocket.close();
        }
    }
}
