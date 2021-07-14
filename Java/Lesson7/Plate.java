package Lesson7;

public class Plate {
    public int food;

     Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(final int input) {
        boolean output = false;
        if (food - input >= 0) {
            food -= input;
            output = true;
        }
        return output;
    }


    public void refill (final int input) {
        this.food += input;
    }
}
