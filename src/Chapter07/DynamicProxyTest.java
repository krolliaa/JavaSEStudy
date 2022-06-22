package Chapter07;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        ProxyInstance proxyInstance = new ProxyInstance();
        Human human = (Human) proxyInstance.getInstance(superMan);
        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory clothFactory = (ClothFactory) proxyInstance.getInstance(nikeClothFactory);
        human.getBelief();
        System.out.println("-------------------------");
        String food = human.eat();
        System.out.println(food);
        System.out.println("-------------------------");
        clothFactory.produceCloth();
    }
}

interface Human {
    public abstract void getBelief();

    public abstract String eat();
}

class SuperMan implements Human {
    @Override
    public void getBelief() {
        System.out.println("I belief i can fly!");
    }

    @Override
    public String eat() {
        return "Apple";
    }
}

class ProxyInstance {
    //返回一个代理类，形参表示代理类对象
    public Object getInstance(Object object) {
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler(object);
        //代理类需要被代理类的类加载器、被代理类实现的接口、以及要执行的代理方法
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), proxyInvocationHandler);
    }
}

class ProxyInvocationHandler implements InvocationHandler {

    //被代理类对象
    private Object object;

    public ProxyInvocationHandler(Object object) {
        this.object = object;
    }

    //看到 method.invoke(被代理类对象， 要执行的方法， 要执行的参数) 方法应该可以想到使用到了反射
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类执行一些准备工作...");
        Object returnObject = method.invoke(object, args);
        System.out.println("代理类执行一些收尾工作...");
        return returnObject;
    }
}