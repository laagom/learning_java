package learning_java_inheritance;

public class Car {
    static final String FRONT_LEFT_TIRE = "왼쪽 앞";
    static final String FRONT_RIGHT_TIRE = "오른쪽 앞";
    static final String BACK_LEFT_TIRE = "왼쪽 뒤";
    static final String BACK_RIGHT_TIRE = "오른쪽 뒤";

    // 필드
    Tire[] tires = {
            new Tire(FRONT_LEFT_TIRE, 6),
            new Tire(FRONT_RIGHT_TIRE, 2),
            new Tire(BACK_LEFT_TIRE, 3),
            new Tire(BACK_RIGHT_TIRE, 4)
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
