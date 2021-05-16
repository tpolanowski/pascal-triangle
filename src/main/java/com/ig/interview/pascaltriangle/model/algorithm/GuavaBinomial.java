package com.ig.interview.pascaltriangle.model.algorithm;

import com.ig.interview.pascaltriangle.model.Binomial;

import java.math.BigInteger;

import static com.google.common.math.BigIntegerMath.binomial;
import static com.ig.interview.pascaltriangle.model.Binomial.validateInputParams;

public class GuavaBinomial implements Binomial {
    @Override
    public BigInteger calculate(int n, int k) {
        validateInputParams(n, k);
        return binomial(n, k);
    }
}
