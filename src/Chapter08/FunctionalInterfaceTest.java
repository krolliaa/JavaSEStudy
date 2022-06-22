package Chapter08;

import java.util.function.Consumer;

public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        happyTime(100000.8988, new Consumer<Double>() {
            @Override
            public void accept(Double money) {
                System.out.println("代号白金刺客消费：" + money + "元");
            }
        });
        happyTime(100000.9899, (Double money) -> System.out.println("代号黄金刺客消费：" + money + "元"));
    }

    public static void happyTime(Double price, Consumer<Double> consumer) {
        consumer.accept(price);
    }
}
