package ru.gb.lesson1;

public class HomeWorkApp {
    public static void main(String[] args) {
       //System.out.println("Hello World");
        // printThreeWords();
        //checkSumSign();
         //printColor();
        //compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Apple \n" + "Banana \n" + "Orange");
    }

    public static void checkSumSign() {
        int a = 5;
        int b = 10;

        if (a + b >= 0) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }
    }

    public static void printColor() {
        int value = 10;

        if (value <= 0) ;
        else {
            System.out.println("Red");
        }
        if (value <= 100) ;
        {
            System.out.println("Yellow");
        }

        if (value > 100) ;
        else {
            System.out.println("Green");
        }
    }

    public static void compareNumbers() {
        int a = 20;
        int b = 10;
        if (a >= b) {
            System.out.println("a >= b");
        }
        if (a < b) ;
        else {
            System.out.println("a < b");

        }
    }
}








