package sec02_createandstartthread.EX05;

/*
 * 자식클래스를 만들어 Thread 또는 Runnable을 상속받아
 * run() 메소드를 구현해야 사용하는 Thread 구현 방식을 피하며
 * 한번만 사용하고 끝낼 수 있는 익명함수를 사용하여 Thread를 구현한다.
 */
public class CreateAndStartThread_M2C3 {
    public static void main(String[] args) {
        // Thread 객체 생성
        // 자막 번호
        Thread smiThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // #2 자막 번호 하나~다섯
                String[] video_subtitles = { "하나", "둘", "셋", "넷", "다섯" };
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // #4 자막 번호 출력
                for (String subtitle : video_subtitles) {
                    System.out.println(" - (자막 번호) " + subtitle);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 비디오 번호
        Thread videoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // #1 비디오프레임 1~5
                int[] video_frames = { 1, 2, 3, 4, 5 };

                // #3 비디오 프레임 출력
                for (int frame : video_frames) {
                    System.out.print("(비디오프레임) " + frame);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // Thread 실행
        smiThread.start();
        videoThread.start();
    }
}
