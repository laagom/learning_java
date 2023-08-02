package learning_java_synchronized.sec04_sychronizedblock.EX01;

public class SynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(() -> {
            myThread.run("thread1");
        });
        Thread thread2 = new Thread(() -> {
            myThread.run("thread2");
        });

        thread1.start();
        thread2.start();

        // 결과
        // thread1 lock
        // thread1 unlock
        // thread2 lock
        // thread2 unlock
    }
}

class MyThread {
    /**
     * synchronized를 메서드에 주는 방식 -> mehotd안을 block영역을 지정하여 synchronized 주는 방식으로 변경
     * => 블럭으로 주는 범위가 전체이기 때문에 현재는 메서드로 주는 것과 동일하게 작동한다.
     * 
     * @param name
     */
    public void run(String name) {
        synchronized (this) {
            System.out.println(name + " lock");
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + " unlock");
        }
    }
}