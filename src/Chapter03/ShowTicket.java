package Chapter03;

import java.util.concurrent.locks.ReentrantLock;

public class ShowTicket extends Thread {
    public static void main(String[] args) {
        IST ist = new IST();
        Thread st1 = new Thread(ist);
        Thread st2 = new Thread(ist);
        Thread st3 = new Thread(ist);
        st1.setName("售票窗口1");
        st2.setName("售票窗口2");
        st3.setName("售票窗口3");
        st1.start();
        st2.start();
        st3.start();
    }
}

class ST extends Thread {
    private static int ticket = 100;

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            //实例方法可以调用静态方法，因为静态早在类加载的时候就加载了，但是静态方法不可以调用实例方法
            //show();
            try {
                reentrantLock.lock();

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 售出票号： " + ticket);
                    ticket--;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    //加了 static 相当于锁为：ST.class
    private static synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 售出票号： " + ticket);
            ticket--;
        }
    }
}

class IST implements Runnable {

    private int ticket = 100;

    private ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                reentrantLock.lock();

                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + " 售出票号： " + ticket);
                    ticket--;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}