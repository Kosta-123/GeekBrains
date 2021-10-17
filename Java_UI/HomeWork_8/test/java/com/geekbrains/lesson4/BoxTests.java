package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.*;

public class BoxTests {
    Box box;


    @Nested
    class WhenIsEmpty {
        @BeforeEach
        void createBox() {
            box = new Box();
        }

        @Test
        void addBallTest(){
            box.addBall();
            Assertions.assertEquals(1,box.getBallsCounter());
        }
        @Test
        void removeBallFromEmtyBox(){
            assertThatNullPointerException().isThrownBy(()->box.removeBall());
        }

        @Test
        void shuffleEmtyBoxTex(){
            assertThatExceptionOfType(BoxIsEmtyExeption.class).isThrownBy(()->box.shuffleBalls());
        }

        @Nested
        class WhenWithBalls{
            @BeforeEach
            void addBalls(){
                box.addBall();
            }
            @Test
            void removeBallFromBoxWithBalls(){
                box.removeBall();
                assertThat(box.getBallsCounter()).isEqualTo(0);
            }
        }
    }
}