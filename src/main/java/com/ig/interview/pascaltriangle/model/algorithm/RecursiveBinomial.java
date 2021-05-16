package com.ig.interview.pascaltriangle.model.algorithm;

import com.ig.interview.pascaltriangle.model.Binomial;

import java.math.BigInteger;

import static com.ig.interview.pascaltriangle.model.Binomial.validateInputParams;

public class RecursiveBinomial implements Binomial {
    @Override
    public BigInteger calculate(int n, int k) {
        validateInputParams(n, k);
        if ((n == k) || (k == 0)) {
            return BigInteger.ONE;
        } else {
            BigInteger sum = calculate(n - 1, k);
            return sum.add(calculate(n - 1, k - 1));
        }
    }

}
