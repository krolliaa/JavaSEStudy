package Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class MiddleStreamTest {
    public static void main(String[] args) {
        String[] huLuWas = new String[]{"金娃", "木娃", "水娃", "火娃", "土娃", "金娃", "金娃", "金娃", "金娃"};
        Stream<String> huLuWaStream = Arrays.stream(huLuWas);
        //1.筛选与切片
        //（1）过滤 filter(Predicate predicate)：从流中排除某些符合特定条件的元素
        huLuWaStream.filter((String str) -> str.contains("金")).forEach(System.out::print);
        System.out.println();
        //因为这里已经执行了终止操作，是无法回到中间操作的。所以这里会报错。
        //（2）截断 limit(n)：使其元素不超过给定数量
        huLuWaStream = Arrays.stream(huLuWas);
        huLuWaStream.limit(3).forEach(System.out::print);
        System.out.println();
        //（3）跳过 skip(n)：返回一个扔掉了前 n 个元素的流
        huLuWaStream = Arrays.stream(huLuWas);
        huLuWaStream.skip(3).forEach(System.out::print);
        System.out.println();
        //（4）筛选 distinct()：去除重复元素
        huLuWaStream = Arrays.stream(huLuWas);
        huLuWaStream.distinct().forEach(System.out::print);
        System.out.println();
        //--------------------------------------------------------------------
        //2.映射
        //（1） map：接受一个函数作为参数，将元素转换成其他形式或提取信息
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::print);
        System.out.println();
        list = Arrays.asList("aaa", "b", "ccccc", "dddddddddd");
        list.stream().map(str -> str.length() > 6 ? str : "").forEach(System.out::print);
        System.out.println();
        //（2） flatMap：接受一个函数作为参数，将流中的每个值转换成另外一个流
        //--------------------------------------------------------------------
        //3.排序
        List<Integer> list1 = Arrays.asList(100, 88, 23, 989, 652, 735, 412, 399);
        //（1） sorted()：产生一个新流，按照自然顺序排序
        list1.stream().sorted().forEach(System.out::print);
        System.out.println();
        //（2） sorted(Comparator com)：产生一个新流，按照自定义顺序排序
        list1.stream().sorted((Integer o1, Integer o2) -> -(Integer.compare(o1, o2))).forEach(System.out::print);
    }
}
