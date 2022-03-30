package Chapter03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListCirculate {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("青椒炒肉");
        list.add("宫保鸡丁");
        list.add("鱼香肉丝");
        list.add("北京烤鸭");
        list.add("麻婆豆腐");
        //1.Iterator 遍历
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            System.out.println("菜单 iterator：" + object);
        }
        //2.增强 for 遍历方式
        for (Object object : list) {
            System.out.println("菜单增强 for：" + object);
        }
        //3.普通 for 遍历方式
        for (int i = 0; i < list.size(); i++) {
            Object object = list.get(i);
            System.out.println("菜单普通 for：" + object);
        }
    }
}
