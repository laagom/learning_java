package learning_java_synchronized.sec02_synchronizedmethod.EX01;

public class SynchronizedMethod_1 {
    /**
     * run 메서드를 동기화 처리 후 서로 다른 쓰레드로 접근 확인
     * 
     * @param args
     */
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

        // 결과 : 하나의 쓰레드가 다른 쓰레드의 접근을 lock하기 때문에 차례대로 출력
        // thread1 lock
        // thread1 unlock
        // thread2 lock
        // thread2 unlock
    }
}

class MyThread {
    /**
     * synchronized 붙은 run 메서드
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