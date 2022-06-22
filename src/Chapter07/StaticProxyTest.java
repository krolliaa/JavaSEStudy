package Chapter07;

public class StaticProxyTest {
    public static void main(String[] args) {
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFactory);
        proxyClothFactory.produceCloth();
    }
}

interface ClothFactory {
    public abstract void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("执行生产衣服的准备工作");
        clothFactory.produceCloth();
        System.out.println("执行生产衣服的收尾工作");
    }
}

class NikeClothFactory implements ClothFactory {
    @Override
    public void produceCloth() {
        System.out.println("Nike 生产了一批运动裤");
    }
}