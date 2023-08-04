package learning_java_stringbuildertest;

public class StringBuilderTest {
    public static void main(String[] args) {

        // # Runnable 상속 테스트
        // Runnable stringRunnable = new StringRunnable();
        // Runnable stringBuilderRunnable = new StringBuilderRunnable();

        // Thread stringThread = new Thread(stringRunnable);
        // Thread stringBuilderThread = new Thread(stringBuilderRunnable);

        // stringThread.start();
        // stringBuilderThread.start();

        // # 익명 함수 테스트
        // - String
        new Thread(() -> {
            String result = "";
            long start = System.currentTimeMillis();

            for (long i = 0; i < 100000; i++) {
                result += "test";
            }
            long end = System.currentTimeMillis();

            System.out.println("String exec time : " + (end - start));

        }).start();

        // - StringBuilder
        new Thread(() -> {
            StringBuilder result = new StringBuilder();
            long start = System.currentTimeMillis();

            for (long i = 0; i < 100000; i++) {
                result.append("test");
            }
            long end = System.currentTimeMillis();

            System.out.println("StringBuilder exec time : " + (end - start));
        }).start();

        // - StringBuffer
        new Thread(() -> {
            StringBuffer result = new StringBuffer();
            long start = System.currentTimeMillis();

            for (long i = 0; i < 100000; i++) {
                result.append("test");
            }
            long end = System.currentTimeMillis();

            System.out.println("StringBuffer exec time : " + (end - start));
        }).start();

        // 결과:
        // StringBuffer exec time : 11
        // StringBuilder exec time : 9
        // String exec time : 2244
    }
}

class StringRunnable implements Runnable {
    @Override
    public void run() {
        String result = "";
        long start = System.currentTimeMillis();

        for (long i = 0; i < 100000; i++) {
            result += "test";
        }
        long end = System.currentTimeMillis();

        System.out.println("String exec time : " + (end - start));
    }
}

class StringBuilderRunnable implements Runnable {
    @Override
    public void run() {
        StringBuilder result = new StringBuilder();
        long start = System.currentTimeMillis();

        for (long i = 0; i < 100000; i++) {
            result.append("test");
        }
        long end = System.currentTimeMillis();

        System.out.println("StringBuilder exec time : " + (end - start));
    }
}