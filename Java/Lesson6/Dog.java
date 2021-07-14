package Lesson6;

public class Dog extends Animal {
    public final int RUN_DiSTANCE = 500;
    public final int SWIM_DiSTANCE = 10;
    public Dog(String name) {
        super(name);
    }

    @Override
    public void Run(int distance) {
        if (distance <= RUN_DiSTANCE) {
            System.out.println("Dog overcome: " + distance);
        }

    }

    @Override
    public void Swim(int distance) {
        if (distance <= SWIM_DiSTANCE){
            System.out.println("Dog swam: " + distance);
        }

    }
}
