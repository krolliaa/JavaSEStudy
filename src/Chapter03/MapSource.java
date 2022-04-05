package Chapter03;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap<>();
        hashMap.put("no1", "罗辑");
        hashMap.put("no2", "三体");
        Set set = hashMap.entrySet();
    }
}
