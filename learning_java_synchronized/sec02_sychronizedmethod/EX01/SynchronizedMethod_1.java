package learning_java_synchronized.sec02_sychronizedmethod.EX01;

public class SynchronizedMethod_1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(() -> {
            myThread.run("thread1");
        });
        Thread thread2 = new Thread(() -> {
            myThread.run("thread2");
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