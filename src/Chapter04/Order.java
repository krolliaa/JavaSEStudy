package Chapter04;

public class Order<T> {
    String name;
    T orderT;

    public Order() {
    }

    public Order(String name, T orderT) {
        this.name = name;
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderT=" + orderT +
                '}';
    }
}

class TestOrder {
    public static void main(String[] args) {
        Order<String> order = new Order<String>("张三", "历史");
        System.out.println(order.toString());
    }
}
