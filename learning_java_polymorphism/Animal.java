package learning_java_polymorphism;

public abstract class Animal {
    public String kind;

    /*
     * 일반 메서드
     * 일반 동물은 모두 동일하게 숨을 쉬기 때문에 확장성 없이 일반 메서드로 구현
     */
    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    /*
     * 추상 메서드
     * 상속 받는 동물마다 우는 소리가 다르기 때문에 추상 메서드로 구현
     */
    public abstract void sound();
}
