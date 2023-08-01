package sec03_threadproperties.EX01;

//Thread 객체 가져오기 /이름 설정 / 쓰레드 수
public class ThreadProperties_1 {
    public static void main(String[] args) {

        // #1 객체 가져오기 (currentThread()) / 쓰레드 수 (acticeCount())
        Thread curThread = Thread.currentThread();
        System.out.println("현재 쓰레드 이름 = " + curThread.getName());
        System.out.println("동작하는 쓰레드 수 = " + Thread.activeCount());

        // #2 쓰레드 이름 지정 (자동지정)
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        // #3 쓰레드 이름 지정 (직접지정)
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread();
            thread.setName(i + "번째 쓰레드");
            System.out.println(thread.getName());
            thread.start();
        }

        // #4 쓰레드 이름 지정 (자동지정)
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread();
            System.out.println(thread.getName());
            thread.start();
        }

        // #5 쓰레드 수
        System.out.println("현재 동작하는 쓰레드 수 = " + Thread.activeCount());

    }
}
