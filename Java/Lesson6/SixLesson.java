package Lesson6;

public class SixLesson {
    public static void main(String[] args) {
        Dog dog = new Dog("Liko");
        Cat cat = new Cat("duche");
        Dog dog1 = new Dog("Tom");
        Dog dog2 = new Dog("Ron");
        Dog dog3 = new Dog("Sunny");
        Cat cat1 = new Cat("Yoky");
        Cat cat2 = new Cat("Bob");
        Cat cat3 = new Cat("Lola");
        dog.animalInfo();
        cat.animalInfo();
        dog.Run(100);
        cat.Swim(100);
        dog1.animalInfo();
        dog1.Run(200);
        dog2.animalInfo();
        dog2.Swim(8);
        dog3.animalInfo();
        dog3.Run(10);
        cat1.animalInfo();
        cat1.Run(100);
        cat2.Run(199);
        cat3.Swim(2);

    }
}
