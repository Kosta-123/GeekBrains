package Lesson6;

public class Cat extends Animal{
    public final int RUN_DiSTANCE = 200;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void Run(int distance) {
        if (distance <= RUN_DiSTANCE) {
            System.out.println("Cat Overcome: " + distance);
        }

    }

    @Override
    public void Swim(int distance) {
        System.out.println("Cat: can't swim. ");

    }
}
