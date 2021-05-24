package Lesson2;

public class HomeWorkApp2 {
    private static Object String;

    public static void main(String[] args) {
         System.out.println(from10to20(10, 5));
        negativeOrPositive(0);
        System.out.println(positiveOrNegative2(0));
        word("Hello", 1);
    }

    public static boolean from10to20(int a, int b) {
        int sum = a + b;
        if (sum >10 && sum <20) return true;
        else return false;

    }

    public static void negativeOrPositive(int a) {
        if (a >= 0) {
            System.out.println("Positive");
        } else{
            System.out.println("Negative");
        }

    }
    public static boolean positiveOrNegative2(int a) {
        if (a >= 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void word(String name, int a) {
        for (a = 1; a < 6; a++) {
            System.out.println(name);
        }
    }
}














