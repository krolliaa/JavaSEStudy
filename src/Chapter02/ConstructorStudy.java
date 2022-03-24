package Chapter02;

public class ConstructorStudy {
    /*
        构造器：用于创建对象，创建对象正是通过调用构造器或者叫构造方法完成的，在构造器中可以完成对对象的一些初始化操作
        格式：[修饰符] 构造方法名(形式参数列表)
        注意：
        1.构造器名称需要与类名保持一致
        2.构造方法用来创建对象以及完成属性初始化操作
        3.构造方法不用写返回值类型，其返回值类型就是当前类的类型
        4.一个类可以定义多个构造器，这些构造器形成了之前学习的方法重载

        每个类会默认提供一个默认构造器：无参构造器，需要有参构造器需要自己手动加入，如果有了有参构造器那么就会默认不添加无参构造器，故需要自己添加
    */

    public ConstructorStudy() {

    }

    public ConstructorStudy(int a) {
        System.out.println(a);
    }
}