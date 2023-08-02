package learning_java_inheritance;

public class Car {
    // 필드
    Tire[] tires = {
            new Tire("왼쪽 앞", 6),
            new Tire("오른쪽 앞", 2),
            new Tire("왼쪽 뒤", 3),
            new Tire("오른쪽 뒤", 4)
    };

    /**
     * 자동차 정지 함수
     */
    public void stop() {
        System.out.println("[자동차가 멈춥니다.]");
    }

    // 메소드
    public int run() {
        System.out.println("[자동차가 달립니다.]");
        for (int i = 0; i < tires.length; i++) {
            if (tires[i].roll() == false) {
                stop();
                return (i + 1);
            }
        }
        return 0;
    }
}
