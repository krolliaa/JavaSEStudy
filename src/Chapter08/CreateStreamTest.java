package Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        //1.通过集合创建流 Stream
        Stream stream1 = arrayList.stream();//返回一个顺序流
        Stream stream2 = arrayList.parallelStream();//返回一个顺序流
        //2.通过数组创建流 Stream
        int[] array1 = {1, 2, 3, 4, 5, 6};
        IntStream intStream = Arrays.stream(array1);
        String[] array2 = {"1", "2", "3"};
        Stream<String> stream = Arrays.stream(array2);
        //3.通过Stream.of()创建流 Stream
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5, 6);//放入的是包装类
        //4.创建无限流 ---> 无限元素
        Stream.iterate(0, x -> 2 + x).limit(10).forEach(System.out::println);
        //  生成无限流 ---> 无限元素
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
