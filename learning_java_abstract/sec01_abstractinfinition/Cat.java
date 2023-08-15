package learning_java_abstract.sec01_abstractinfinition;

public class Cat extends Animal {
    public Cat() {
        this.kind = "포유류";
    }

    @Override
    public void sound() {
        System.out.println("야~옹!");
        
    }

    /**
     * Dog와 마찬가지로 부모 추상클래스인 Animal 의 sound() 추상 메서드를 사용하지 않으면
     * 오류가 발생한다.
     * 
     * =========================================
     * 
     * Dog / Cat 클래스 오부 오버라이딩 하면서 다형성이 발생하였고,
     * 규격에 맞게끔 필드명과 메서드명이 통일되어 있음을 확인 할 수 있다.
     */
}
