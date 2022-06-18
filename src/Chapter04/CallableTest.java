package Chapter04;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest implements Callable {

    private int i = 1;

    @Override
    public Object call() throws Exception {
        int sum = 0;
        while (true) {
            if (i <= 100) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                sum += i++;
            } else {
                break;
            }
        }
        return sum;
    }
}

class CTest {
    public static void main(String[] args) {
        CallableTest callableTest = new CallableTest();
        FutureTask futureTask = new FutureTask(callableTest);
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        try {
            Object sum = futureTask.get();
            System.out.println("输出的总和为：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
