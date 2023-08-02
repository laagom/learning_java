package learning_java_synchronized.sec04_sychronizedblock.EX02;

/**
 * 인스턴스 단위 lock / block 한 lock의 공유 유무 확인
 */
public class SynchronizedSeperatelyBlock {
    public static void main(String[] args) {
        MyThreadA myThreadA = new MyThreadA();
        Thread thread1 = new Thread(() -> {
            myThreadA.run("thread1");
        });
        Thread thread2 = new Thread(() -> {
            myThreadA.run("thread2");
        });
        Thread thread3 = new Thread(() -> {
            myThreadA.print("자원 B와 관련 없는 thread3");
        });

        thread1.start();
        thread2.start();
        thread3.start();

        // 결과 1 : 결과적으로 인스턴스 단위 lock과 B를 block한 lock은 공유되지 않고 별도로 관리되는 것을 확인
        // thread1 lock
        // MyThread B lock
        // 자원 B와 관련 없는 thread3 hello
        // MyThread B unlock
        // thread1 unlock
        // thread2 lock
        // MyThread B lock
        // MyThread B unlock
        // thread2 unlock

        // 결과 2
        // thread1 lock
        // 자원 B와 관련 없는 thread3 hello
        // MyThread B lock
        // MyThread B unlock
        // thread1 unlock
        // thread2 lock
        // MyThread B lock
        // MyThread B unlock
        // thread2 unlock
    }
}

class MyThreadA {
    MyThreadB myThreadB = new MyThreadB();

    public void run(String name) {
        synchronized (myThreadB) {
            System.out.println(name + " lock");
            myThreadB.run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " unlock");
        }
    }

    public synchronized void print(String name) {
        System.out.println(name + " hello");
    }
}

class MyThreadB extends Thread {

    @Override
    public synchronized void run() {
        System.out.println("MyThread B lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread B unlock");
    }
}
