package Chapter08;

import Chapter07.Person;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodQuote {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    //方法是非静态方法 可以使用对象::非静态方法调用
    //消费型函数式接口Consumer:accept(T) 一个参数 + 无返回值
    public static void test1() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("毛爷爷");
        System.out.println("--------------------------");
        consumer = (String str) -> System.out.println(str);
        consumer.accept("石头");
        System.out.println("--------------------------");
        PrintStream printStream = System.out;
        consumer = printStream::println;
        consumer.accept("Chinese Father");
        System.out.println("--------------------------");
    }

    //供给型函数式接口Supplier:get() return T; 没有参数 + 有返回值
    public static void test2() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "获取了大葫芦娃";
            }
        };
        String BigHuLuWa = supplier.get();
        System.out.println(BigHuLuWa);
        System.out.println("--------------------------");
        supplier = () -> {
            return "获取了中葫芦娃";
        };
        String MiddleHuLuWa = supplier.get();
        System.out.println(MiddleHuLuWa);
        System.out.println("--------------------------");
        HuLuWa huLuWa = new HuLuWa();
        supplier = huLuWa::toString;
        String smallHuLuWa = supplier.get();
        System.out.println(smallHuLuWa);
        System.out.println("--------------------------");
    }

    //方法是静态方法可以使用 类::静态方法调用
    public static void test3() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        Integer answer1 = comparator.compare(100, 200);
        System.out.println(answer1);
        System.out.println("--------------------------");
        comparator = (Integer o1, Integer o2) -> {
            return Integer.compare(o1, o2);
        };
        Integer answer2 = comparator.compare(200, 100);
        System.out.println(answer2);
        System.out.println("--------------------------");
        comparator = Integer::compare;
        Integer answer3 = comparator.compare(100, 100);
        System.out.println(answer3);
        System.out.println("--------------------------");
    }

    //函数型函数式接口Function<T, G>:apply(T t); 有参数[前者表示形式参数，后者表示返回值数据类型] + 有返回值
    //其实就是数学中的函数：y = x^2;
    public static void test4() {
        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        Integer answer = function.apply(32);
        System.out.println(answer);
        System.out.println("--------------------------");
        function = (Integer x) -> {
            return x * x;
        };
        answer = function.apply(64);
        System.out.println(answer);
        System.out.println("--------------------------");
        function = Math::abs;
        answer = function.apply(-100);
        System.out.println(answer);
        System.out.println("--------------------------");
    }

    //方法是非静态方法，还可以使用 类::非静态方法，如果第一个参数作为调用方法的对象去使用，则可以使用该种方法
    //比如String类中的compareTo方法：t1.compareToe(t2)，再比如：t1.equals(t1)皆是如此
    public static void test5() {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        Integer answer = comparator.compare("abc", "abe");
        System.out.println(answer);
        System.out.println("--------------------------");
        comparator = (String s1, String s2) -> s1.compareTo(s2);
        answer = comparator.compare("abd", "abe");
        System.out.println(answer);
        System.out.println("--------------------------");
        comparator = String::compareTo;
        answer = comparator.compare("abe", "abe");
        System.out.println(answer);
    }

    //t1.equals(t2)
    public static void test6() {
        System.out.println("--------------------------");
        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s1, String s2) {
                return s1.equals(s2);
            }
        };
        boolean predicate = biPredicate.test("abc", new String("abc"));
        System.out.println(predicate);
        System.out.println("--------------------------");
        biPredicate = (String s1, String s2) -> s1.equals(s2);
        predicate = biPredicate.test("abcdef", new String("abc"));
        System.out.println(predicate);
        System.out.println("--------------------------");
        biPredicate = String::equalsIgnoreCase;
        predicate = biPredicate.test("abcABC", new String("abcabc"));
        System.out.println(predicate);
    }
}

class HuLuWa {
    private String name;

    public HuLuWa() {
    }

    public HuLuWa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
