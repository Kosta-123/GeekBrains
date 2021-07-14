package Lesson7;

public class Lesson7 {
    public static void main(String[] args) {
       Plate plate = new Plate(60);
       Cat[] cats = new Cat[]{
               new Cat("Bob", 15),
               new Cat("Riccy", 10),
               new Cat ("Vincent", 21),
               new Cat("Loki", 16),
               new Cat("Gibon", 7)
       };

       feedCats(cats, plate);
       plate.refill(10);
       feedCats(cats, plate);
    }
    public static void feedCats(Cat[] cats, Plate plate){
        for (Cat cat : cats){
            cat.eat(plate);
            cat.info();
        }
        System.out.println();
    }
}
