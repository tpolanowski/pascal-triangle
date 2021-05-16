package com.ig.interview.pascaltriangle.view;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TrianglePrinter {
    public void printMatrix(BigInteger[][] array) {
        int lastRowLength = getRowLength(array[array.length - 1]);

        for (BigInteger[] row : array) {
            System.out.print(" ".repeat((lastRowLength - getRowLength(row)) / 2));
            for (BigInteger bigInteger : row) {
                System.out.printf("%d ", bigInteger);
            }
            System.out.println();
        }
    }

    private int getRowLength(BigInteger[] array) {
        return Arrays.stream(array)
                .map(BigInteger::toString)
                .collect(Collectors.joining(" "))
                .length();
    }
}
