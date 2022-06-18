package Chapter04;

public class WaitAndNotify {
    public static void main(String[] args) {
        WN wn = new WN();
        Thread t1 = new Thread(wn);
        Thread t2 = new Thread(wn);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}

class WN implements Runnable {

    private int i = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (++i <= 100) {
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}