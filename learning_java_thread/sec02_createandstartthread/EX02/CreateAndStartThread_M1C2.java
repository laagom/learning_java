package sec02_createandstartthread.EX02;

/*
 * #1 방법1. Thread 클래스 상속하여 클래스 생성 case2: 3개 쓰레드 생성
 */
class SMIFileThread extends Thread {
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

class VideoFileThread extends Thread {
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

public class CreateAndStartThread_M1C2 {
    public static void main(String[] args) {
        // SMIFileThread 객체 생성 및 시작
        Thread smiFileThread = new SMIFileThread();
        smiFileThread.start();

        // VideoFileThread 객체 생성 및 시작
        Thread videoFileThread = new VideoFileThread();
        videoFileThread.start();
    }
}
