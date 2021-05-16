package com.ig.interview.pascaltriangle.model;

import java.math.BigInteger;

public interface Binomial {
    String INVALID_PARAMS_MESSAGE = "Given pair of integers must conform to n ≥ k ≥ 0";

    /**
     * Calculates binomial coefficient for a given pair of integers n ≥ k ≥ 0
     * @param n first integer to calculate binomial coefficient with n ≥ 0
     * @param k second integer to calculate binomial coefficient n ≥ k ≥ 0
     * @return BigInteger value of binomial coefficient
     */
    BigInteger calculate(int n, int k);

    static void validateInputParams(int n, int k) {
        if (k < 0 || k > n) {
            throw new IllegalArgumentException(INVALID_PARAMS_MESSAGE);
        }
    }
}
