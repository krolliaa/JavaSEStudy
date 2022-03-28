package Chapter02;

public class ExceptionStudy {
    /*
        异常：在程序执行时出现的错误就叫做异常
        异常分类有三：一是错误即error，二是一般性异常也叫受控异常，三是非一般性异常也叫非受控异常
        错误[error]：应用程序出现了错误，只能重新启动应用，此类错误诸如：内存溢出OutOfMemoryError
        一般性异常[受控异常]：出现一般性异常也就是受控异常表示是可控制的它还有另外一个名字叫做编译异常，需要显示处理后才可以正常编译
        非一般性异常[非受控异常]：不是编译异常而是程序跑起来之后才发现的异常必须显式地处理才可以正常运行
        Object ---> Throwable ---> Error + Exception = Exception所有子类 + RunTimeException

        获取异常描述信息：getMessage()
        获取异常堆栈信息：printStackTrace()

        捕获异常：try...catch...finally，finally 是无论怎样都会运行的除非，除非 JVM 在 try 或者 catch 里头关闭了，
        使用 System.exit(-1); JVM 就会退出，finally 里的代码将不被执行
    */
    public static void main(String[] args) {
        int a = 100;
        int b = 10;
        try {
            a = a / b;
            System.exit(-1);
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace();
        } finally {
            System.out.println("执行 finally 中的代码");
        }
    }
}
