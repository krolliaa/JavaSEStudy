package Chapter08;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    public static void main(String[] args) {
        //1.无形参，无返回值
        Runnable runnable = () -> System.out.println("毛爷爷");
        runnable.run();
        //2.有一个形参，无返回值
        //Consumer<String> consumer = (String str) -> System.out.println(str);
        //consumer.accept("Apple");
        //3.数据类型可以省略，因为编译器可以推断出来，称为“类型推断”【数组那一节中有学习过】
        //Consumer<String> consumer = (str) -> System.out.println(str);
        //consumer.accept("Apple");
        //4.只有一个形参，小括号可省
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("Apple");
        //5.有两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println("Lambda 表达式实现函数式接口方法！");
            return Integer.compare(o1, o2);
        };
        Integer compare = comparator.compare(1, 2);
        System.out.println(compare);
        //6.若只有一条语句，则 return 和大括号都可以省略
        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        Integer compare2 = comparator1.compare(1000, 102);
        System.out.println(compare2);
    }
}
