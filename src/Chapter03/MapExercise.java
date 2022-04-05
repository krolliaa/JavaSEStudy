package Chapter03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new NewEmployee("zs", 20000, 1));
        map.put(2, new NewEmployee("ls", 17000, 2));
        map.put(3, new NewEmployee("ww", 21000, 3));
        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            Map.Entry mapEntry = (Map.Entry) entry;
            NewEmployee newEmployee = (NewEmployee) mapEntry.getValue();
            if (newEmployee.salary > 18000) {
                System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
            }
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();
            NewEmployee newEmployee = (NewEmployee) mapEntry.getValue();
            if (newEmployee.salary > 18000) {
                System.out.println(mapEntry.getKey() + "-" + mapEntry.getValue());
            }
        }
        Set keySet = map.keySet();
        for (Object key : keySet) {
            NewEmployee newEmployee = (NewEmployee) map.get(key);
            if (newEmployee.salary > 18000) {
                System.out.println(key + "-" + map.get(key));
            }
        }
    }
}

class NewEmployee {
    public String name;
    public double salary;
    public int id;

    public NewEmployee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "NewEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
