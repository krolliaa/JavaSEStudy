package Chapter01;

public class MethodAndMethodReLoad {
    /*
        什么是方法？方法就是完成了某个特定的功能然后可以被重复调用的代码片段就叫做方法
        定义方法的格式为：[修饰符] 返回值类型 方法名（形式参数列表） {方法体}
        1.修饰符：修饰符不是必须的，因为有个默认值
        2.返回值类型：必须，必须定义好返回值类型，若无则定义为 void
        3.方法名：必须，只要符合标识符规则都可以作为方法名
        4.形式参数列表：不是必须的，根据需求而定，调用方法的一段需要传递实际参数，在个数和数据类型上都要一一对应
        5.方法体：必须，由一对大括号括起来的就是方法体

        底层 ---> 方法在执行过程中在内存是采用栈这种数据结构
        1.Java程序在开始执行的时候JVM通过类加载子系统找到存储在硬盘上的字节码文件，然后将其分配到方法区中【注意这里仅仅只是加载，加载分配到方法区中】
        2.main方法在调用的瞬间，会给main方法在栈内存中分配所属空间，此时发生入栈动作，JVM将main方法入栈【注意这里只有在调用方法的时候才将方法压到栈内存当中，否则一直保留在方法区中】
        3.当main方法调用完毕之后，此时发生出栈动作。main方法也相应执行结束。也就是说main方法是第一个入栈的但是是最后一个出栈的方法

        什么是方法重载？同名不同参的方法都可以称作方法重载，注意这里的“同名不同参”，不管你是参数个数还是参数数据类型还是参数顺序，只要不一样就都可以称作方法重载。其余的修饰符、返回值类型都跟方法重载无关系。
        方法重载的好处就在于可以直接传递不同的参数但是调用的却是同名方法。
    */
    public static void main(String[] args) {
        System.out.println(chooseMax(1, 2));
        System.out.println(chooseMax(1, 2, 3));
    }

    public static int chooseMax(int a, int b) {
        return a > b ? a : b;
    }

    public static int chooseMax(int a, int b, int c) {
        return chooseMax(a, b) > c ? chooseMax(a, b) : c;
    }
}