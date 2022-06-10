public interface Network {
    public abstract void work();
}

class Server implements Network {
    @Override
    public void work() {
        System.out.println("服务器完成联网，开始工作...");
    }
}

class ProxyServer implements Network {

    private Server server = null;

    public ProxyServer(Server server) {
        this.server = server;
    }

    public void check() {
        System.out.println("完成联网前的设备检查...");
    }

    @Override
    public void work() {
        check();
        server.work();
    }
}

class Test {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.work();
    }
}
interface A {
    public static final int x = 0;
}

class B {
    int x = 1;
}

class C extends B implements A {
    public void pX() {
        System.out.println(super.x);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}
