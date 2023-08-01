package sec01_theneedforthread.EX01;

public class TheNeedForThread {
    /**
     * 비디오와 자막이 동일한 쓰레드로 작동하기 때문에
     * 동시간에 싱크가 맞춰서 출력되기 어려움
     * 
     * @param args
     */
    public static void main(String[] args) {

        // #1 비디오프레임 1~5
        int[] video_frames = { 1, 2, 3, 4, 5 };
        // #2 자막 번호 하나~다섯
        String[] video_subtitles = { "하나", "둘", "셋", "넷", "다섯" };

        // #3 비디오 프레임 출력
        for (int frame : video_frames) {
            System.out.println("(비디오프레임) " + frame);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // #4 자막 번호 출력
        for (String subtitle : video_subtitles) {
            System.out.println("(자막 번호) " + subtitle);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
