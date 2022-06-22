package Chapter08;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        HuLuWa huLuWa = new HuLuWa("金娃");
        Optional<HuLuWa> optionalHuLuWa1 = Optional.of(huLuWa);
        huLuWa = null;
        Optional<HuLuWa> optionalHuLuWa2 = Optional.ofNullable(huLuWa);
        System.out.println(huLuWa);
        HuLuWa huLuWa1 = optionalHuLuWa2.orElse(new HuLuWa("火娃"));//如果为空就新建一个火娃，降低了空指针异常的风险
        System.out.println(huLuWa1);
        if(optionalHuLuWa1.isPresent()) {
            System.out.println(optionalHuLuWa1.get());
        }
    }
}