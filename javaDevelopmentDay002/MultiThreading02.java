package javaDevelopmentDay002;

public class MultiThreading02 {
    public static int counter = 0;
    public static void main(String[] args){
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("thread1 tamamlandi...");
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Counter.count();
                System.out.println("thread2 tamamlandi...");
            }
        });
        thread2.start();
    }
}
class Counter{ // Counter = Sayıcı
    synchronized public static void count() {
        for(int i=1; i<=1000; i++) {
            MultiThreading02.counter++;
        }
        System.out.println("Counter: " + MultiThreading02.counter);
    }
}