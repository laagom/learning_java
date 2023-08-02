package learning_java_synchronized.sec06_synchronizedorder.EX01;

public class SynchronizedOrder {
    /**
     * synchronized를 통해 lock을 물고 있을 때 여러 개의 스레드가 접근 요청을 한다면
     * 이후의 lock이 풀리고 나서 접근한 순서대로 스레드가 실행되는지 확인
     * 
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();

        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            final int idx = i;
            threads[i] = new Thread(() -> {
                myThread.run("thread" + idx);
            });
        }

        for (Thread thread : threads) {
            thread.start();
            Thread.sleep(100);
        }

        // 결과 : 첫 번째 0이 진입한 이후에는 동기화 순서가 보장되지 않는 것을 확인 할 수 있음
        // thread0 lock
        // thread0 unlock
        // thread4 lock
        // thread4 unlock
        // thread3 lock
        // thread3 unlock
        // thread2 lock
        // thread2 unlock
        // thread1 lock
        // thread1 unlock
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