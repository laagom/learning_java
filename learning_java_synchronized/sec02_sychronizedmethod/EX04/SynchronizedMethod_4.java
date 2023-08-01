package learning_java_synchronized.sec02_sychronizedmethod.EX04;

public class SynchronizedMethod_4 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(() -> {
            myThread.run("thread1");
        });

        Thread thread2 = new Thread(() -> {
            myThread.print("thread2");
        });

        thread1.start();
        Thread.sleep(500);
        thread2.start();
    }
}

class MyThread {

    public synchronized void print(String name) {
        System.out.println(name + "hello");
    }

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