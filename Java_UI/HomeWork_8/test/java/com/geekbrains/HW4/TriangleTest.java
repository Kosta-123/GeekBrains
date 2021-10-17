package com.geekbrains.HW4;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TriangleTest {
   @Test
   void positiveAreaCalculation() throws Exception {
      double result = Triangle.tryangleSquareArea(5,7,6);
      Assertions.assertEquals(216.0,result);
   }

   @Test
    void checkIfEquivalentTriangleTest() throws Exception {
        double result = Triangle.tryangleSquareArea(5, 5, 5);
        Assertions.assertEquals(56.0, result);
    }
    @Test
    void negativeSideOfTryangleTest() throws Exception{

       assertThatExceptionOfType(Exception.class)
               .isThrownBy(()-> Triangle.tryangleSquareArea(-5,5,5));
    }

//    @Test
//    public void notTriangleTest() throws Exception {
//       double result = Triangle.tryangleSquareArea(0,5,5);
//       Assertions.assertEquals(4);
//
//
//    }
}

