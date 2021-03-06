package Chapter02;

public class AboutAbstract {
    /*
        abstract：修饰类表示抽象类，修饰方法表示抽象方法
        1.抽象方法在抽象类之内，没有抽象类就没有抽象方法，所以有抽象方法的类必定是一个抽象类
        2.抽象方法只需要在抽象类中提供声明即可，抽象方法是不需要在抽象类中直接实现的
        3.抽象类天生需要被重写才有意义，你可以把抽象类看成是一个骨架，但是里面是没有肉的，所以继承后必须重写才能实现当然也可以不重写，但是这个子类必须是一个抽象类
        4.抽象类无法被实例化，因为它是抽象的，就像有个“食物”抽象类，你无法直接实例化它
        5.抽象方法和抽象类不能被final修饰，因为被final修饰的表示这个东西是完美无缺的，不需要被重写，但是抽象方法天生就是要被重写的，因矛盾冲突无法被修饰
        6.抽象类不一定就只有抽象方法，允许抽象类拥有被实现的方法
    */
}
