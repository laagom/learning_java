package learning_java_abstract.sec01_abstractinfinition;

public class AnimalExample {
    public static void main(String[] args) {
        // 다형성 : 상속받은 객체의 사용성
        
        // 1 : 구현체에 구현되어 있는 메서드 호출
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.sound();
        cat.sound();

        // 2 : Animal 부모객체에 Dog/Cat의 생성자를 생성하여 
        // 공통된 참조객체로 메서드 호출하기
        Animal animal = null;

        animal = new Dog();
        animal.sound();

        animal = new Cat();
        animal.sound();

        // 3 : 특정 메서드를 만들어 전달하는 매개변수에 따라
        // 호출되는 내용을 다르게 하기
        animalSound(new Dog());
        animalSound(new Cat());
    }

    private static void animalSound(Animal animal) {
        animal.sound();
    }
}
