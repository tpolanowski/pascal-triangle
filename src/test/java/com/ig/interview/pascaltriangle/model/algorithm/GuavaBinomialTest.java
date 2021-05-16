package com.ig.interview.pascaltriangle.model.algorithm;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GuavaBinomialTest extends BinomialAlgorithmTestBase {

    @ParameterizedTest(name = "{index} => should calculate binomial coefficient for (n, k) => ({0}, {1}), expecting result={2}")
    @MethodSource("provideBinomialCoefficientsTestData")
    void shouldCalculateBinominalCoefficients(int n, int k, int expectedResult) {
        // given
        GuavaBinomial guavaBinomial = new GuavaBinomial();
        // when
        BigInteger actualResult = guavaBinomial.calculate(n, k);
        // then
        assertEquals(expectedResult, actualResult.intValue());
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNonPositiveN() {
        // given
        GuavaBinomial guavaBinomial = new GuavaBinomial();
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            guavaBinomial.calculate(-5, 0);
        });
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNonPositiveK() {
        // given
        GuavaBinomial guavaBinomial = new GuavaBinomial();
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            guavaBinomial.calculate(0, -10);
        });
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForKBiggerThanN() {
        // given
        GuavaBinomial guavaBinomial = new GuavaBinomial();
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            guavaBinomial.calculate(5, 10);
        });
    }
}