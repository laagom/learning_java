package sec03_threadproperties.EX03;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(this.getName() + " : " + (this.isDaemon() ? "데몬쓰레드" : "일반쓰레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(this.getName() + " : " + i + "초");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadProperties_3_1 {
    public static void main(String[] args) {

        // #1 일반쓰레드
        Thread thread1 = new MyThread();
        thread1.setDaemon(false);
        thread1.setName("thread1");
        thread1.start();

        // #2 데몬쓰레드
        // Thread thread2 = new MyThread();
        // thread2.setDaemon(true);
        // thread2.setName("thread2");
        // thread2.start();

        // #3 3초후 main Thread 종료
        try {
            Thread.sleep(3100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main Thread 종료");
    }
}
