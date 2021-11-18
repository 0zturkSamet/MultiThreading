package javaDevelopmentDay03;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        ThreadCreater thread1 = new ThreadCreater("Thread-1");
        ThreadCreater thread2 = new ThreadCreater("Thread-2");
        ThreadCreater thread3 = new ThreadCreater("Thread-3");
        ThreadCreater thread4 = new ThreadCreater("Thread-4");
        ThreadCreater thread5 = new ThreadCreater("Thread-5");
        ThreadCreater thread6 = new ThreadCreater("Thread-6");
        ThreadCreater thread7 = new ThreadCreater("Thread-7");
        ThreadCreater thread8 = new ThreadCreater("Thread-8");
        ThreadCreater thread9 = new ThreadCreater("Thread-9");
        ThreadCreater thread10 = new ThreadCreater("Thread-10");

        //thread1.start();
        //thread2.start();
        //thread3.start();
        //thread4.start();
        //thread5.start();
        //thread6.start();
        //thread7.start();
        //thread8.start();
        //thread9.start();
        //thread10.start();
        executorService.execute(thread1);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        executorService.execute(thread5);
        executorService.execute(thread6);
        executorService.execute(thread7);
        executorService.execute(thread8);
        executorService.execute(thread9);
        executorService.execute(thread10);

    }
}

class ThreadCreater extends Thread{
    private String threadName;
    // Override Run Method
    @Override
    public void run() {
        System.out.println(threadName + "Thread imiz calismaya basladi..");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadName + "thread i calismayi durdurdu...");
    }

    public ThreadCreater(String threadName) {
        this.threadName = threadName;
    }
}

