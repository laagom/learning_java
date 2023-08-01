package learning_java_synchronized.sec02_sychronizedmethod.EX04;

public class SynchronizedMethod_4 {

    /**
     * 인스턴스에 lock을 거는 synchronized 키워드는 synchroinzed가 적용된 메서드 끼리
     * 일괄적으로 lock을 공유하는지 확인
     * 
     * @param args
     * @throws InterruptedException
     */
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

        // 결과 : synchronized가 붙은 메서드는 일괄적으로 동기화 되어 하나의 객체에 접근이 불가하다.
        // thread1 lock
        // thread1 unlock
        // thread2 hello
    }
}

class MyThread {

    /**
     * synchronized 붙은 print 메서드
     * 
     * @param name
     */
    public synchronized void print(String name) {
        System.out.println(name + " hello");
    }

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