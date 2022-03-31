package Chapter03;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListCRUD {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        //添加节点
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("linkedList = " + linkedList);
        //删除节点
        linkedList.remove();
        System.out.println("linkedList = " + linkedList);
        //修改节点
        linkedList.set(1, 8);
        System.out.println("linkedList = " + linkedList);
        //获取某个位置的节点
        Object object = linkedList.get(1);
        System.out.println("linkedList get 1 = " + object);
        //LinkedList 实现了 List 接口，List 接口继承了 Collection 接口
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("next = " + obj);
        }
        for (Object o : linkedList) System.out.println("for++ = " + o);
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("for = " + linkedList.get(i));
        }
    }
}
