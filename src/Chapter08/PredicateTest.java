package Chapter08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("北京");
        arrayList.add("天津");
        arrayList.add("南京");
        arrayList.add("上金");
        arrayList.add("西京");
        arrayList.add("夏津");
        arrayList.add("东京");
        //1.传统的使用匿名函数的方式完成过滤
        ArrayList<String> newArrayList = getPredicateArrayList(arrayList, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(newArrayList);
        //2.使用 Lambda 表达式的方式完成过滤
        ArrayList<String> newLambdaArrayList = getPredicateArrayList(arrayList, str -> str.contains("京"));
        System.out.println(newLambdaArrayList);
    }

    public static ArrayList<String> getPredicateArrayList(ArrayList<String> arrayList, Predicate<String> predicate) {
        ArrayList<String> newArrayList = new ArrayList<String>();
        for (String str : arrayList) {
            if (predicate.test(str)) newArrayList.add(str);
        }
        return newArrayList;
    }
}
