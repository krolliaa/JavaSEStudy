package Chapter04;

public class ProAndCon implements Runnable {

    private int productNum = 0;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (Thread.currentThread().getName().equals("生产者")) {
                    //如果是一个生产者则需要生产数据
                    //如果产品数量达到 20 生产者需要进入阻塞状态并唤醒消费者
                    if (productNum < 20) {
                        product();
                    } else {
                        this.notify();
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    //否则就是消费者，需要消费数据，但是需要确保产品数量大于 0
                    //否则需要唤醒生产者
                    if (productNum > 0) {
                        consume();
                    } else {
                        this.notify();
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    //生产者生产产品
    public void product() {
        System.out.println(Thread.currentThread().getName() + "生产产品：" + (++productNum));
    }

    //消费者消费产品
    public void consume() {
        System.out.println(Thread.currentThread().getName() + "消费产品：" + (productNum--));
    }
}

class ProConTest {
    public static void main(String[] args) {
        ProAndCon proAndCon = new ProAndCon();
        Thread producer = new Thread(proAndCon);
        Thread consumer = new Thread(proAndCon);
        producer.setName("生产者");
        consumer.setName("消费者");
        producer.start();
        consumer.start();
    }
}