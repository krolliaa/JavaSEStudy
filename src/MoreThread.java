public class MoreThread extends Thread {
    public static void main(String[] args) {
        MyThread3 myThread3 = new MyThread3();
        Thread thread = new Thread(myThread3);
        thread.start();
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}

class MyThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + " = " + i);
        }
    }
}