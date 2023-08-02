package learning_java_synchronized.sec05_staticsynchronizedblock.EX01;

public class StaticSynchronizedBlock {

    /**
     * static synchronized method 방식과 다르게 lock 객체를 지정하고 block범위를 지정하여 한정하기
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

        // 결과 :클래스 단위로 lock를 공유하는 점은 동일
        // thread1 lock
        // thread1 unlock
        // thread2 lock
        // thread2 unlock
    }
}

class MyThread {
    public static void run(String name) {
        // * static 메서드 안에서도 synchronized block사용할 수 있는데 이때 this와 같은 현재 객체를 가르키는 표현이 불가능
        synchronized (MyThread.class) {
            System.out.println(name + " lock");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " unlock");
        }
    }

}
