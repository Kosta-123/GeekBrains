package com.geekbrains.lesson4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.geekbrains.lesson4.functions.isNumberPrime;
import static org.assertj.core.api.Assertions.assertThat;

public class AssertJExamplesTest {
    @Test
    void testIsNumberPrimeAssertJ(){
        assertThat(isNumberPrime(3)).isTrue();
    }
    @Test
    void collectionAssertThat(){
        List<String> testCollection = new ArrayList<>(Arrays.asList("test", "test1", "test2"));
        assertThat(testCollection).contains("test1").containsAnyOf("test", "sddgfw");
        assertThat(7).isLessThan(8).isGreaterThan(1);
    }
}
