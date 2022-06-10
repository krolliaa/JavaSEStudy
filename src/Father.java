public abstract class Father {
    public void method() {
        System.out.println("This is a Father method.");
    }

    public static void main(String[] args) {
        Father father = new Son();
        father.method();
    }
}

class Son extends Father {
}

interface Son1 {
    public static final int A = 1;

    public abstract int B();
}
