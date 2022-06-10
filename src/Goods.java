import java.util.Arrays;
import java.util.Comparator;

public class Goods implements Comparable {
    private String name;
    private int price;

    public Goods() {
    }

    public Goods(String name, int price) {
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
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) return 1;
            else if (this.price < goods.price) return -1;
            else return this.name.compareTo(goods.name);
        }
        return 0;
    }
}

class GoodsTest {
    public static void main(String[] args) {
        Goods goods1 = new Goods("A", 96);
        Goods goods2 = new Goods("B", 100);
        Goods goods3 = new Goods("C", 98);
        Goods goods4 = new Goods("D", 99);
        Goods goods5 = new Goods("E", 97);
        Goods goods6 = new Goods("A", 97);
        Goods[] goods = new Goods[]{goods1, goods2, goods3, goods4, goods5, goods6};
        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));


        String[] strings = new String[]{"AA", "BB", "KK", "ZZ", "MM", "QQ", "DD"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(strings));

        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }
}
