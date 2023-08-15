package learning_java_abstract.sec01_abstractinfinition;

public abstract class Animal {
    public String kind;

    public void breath() {
        System.out.println("숨을 쉰다.");
    }

    public abstract void sound(); // 구체적인 구현부 없음

    /**
     * 상속클래스를 상속받는 실체클래스들은 반드시 sound() 추상메서드를 상속받아 재정의 해양한다.
     */
}
