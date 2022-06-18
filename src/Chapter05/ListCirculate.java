package Chapter05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCirculate {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("青椒炒肉");
        list.add("宫保鸡丁");
        list.add("鱼香肉丝");
        list.add("北京烤鸭");
        list.add("麻婆豆腐");
        //普通 for 循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("-------");
        //增强 for 循环
        for (Object food : list) {
            System.out.println(food);
        }
        System.out.println("-------");
        //迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
