package com.ig.interview.pascaltriangle.model.algorithm;

import com.ig.interview.pascaltriangle.model.Binomial;

import java.math.BigInteger;

import static com.ig.interview.pascaltriangle.model.Binomial.validateInputParams;

public class MultiplicativeBinomial implements Binomial {
    @Override
    public BigInteger calculate(int n, int k) {
        validateInputParams(n, k);
        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < k; i++) {
            result = result.multiply(BigInteger.valueOf(n - i))
                    .divide(BigInteger.valueOf(i + 1));
        }
        return result;
    }
}
