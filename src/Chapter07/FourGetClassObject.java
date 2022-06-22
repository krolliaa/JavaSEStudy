package Chapter07;

public class FourGetClassObject {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.通过类本身的属性获取运行时类对象
        Class personClass1 = Person.class;
        System.out.println(personClass1);
        //2.通过类对象的 getClass() 方法获取运行时类对象
        Class personClass2 = new Person().getClass();
        System.out.println(personClass2);
        //3.通过 Class 运行时类的 forName(String className) 静态方法获取运行时类对象
        Class personClass3 = Class.forName("Chapter07.Person");
        System.out.println(personClass3);
        //4.通过 ClassLoader 类加载器获取运行时类对象
        ClassLoader classLoader = FourGetClassObject.class.getClassLoader();
        Class personClass4 = classLoader.loadClass("Chapter07.Person");
        System.out.println(personClass4);
        //不管通过什么方式，运行时类在堆内存中只有一个，所以所有运行时类对象变量都指向同一个堆内存地址
        System.out.println(personClass1 == personClass2);
        System.out.println(personClass1 == personClass3);
        System.out.println(personClass1 == personClass4);
    }
}
