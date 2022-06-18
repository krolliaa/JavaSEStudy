package Chapter04;

class Base {
    public void add(int a, int... arr) {
        System.out.println("base");
    }
}

class Sub extends Base {
    public void add(int a, int[] b) {
        System.out.println("sub_1");
    }

    public void add(int a, int b, int c) {
        System.out.println("sub_2");
    }
}

public class FieldMethodTest {

    public FieldMethodTest() {
        System.out.println("这是构造器！");
    }

    public static void main(String[] args) {
        FieldMethodTest fieldMethodTest = new FieldMethodTest();
    }

    static {
        System.out.println("这是静态代码块1！");
    }

    static {
        System.out.println("这是静态代码块2！");
    }

    {
        System.out.println("这是非静态代码块1！");
    }

    {
        System.out.println("这是非静态代码块2！");
    }
}