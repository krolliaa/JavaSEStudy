package Chapter03;

import java.util.*;

public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("no1", "罗辑");
        map.put("no2", "地球");
        map.put("no3", "三体");
        map.put("no4", "执剑人");
        map.put(null, null);
        //第一组：取出所有 key 然后获取相应的 value
        Set keySet = map.keySet();
        //(1) 增强 for 循环
        System.out.println("第一种：keySet ---> key ---> get(key)");
        for (Object key : keySet) {
            System.out.println(key + "-" + map.get(key));
        }
        //(2) 迭代器循环
        System.out.println("第二种：Iterator ---> key ---> get(key)");
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "-" + map.get(key));
        }

        //第二组：把所有的 values 取出
        //(1) 增强 for 循环
        Collection values = map.values();
        System.out.println("取出所有的 value 增强 for：");
        for (Object value : values) System.out.println(value);
        //(2) 迭代器
        System.out.println("取出所有的 value 迭代器：");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }

        //第三组：通过 entrySet 来获取 key-value 键值对
        Set entrySet = map.entrySet();
        //(1) 增强 for 循环
        System.out.println("使用 EntrySet 增强 for：");
        for (Object entry : entrySet) {
            Map.Entry mapEntry = (Map.Entry) entry;
            System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
        }
        //(2) 迭代器循环
        System.out.println("使用 EntrySet 迭代器：");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry = iterator2.next();
            Map.Entry mapEntry = (Map.Entry) entry;
            System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
        }
    }
}
