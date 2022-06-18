package Chapter05;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection collection = new LinkedList();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        collection.add("ddd");
        collection.add("eee");
        collection.add("fff");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
