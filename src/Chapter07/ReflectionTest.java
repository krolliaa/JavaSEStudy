package Chapter07;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        //反射之前可以对 Person 类做的事情 ---> 公共的 ---> 无法调用私有物品
        Person person = new Person("张三", 1000);
        person.age = 102;
        System.out.println(person.toString());
        person.show();
        //反射之后可以做的事情 ---> 获取所有的类内部信息
        //1.通过反射获取构造器 Constructor ---> 私有需使用 setAccessible(boolean flag);
        Class personClass = person.getClass();
        Constructor constructor = personClass.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        Person personObject = (Person) constructor.newInstance("李四", 108);
        System.out.println(personObject.toString());
        //2.通过反射获取类的属性、方法 Field Method ---> 私有需使用 setAccessible(boolean flag); 设置为 true 才可以修改，否则报 IllegalAccessException
        Field personField = personClass.getDeclaredField("name");
        personField.setAccessible(true);
        personField.set(personObject, "liSi");
        System.out.println(personObject.toString());
        Method personMethod = personClass.getDeclaredMethod("showNation", String.class);
        personMethod.setAccessible(true);
        Object methodObject = personMethod.invoke(personObject, "中国");
        System.out.println(methodObject);
    }
}
