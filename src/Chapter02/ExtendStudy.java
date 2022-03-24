package Chapter02;

public class ExtendStudy {
    /*
        继承是面向对象的三大特性之一，封装继承和多态三者是相互关联的关系，正是因为有了封装形成了独立整体才有了继承的概念。
        class 类名 extends 父类名 {类体;}
        1.被继承的类叫做超类基类或者叫父类，随便你叫，继承它的类叫做子类派生类或者叫扩展类也随便你叫。
        2.在 Java 中继承你只能继承一个类，也就是说一个类只能直接继承一个类，但是可以间接继承
        3.子类只能继承父类想给它继承的那部分，什么叫做想给它？像private修饰私有的以及父类的构造方法，一个是私房钱一个是命根子两个想给都给不了，无法给继承
        4.Java中没有直接显式地继承某个类其实就是继承了 Object 类，这个类是祖宗类
        5.继承的两个类就导致了耦合度非常高，修改父类则会直接影响到子类。
        6.执行顺序：父类静态代码块>子类静态代码块>父类构造代码快>父类构造器>子类构造代码快>子类构造
        7.子类可以继承父类的静态变量和静态方法，因为存在方法区中如果子类及修改了该静态变量或者静态方法，从表面上看父类的也被修改了，其实是因为都拿的是同一个数据都在方法区中
        8.
    */
    public static void main(String[] args) {
        System.out.println(B.a);
        B.a = 100;
        System.out.println(B.a);
        System.out.println(A.a);
        A.method();
        B.method();
    }
}

class A {
    static int a = 10;
    static int b = 10;

    public static void method() {
        System.out.println("---A---");
    }
}

class B extends A {
    static int b = 20;

    public static void method() {
        System.out.println("---B---");
    }
}
