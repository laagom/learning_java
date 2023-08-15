package learning_java_abstract.sec01_abstractinfinition;

public class Dog extends Animal {
    public Dog() {
        this.kind = "포유류";
    }

    @Override
    public void sound() {
        System.out.println("왈왈!");
        
    }

    /*
     * 상속받은 부모 추상클래스 Animal의 sound() 추상 메서드를
     * 오버라이딩(재정의) 하지 않으면 오류가 발생한다.
     */
}
