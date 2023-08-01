package learning_java_synchronized.sec03_staticsynchronizedmethod.EX01;

public class StaticSychronizedMethod {
    /**
     * synchronized 동기화시킨 메서드에 static을 붙이면 클래스 단위로 lock이 걸리는지 확인
     * 
     * @param args
     */
    public static void main(String[] args) {

        // 각기 다른 인스턴스로 Thread 객체 생성
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

        // 결과 : 다른 인스턴스라도 static 메서드에 synchronized가 붙은 경우 lock을 공유한다.
        // thread1 lock
        // thread1 unlock
        // thread2 lock
        // thread2 unlock
    }
}

class MyThread {

    /**
     * static synchronized method 형
     * static 성질을 가지는 동기화 함수
     * 
     * @param name
     */
    public static synchronized void run(String name) {
        System.out.println(name + " lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " unlock");
    }
}