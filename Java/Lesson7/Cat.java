package Lesson7;

public class Cat {
    private String name;
    private final int appetite;
    private boolean satiety;

    public Cat(final String name, final int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat (final Plate plate) {
        if (!satiety) {
            satiety = plate.decreaseFood(appetite);
        }
    }
        public void info() {
            System.out.printf("Cat %s with appetite %d %s\n", name, appetite, satiety ? "is full" : "is hungry");
        }
    }


