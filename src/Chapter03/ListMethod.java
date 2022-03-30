package Chapter03;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        //1.1直接添加元素
        list.add("AAA");
        System.out.println("List add object = " + list);
        //1.2指定位置添加元素
        list.add(0, "BBB");
        System.out.println("List add index = " + list);
        //2.1获取某位置的元素
        Object object = list.get(0);
        System.out.println("List get = " + object);
        //2.2获取首次出现的元素位置
        list.add("AAA");
        int indexOf = list.indexOf("AAA");
        System.out.println("List indexOf = " + indexOf);
        //2.3末尾首次出现的元素位置
        int lastIndexOf = list.lastIndexOf("AAA");
        System.out.println("List last index of = " + lastIndexOf);
        //3.1直接移除元素
        boolean isRemoveOrNot = list.remove("AAA");
        System.out.println("List remove object = " + isRemoveOrNot);
        //3.2按照位置移除元素
        object = list.remove(0);
        System.out.println("List remove index = " + object);
        System.out.println("List = " + list);
        list.set(0, "super玛丽");
        System.out.println("List set index and object = " + list);
        list.add("愤怒小鸟");
        list.add("僵尸大战");
        List list1 = list.subList(0, 2);
        System.out.println("List subList = " + list1);
    }
}
