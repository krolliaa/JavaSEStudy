package Chapter03;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("no1", "罗辑");
        System.out.println("put = " + map);
        boolean isMapEmpty = map.isEmpty();
        System.out.println("isEmpty = " + isMapEmpty);
        System.out.println("get = " + map.get("no1"));
        System.out.println("size = " + map.size());
        System.out.println("remove = " + map.remove("no1"));
        map.put("no1", "罗辑");
        System.out.println("clear before = " + map);
        map.clear();
        System.out.println("clear after = " + map);
        map.put("no1", "罗辑");
        System.out.println("containsKey = " + map.containsKey("no1"));
        System.out.println("containsKey = " + map.containsKey("no2"));
    }
}
