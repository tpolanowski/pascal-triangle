package com.ig.interview.pascaltriangle.model.algorithm;

import com.ig.interview.pascaltriangle.model.Binomial;

import java.math.BigInteger;

import static com.ig.interview.pascaltriangle.model.Binomial.validateInputParams;

public class FactorialBinomial implements Binomial {
    @Override
    public BigInteger calculate(int n, int k) {
        validateInputParams(n, k);
        return factorial(n).divide(factorial(n - k)
                .multiply(factorial(k))
        );
    }

    private BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
