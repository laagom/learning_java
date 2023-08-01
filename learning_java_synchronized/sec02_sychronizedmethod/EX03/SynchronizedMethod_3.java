package learning_java_synchronized.sec02_sychronizedmethod.EX03;

public class SynchronizedMethod_3 {
    /**
     * 인스턴스 접근 자체에 lock이 걸리는지 테스트
     * synchronized가 붙은 run 메서드와 붙지 않은 print 메서드를 동일한 객체로 각기 다른 쓰레드 동작 확인
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

        // 결과 : 하나의 객체에 synchronized가 붙은 메서드가 존재한다 해도 객체 자체에 접근이 불가한 것은 아니다.
        // thread1 lock
        // thread2 hello
        // thread1 unlock
    }
}

class MyThread {

    /**
     * 일반 print 메서드
     * 
     * @param name
     */
    public void print(String name) {
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