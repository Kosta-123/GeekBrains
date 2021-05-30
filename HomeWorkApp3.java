package Lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        oneInsteadZero();
        fillOut100();
        multiplyBy2();
        crissCross ();
        //lenAndIniyialValue();
        lenInitialValue();

    }


   public static void oneInsteadZero() {
        System.out.println("Task 1:");
        int[] arr = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
            {
                System.out.println(arr[i]);
            }
        }
    }


    public static void fillOut100() {
        System.out.println("Task 2:");

        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.println(arr[i]);
        }
    }


    public static void multiplyBy2() {
        System.out.println("task 3:");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6)
                arr[i] *= 2;
            System.out.println(arr[i]);
        }
    }
        public static void crissCross () {
            System.out.println("task 4:");
            int number = 4;
            int[][] arr = new int[number][number];
            for (int i = 0; i < number; i++) {
                for (int j = 0; j < number; j++) {
                    if (i == j) {
                        arr[i][j] = 1;
                    }
                    System.out.print(arr[i][j] + "  ");
                }
                System.out.println();
            }

        }

//    public static void lenAndIniyialValue() {
//        System.out.println("task 5:");
//        int[] arr = new int[3];// это одна полка с тремя картшками
//        for (int i=0; i< arr.length;i++){ //прибавляю полки
//            if (arr[0]==0){               //прибавляю картошку
//                arr[0]=1;
//            }
//        System.out.println(Arrays.toString(arr)); // распечатываю полки
//
//    }
//}

    public static void lenInitialValue() {
        System.out.println("Task 5:");
        int len = 3;
        int initialValue = 5;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        {
            System.out.println(Arrays.toString(arr));

        }


    }
}













































































