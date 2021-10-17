package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.stream.Stream;

import static com.geekbrains.lesson4.functions.isNumberEven;
import static com.geekbrains.lesson4.functions.isNumberPrime;

public class FunctionsTest {
    private static Logger logger = LoggerFactory.getLogger(FunctionsTest.class);
    @BeforeAll
    static void beforeAll(){
        logger.error("Method was ran before all tests");
        logger.debug("Method was ran before all tests");
        logger.trace("Method was ran before all tests");
        logger.info("Method was ran before all tests");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Method was ran before each test");
    }

    @Test
    @DisplayName("Check if number is even")
    @Disabled
    void testGivenNumberWhenCheckIsEventhenTrue(){
        boolean result = isNumberEven(2);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,3,5})
    void isNumberPrimeTest(int number){

        Assertions.assertTrue(isNumberPrime(number));
    }
    @ParameterizedTest
    @CsvSource({"1, true", "3, true", "4, false"})
    void isNumberPrimeTest(int number, boolean result){

        Assertions.assertEquals(result, isNumberPrime(number));
    }

    @ParameterizedTest
    @MethodSource("testDataSource")
    void objectAsParamTest(Cat cat, boolean result){
        System.out.println(cat);
        System.out.println(result);

    }
    private static Stream<Arguments> testDataSource(){
        return Stream.of(
                Arguments.arguments(new Cat(17,"Liam"),true),
                Arguments.arguments(new Cat(10,"Liam"),false)
        );
    }






    @AfterEach
    void afterEach(){
        System.out.println("Metod will be run after each test");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Method will be run after all tests");
    }


}

