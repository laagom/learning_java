package learning_java_synchronized.sec04_sychronizedblock.EX01;

public class SynchronizedNoneBlock {
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

        // 결과
        // thread1 lock
        // thread2 lock
        // thread1 unlock
        // thread2 unlock
    }
}

class MyThread {
    public void run(String name) {
        synchronized (this) {
            System.out.println(name + " lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}