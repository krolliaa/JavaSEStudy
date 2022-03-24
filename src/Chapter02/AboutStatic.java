package Chapter02;

public class AboutStatic {
    /*
        static 关键字表示静态的，它可以用来修饰变量、方法、代码块等。若用static修饰，修饰的方法叫做静态方法，变量叫做静态变量，代码块叫做静态代码块。
        凡是用 static 修饰的都是跟类相关的，不用创建对象调用对象就可以调用，因为静态的东西存储在方法区当中，而方法区是线程共享的。

        1.什么时候变量定义成是静态的？因为静态的东西不会也不需要随着对象的变化而变化，那么就可以将其定义为是静态的。
                                 若要证实即使通过对象.的方式访问静态变量还是调用类.的方式调用，可以看null.的方式也可以调用，说明跟对象无关
        2.什么时候方法定义成是静态的？一样的道理，如果这个方法没有特殊的意义，谁调都一样那么将其用 static 修饰即可
        3.静态代码块什么时候被调用？在一开始JVM类加载器子系统进行类加载的时候就被调用了。并且静态变量跟静态代码块都是一块儿初始化顺序，都是在链接准备阶段赋一个初始值在初始化阶段赋值

        这里打印出将打印出 9，知道为什么吗？一步步分析即可知道答案。
        首先这里 static int value = 9;在类加载阶段就已经初始化好值所以此时方法区中存在一个value=9的常量
        回到 main() 方法中，创建了一个 AboutStatic 对象并且调用了 printValue() 方法，
        进入到 printValue() 方法中，可以看到首先定义了一个局部变量，我们知道局部变量是放在栈空间当中，栈空间里的内容是不共享的
        然后打印 this.value 这里的 this 就是 AboutStatic 对象本身，对象存储在堆内存当中，但是堆里面是没有 value 这个变量的，
        所以去方法区中找，发现找到一个 value = 9 所以输出  9
     */
    static int value = 9;

    public static void main(String[] args) throws Exception {
        new AboutStatic().printValue();
    }

    public void printValue() {
        int value = 69;
        System.out.println(this.value);
    }
}