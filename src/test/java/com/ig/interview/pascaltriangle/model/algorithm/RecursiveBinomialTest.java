package com.ig.interview.pascaltriangle.model.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveBinomialTest extends BinomialAlgorithmTestBase {

    @ParameterizedTest(name = "{index} => should calculate binomial coefficient for (n, k) => ({0}, {1}), expecting result={2}")
    @MethodSource("provideBinomialCoefficientsTestData")
    void shouldCalculateBinominalCoefficients(int n, int k, int expectedResult) {
        // given
        RecursiveBinomial recursiveBinomial = new RecursiveBinomial();
        // when
        BigInteger actualResult = recursiveBinomial.calculate(n, k);
        // then
        assertEquals(expectedResult, actualResult.intValue());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNonPositiveN() {
        // given
        RecursiveBinomial recursiveBinomial = new RecursiveBinomial();
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            recursiveBinomial.calculate(-5, 0);
        });
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNonPositiveK() {
        // given
        RecursiveBinomial recursiveBinomial = new RecursiveBinomial();
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            recursiveBinomial.calculate(0, -10);
        });
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForKBiggerThanN() {
        // given
        RecursiveBinomial recursiveBinomial = new RecursiveBinomial();
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            recursiveBinomial.calculate(5, 10);
        });
    }
}