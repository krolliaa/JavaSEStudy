package Chapter03;

public class Car {
    private static boolean run = true;

    static class Engine {
        public void runEngine() {
            //成员内部类可以调用外部类任意权限的方法或者属性，即使是private
            if (run) System.out.println("发动机启动");
            else System.out.println("发动机坏了");
        }
    }


    public static void main(String[] args) {
        Car car = new Car();
        Car.Engine carEngine = new Car.Engine();
        carEngine.runEngine();
    }
}
