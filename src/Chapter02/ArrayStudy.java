package Chapter02;

import java.util.Arrays;

public class ArrayStudy {
    /*
        数组：
        声明数组的形式多种多样，可以使用 int[] a = new int[100];
        也可以声明一个匿名数组：new int[] = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
        长度为 0 的数组并不是说这个数组是 null，长度为 0 的数组还是有内存地址存在的
        数组拷贝：Arrays.copyOf(a) 拷贝出来的数组不指向同一个地址 ---> 会生成一个新的数组
        数组排序：Arrays.Sort(a) ---> 不会生成新的数组，对原来的数组进行排序
        数组转字符串：Arrays.toString(a)
        数组截取：Arrays.copyOf(a, start, end)
        设置元素：Arrays.fill(a, v)
        比较数组：Arrays.equals(a, b)
    */
    public static void main(String[] args) {
        int[] a = {16, 15, 14, 13, 12, 11, 10};
        int[] b = Arrays.copyOf(a, a.length);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("Arrays.copyOf() 采用该种方式拷贝将生成一个新的数组对象");
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.equals(a, b));
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        Arrays.fill(a, 1);
        System.out.println(Arrays.toString(a));
        b = a;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("直接赋值指向同一个对象");
    }
}
