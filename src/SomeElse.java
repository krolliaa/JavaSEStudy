public class SomeElse {
    public static void main(String[] args) {
        System.out.println(method());
    }

    public static int method() {
        try {
            return 1/0;
        } catch (Exception exception) {
            return 0;
        } finally {
            System.out.println("这是 finally 就算 try catch 有 return 也是必定会执行的！");
        }
    }
}
