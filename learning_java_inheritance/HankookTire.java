package learning_java_inheritance;

public class HankookTire extends Tire {

    /**
     * 상속 받은 부모 객체의 생성자 함수가 default가 아니라면
     * super()를 호출할 수 없어 자식 객체에서 부모의 생성자를 작성해야 함.
     * 
     * @param location
     * @param maxRotation
     */
    public HankookTire(String location, int maxRotation) {
        super(location, maxRotation);
    }

    @Override
    public boolean roll() {
        ++accumulatedRotation;
        if (accumulatedRotation < maxRotation) {
            System.out.println(location + " HankookTire 수명: " + (maxRotation - accumulatedRotation) + "회");
            return true;
        } else {
            System.out.println("*** " + location + "HankookTire 펑크 ***");
            return false;
        }
    }

}
