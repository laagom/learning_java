package learning_java_synchronized.sec02_sychronizedmethod.EX02;

public class SynchronizedMethod_2 {
    /**
     * run 메서드를 동기화 처리 후 서로 다른 인스턴스와 쓰레드로 접근 확인
     * 
     * @param args
     */
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

        // 결과 : 각 쓰레드가 서로 다른 인스턴스에 접근하기 때문에 lock을 공유하지 않아 동시에 출력
        // thread1 lock
        // thread2 lock
        // thread2 unlock
        // thread1 unlock
    }
}

class MyThread {
    /**
     * synchronized가 붙은 run 메서드
     * 
     * @param name
     */
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
