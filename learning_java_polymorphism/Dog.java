package learning_java_polymorphism;

public class Dog extends Animal {

    public Dog() {
        this.kind = "포유류";
    }

    // 추상 메서드 재정의
    @Override
    public void sound() {
        System.out.println("멍! 멍!");
    }

}