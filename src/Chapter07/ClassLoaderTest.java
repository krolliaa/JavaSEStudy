package Chapter07;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(systemClassLoader);
        System.out.println(systemClassLoader.getParent());
        System.out.println(systemClassLoader.getParent().getParent());
    }
}
