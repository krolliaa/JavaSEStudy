package Chapter04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new ThreadRunnable1());
        executorService.execute(new ThreadRunnable2());
        //executorService.submit();//适用于Callable方法
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        threadPoolExecutor.setCorePoolSize(10);//设置核心池的大小
        threadPoolExecutor.setMaximumPoolSize(10);//设置最大连接线程数量
        //threadPoolExecutor.setKeepAliveTime();//设置线程最长连接时间
        executorService.shutdown();
    }
}

class ThreadRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class ThreadRunnable2 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}