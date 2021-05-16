package com.ig.interview.pascaltriangle.model;

import java.math.BigInteger;

public class TriangleGenerator {
    private static final String INVALID_PARAM_MESSAGE = "Given depth must be positive";
    private final Binomial binomial;

    public TriangleGenerator(Binomial binomial) {
        this.binomial = binomial;
    }

    public BigInteger[][] generate(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException(INVALID_PARAM_MESSAGE);
        }

        BigInteger[][] triangle = new BigInteger[depth][depth];

        for (int rowNumber = 0; rowNumber < depth; rowNumber++) {
            triangle[rowNumber] = generateRow(rowNumber);
        }

        return triangle;
    }

    private BigInteger[] generateRow(int rowNumber) {
        if (rowNumber == 0) {
            return new BigInteger[]{BigInteger.ONE};
        } else {
            BigInteger[] row = new BigInteger[rowNumber + 1];
            for (int columnNumber = 0; columnNumber <= rowNumber; columnNumber++) {
                row[columnNumber] = binomial.calculate(rowNumber, columnNumber);
            }
            return row;
        }
    }
}
