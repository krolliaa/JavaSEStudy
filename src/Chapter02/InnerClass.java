package Chapter02;

public class InnerClass {
    /*
        内部类可以划分为：实例内部类、局部内部类、静态内部类、匿名内部类
        实例内部类：实例内部类只能在实例已经创建好的前提下才能使用，正因为如此，实例内部类不能是公共类，最多也只能是子类才能访问。因为是实例内部类，所以无法创建和使用static关键字
        局部内部类：局部内部类跟局部变量的作用一样，直接看成是局部变量即可
        静态内部类：可以访问外部类的静态变量/方法但是无法直接访问外部的成员变量/方法只能通过外部类对象访问
        匿名内部类：抽象方法另外一种实现方式，变相实现，简单方便
    */
}
