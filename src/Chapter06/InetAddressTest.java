package Chapter06;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress1);
            InetAddress inetAddress2 = InetAddress.getLocalHost();
            System.out.println(inetAddress2);
            String hostName = InetAddress.getLocalHost().getHostName();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(hostName);
            System.out.println(hostAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
