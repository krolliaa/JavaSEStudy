package Chapter06;

import java.io.IOException;
import java.net.*;

public class UDPTestClient {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            datagramSocket = new DatagramSocket();
            byte[] data = "我是通过 UDP 协议发送的导弹！".getBytes();
            datagramPacket = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), 8888);
            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) datagramSocket.close();
        }
    }
}
