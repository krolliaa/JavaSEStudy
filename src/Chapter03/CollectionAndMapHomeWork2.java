package Chapter03;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionAndMapHomeWork2 {
    public static void main(String[] args) {
        ArrayList<GreatCar> greatCars = new ArrayList<GreatCar>();
        GreatCar car1 = new GreatCar("宝马", 400000);
        GreatCar car2 = new GreatCar("奔驰", 800000);
        GreatCar car3 = new GreatCar("宾利", 5000000);
        //1.add:添加元素
        greatCars.add(car1);
        greatCars.add(car2);
        greatCars.add(car3);
        System.out.println("GreatCars add = " + greatCars);
        //2.remove:删除元素
        greatCars.remove(car1);
        System.out.println("GreatCars remove = " + greatCars);
        //3.contains:元素是否存在
        System.out.println("GreatCars contains = " + greatCars.contains(car1));
        System.out.println("GreatCars contains = " + greatCars.contains(car2));
        System.out.println("GreatCars contains = " + greatCars.contains(car3));
        //4.size:集合个数
        System.out.println("GreatCars size = " + greatCars.size());
        //5.isEmpty:集合是否为空
        System.out.println("GreatCars isEmpty = " + greatCars.isEmpty());
        //6.clear:清空集合元素
        greatCars.clear();
        System.out.println("GreatCars clear = " + greatCars.isEmpty());
        greatCars.add(car1);
        greatCars.add(car2);
        greatCars.add(car3);
        //7.addAll:添加多个元素
        greatCars.addAll(greatCars);
        System.out.println("GreatCars addAll = " + greatCars.size() + " = " + greatCars);
        //8.containsAll:包含多个元素
        System.out.println("GreatCars containsAll = " + greatCars.containsAll(greatCars));
        //9.removeAll:删除多个元素
        greatCars.removeAll(greatCars);
        System.out.println("GreatCars removeAll = " + greatCars);
        greatCars.add(car1);
        greatCars.add(car2);
        greatCars.add(car3);
        //10.三种方式遍历
        for (int i = 0; i < greatCars.size(); i++) {
            System.out.println("Great Car = " + greatCars.get(i).getName() + ":" + greatCars.get(i).getPrice());
        }
        for (GreatCar greatCar : greatCars) {
            System.out.println("Great Car = " + greatCar.getName() + ":" + greatCar.getPrice());
        }
        Iterator iterator = greatCars.iterator();
        while (iterator.hasNext()) {
            GreatCar greatCar = (GreatCar) iterator.next();
            System.out.println("Great Car = " + greatCar.getName() + ":" + greatCar.getPrice());
        }
    }
}

class GreatCar {
    private String name;
    private int price;

    public GreatCar(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GreatCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}