package sec02_createandstartthread.EX03;

/*
 * #1 방법2. Runnable 인터페이스 상속하여 클래스 생성 case1: 2개 쓰레드 생성
 */

class SMIFileRunnable implements Runnable {
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
}

public class CreateAndStartThread_M2C1 {
    public static void main(String[] args) {
        // SMIFileRunnable 객체 생성
        Runnable smiFiRunnable = new SMIFileRunnable();

        // 오류 : Runnable이라는 객체에는 상속받아 작성해야하는 run()함수는 존재하지만
        // Thread를 시작하는 start()함수는 가지고 있지 않기 때문에 오류 발생
        // smiFiRunnable.start();

        Thread thread = new Thread(smiFiRunnable);
        thread.start();

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
}
