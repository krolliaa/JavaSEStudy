package Chapter05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(1);
        list.add(1, 2);
        list.add(2, "aaa");
        list.add("aaa");
        list.add(3, "bbb");
        System.out.println("List add = " + list);
        System.out.println("List get = " + list.get(3));
        System.out.println("List indexOf = " + list.indexOf("aaa"));
        System.out.println("List lastIndexOf = " + list.lastIndexOf("aaa"));
        list.remove(4);
        list.remove("bbb");
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        list.removeAll(collection);
        System.out.println("List remove = " + list);
        list.set(0, 1);
        System.out.println("List set = " + list);
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        collection.clear();
        collection = list.subList(1, 3);//左闭右开
        System.out.println("List subList = " + collection);
    }
}
