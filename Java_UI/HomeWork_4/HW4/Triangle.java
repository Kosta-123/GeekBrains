package com.geekbrains.HW4;


public class Triangle {

    static double tryangleSquareArea(int a, int b, int c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0) throw new Exception();

        double perimeter = (a + b + c) / 2;
        return (perimeter * (perimeter - a) * (perimeter - b) * (perimeter - c));




        }

    }








