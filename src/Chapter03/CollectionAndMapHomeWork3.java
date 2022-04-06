package Chapter03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class CollectionAndMapHomeWork3 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        //1.HashMap 添加元素
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println("hashMap put = " + hashMap);
        //2.HashMap 修改元素
        hashMap.put("jack", 2600);
        System.out.println("hashMap put = " + hashMap);
        //3.HashMap Integer 添加 100
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            hashMap.put((String) key, hashMap.get(key) + 100);
        }
        System.out.println("hashMap put = " + hashMap);
        //4.遍历集合中所有的员工
        for (Object key : keySet) {
            System.out.println("hashMap key = " + key);
        }
        //5.遍历集合中所以有的工资
        Collection collection = hashMap.values();
        for (Object salary : collection) {
            System.out.println("hashMap value = " + salary);
        }
    }
}