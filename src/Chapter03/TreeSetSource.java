package Chapter03;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetSource {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //根据字符串的长度进行排序
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("abc");
        System.out.println("treeSet = " + treeSet);
    }
}
