package Chapter08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ShutdownStreamTest {
    public static void main(String[] args) {
        //1.匹配与查找
        List<Integer> list = Arrays.asList(100, 88, 23, 989, 652, 735, 412, 399);
        System.out.println(list.stream().allMatch(x -> x > 10));
        System.out.println(list.stream().anyMatch(x -> x > 100));
        System.out.println(list.stream().noneMatch(x -> x > 1000));
        System.out.println(list.stream().findFirst());
        System.out.println(list.stream().findAny());
        System.out.println(list.stream().count());
        System.out.println(list.stream().max(Integer::compare));
        System.out.println(list.stream().min(Integer::compare));
        list.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
        //2.规约
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list1.stream().reduce(0, Integer::sum));//第一个参数一相当于一个初始值
        //3.收集
        List<Integer> list2 = list.stream().filter(x -> x > 600).collect(Collectors.toList());
        System.out.println(list2);
    }
}
