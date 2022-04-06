package Chapter03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsStudy {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("D");
        list.add("E");
        list.add("A");
        list.add("B");
        //1.将 list 反转
        Collections.reverse(list);
        System.out.println(list);
        //2.将 list 随机排序
        Collections.shuffle(list);
        System.out.println(list);
        //3.将 list 进行正序排序
        Collections.sort(list);
        System.out.println(list);
        //4.将 list 按照 Comparator 进行排序[倒叙]
        Collections.sort(list, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o2).compareTo((String) o1);
            }
        });
        System.out.println(list);
        //5.指定 list 交换 i 跟 j 位置上的元素
        Collections.swap(list, 0, 1);
        System.out.println(list);
    }
}
