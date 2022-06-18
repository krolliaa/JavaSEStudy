package Chapter04;

import java.util.concurrent.locks.ReentrantLock;

public class SaveMoney {
    public static void main(String[] args) {
        Account A = new Account();
        Account B = new Account();
        A.setName("张三");
        B.setName("李四");
        A.start();
        B.start();
    }
}

class Account extends Thread {

    private static int accountMoney = 0;
    private static int saveTime = 1;
    private static Object object = new Object();
    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                reentrantLock.lock();
                if (saveTime++ < 4) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    accountMoney += 1000;
                    System.out.println(Thread.currentThread().getName() + "存储了 1000 元，当前账户余额为：" + accountMoney + " 元");
                } else {
                    break;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
