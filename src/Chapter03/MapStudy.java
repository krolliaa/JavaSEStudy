package Chapter03;

import java.util.HashMap;
import java.util.Map;

public class MapStudy {
    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("no1", "逻辑");
        map.put("no2", "水滴");
        map.put("no1", "地球");
        map.put("no3", "三体");
        map.put(null, null);
        map.put(null, "碳中和");
        map.put("no4", null);
        map.put("no5", null);
        map.put(new Object(), "新能源");
        System.out.println(map.get("no1"));
        System.out.println(map.get("no2"));
        System.out.println(map.get("no3"));
        System.out.println(map.get("no4"));
        System.out.println(map.get("no5"));
        System.out.println(map.get(null));
        System.out.println(map);
    }
}
