package Chapter05;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMethod {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        //添加元素
        collection.add(1);
        collection.add("aaa");
        collection.add(2);
        collection.add("bbb");
        System.out.println("collection add = " + collection);
        //添加多个元素
        collection.addAll(collection);
        System.out.println("collection addAll = " + collection);
        //删除某个具体元素
        collection.remove(1);
        System.out.println("collection remove = " + collection);
        //删除某个集合【若存在某个重复元素则会删除全部重复元素】
        Collection collection1 = new ArrayList();
        collection1.add("aaa");
        collection.removeAll(collection1);
        System.out.println("collection removeAll = " + collection);
        //查找某个元素
        boolean contains1 = collection.contains(2);
        boolean contains2 = collection.contains("aaa");
        System.out.println(contains1 + " " + contains2);
        //查找多个元素 --- 集合
        System.out.println("collection containsAll = " + collection.containsAll(collection1));
        Collection collection2 = new ArrayList();
        collection2.add(2);
        collection2.add("bbb");
        System.out.println("collection containsAll = " + collection.containsAll(collection2));
        //查找集合元素个数
        System.out.println("collection size = " + collection.size());
        //判断集合是否为空
        System.out.println("collection isEmpty = " + collection.isEmpty());
        //清空集合
        collection.clear();
        System.out.println("collection clear = " + collection);
    }
}
