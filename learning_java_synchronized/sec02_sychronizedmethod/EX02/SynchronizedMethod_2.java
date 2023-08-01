package learning_java_synchronized.sec02_sychronizedmethod.EX02;

public class SynchronizedMethod_2 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        Thread thread1 = new Thread(() -> {
            myThread1.run("thread1");
        });

        Thread thread2 = new Thread(() -> {
            myThread2.run("thread2");
        });

        thread1.start();
        thread2.start();
    }
}

class MyThread {
    public synchronized void run(String name) {
        System.out.println(name + " lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " unlock");
    }
}
