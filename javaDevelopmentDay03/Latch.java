package javaDevelopmentDay03;

import java.util.concurrent.CountDownLatch;

public class Latch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(6);
        ThreadUreticisi thread1 = new ThreadUreticisi(latch);
        ThreadUreticisi thread2 = new ThreadUreticisi(latch);
        ThreadUreticisi thread3 = new ThreadUreticisi(latch);
        ThreadUreticisi thread4 = new ThreadUreticisi(latch);
        ThreadUreticisi thread5 = new ThreadUreticisi(latch);
        ThreadUreticisi thread6 = new ThreadUreticisi(latch);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        try {
            latch.await();
            System.out.println("Latch in mudhale etmesini bekliyorum");
        } catch (InterruptedException e) {
            System.out.println("Thread olusumu tamamlandi, simdi benim siram");
        }
    }
}
class ThreadUreticisi extends Thread{
    private CountDownLatch latch;
    // Override Run Method
    @Override
    public void run() {
        System.out.println("Thread imiz calismaya basladi.." + Thread.currentThread().getName());
        System.out.println("thread i calismayi durdurdu..." + Thread.currentThread().getName());
        System.out.println("========================================");
    }

    public ThreadUreticisi(CountDownLatch latch) {
        this.latch = latch;
    }
}

