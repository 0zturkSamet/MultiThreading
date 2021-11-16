package javaDevelopmentDay03;

public class WaitInterrupt {
    static public double bakiye = 0;
    public static void main(String[] args) {
        WaitInterrupt obj = new WaitInterrupt();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                obj.paracekme(800);
            }
        });
        //thread1.setName("thread1");
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.parayatirma(2000);
                thread1.interrupt();
            }
        });
        //thread2.setName("thread2");
        thread2.start();
    }
    public void paracekme(double miktar) {
        synchronized (this) {
            if (bakiye <= 0 || bakiye < miktar) {
                try {
                    System.out.println("hesaba para yatirilmasi gerekiyor...");
                    wait();
                } catch (InterruptedException e) {
                    bakiye = bakiye - miktar;
                    System.out.println("Para cekme basarili.\n Guncel bakiyemiz: " + bakiye);
                }
            }
        }
    }
    public void parayatirma(double miktar){
        bakiye = bakiye + miktar;
        System.out.println("Bakiyemiz guncellendi.\nGuncel bakiyemiz: " + bakiye);
    }
}