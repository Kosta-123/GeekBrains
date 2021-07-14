package Lesson6;

public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
    public void animalInfo(){
        System.out.println("Animal: " + name);
    }

    public abstract void Run(final int distance);

    public abstract void Swim(final int distance);


}
