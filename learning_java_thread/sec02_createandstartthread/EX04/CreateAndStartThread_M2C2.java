package sec02_createandstartthread.EX04;

/*
 * #1 방법2. Runnable 인터페이스 상속하여 클래스 생성 case2: 3개 쓰레드 생성
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

class VideoFileRunnable implements Runnable {
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
}

public class CreateAndStartThread_M2C2 {
    public static void main(String[] args) {
        // SMIFileRunnable 객체 생성
        Runnable smiFileRunnable = new SMIFileRunnable();
        Thread smiThread = new Thread(smiFileRunnable);
        smiThread.start();

        // VideoFileRunnable 객체 생성
        Runnable videoFileRunnable = new VideoFileRunnable();
        Thread videoThread = new Thread(videoFileRunnable);
        videoThread.start();

        /**
         * 이렇게 Runnable 객체를 만들어서 사용하는데
         * 단 한번만 사용하고 다시 사용할 수 없기 때문에 코드가 낭비되게 된다.
         */
    }
}
