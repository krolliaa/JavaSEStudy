package Chapter08;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorQuote {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    //Supplier:get() return T t;
    public static void test1() {
        Supplier<HuLuWa> supplier = new Supplier<HuLuWa>() {
            @Override
            public HuLuWa get() {
                return new HuLuWa("小葫芦娃");
            }
        };
        HuLuWa littleHuLuWa = supplier.get();
        System.out.println(littleHuLuWa.toString());
        System.out.println("--------------------------");
        supplier = () -> new HuLuWa("中葫芦娃");
        HuLuWa middleHuLuWa = supplier.get();
        System.out.println(middleHuLuWa.toString());
        System.out.println("--------------------------");
        supplier = HuLuWa::new;
        HuLuWa bigHuLuWa = supplier.get();
        bigHuLuWa.setName("大葫芦娃");
        System.out.println(bigHuLuWa.toString());
        System.out.println("--------------------------");
    }

    //Function:apply(T t) return G g;
    public static void test2() {
        Function<String, HuLuWa> function = new Function<String, HuLuWa>() {
            @Override
            public HuLuWa apply(String s) {
                return new HuLuWa(s);
            }
        };
        HuLuWa goldWa = function.apply("金娃");
        System.out.println(goldWa);
        System.out.println("--------------------------");
        function = (String name) -> new HuLuWa(name);
        HuLuWa treeWa = function.apply("木娃");
        System.out.println(treeWa);
        System.out.println("--------------------------");
        function = HuLuWa::new;
        HuLuWa waterWa = function.apply("水娃");
        System.out.println(waterWa);
        System.out.println("--------------------------");
    }

    //BiFunction:apply(T t, G g) return U u;
    public static void test3() {
        BiFunction<String, Integer, FiveField> biFunction = new BiFunction<String, Integer, FiveField>() {
            @Override
            public FiveField apply(String name, Integer power) {
                return new FiveField(name, power);
            }
        };
        FiveField fiveField = biFunction.apply("金", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = (String name, Integer power) -> new FiveField(name, power);
        fiveField = biFunction.apply("木", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = FiveField::new;
        fiveField = biFunction.apply("水", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = FiveField::new;
        fiveField = biFunction.apply("火", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
        biFunction = FiveField::new;
        fiveField = biFunction.apply("土", 8);
        System.out.println(fiveField);
        System.out.println("--------------------------");
    }
}

class FiveField {
    private String name;
    private Integer power;

    public FiveField() {
    }

    public FiveField(String name, Integer power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return name + " : 能量值 : " + power;
    }
}
