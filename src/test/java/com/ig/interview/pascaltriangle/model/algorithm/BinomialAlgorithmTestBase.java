package com.ig.interview.pascaltriangle.model.algorithm;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class BinomialAlgorithmTestBase {
    static Stream<Arguments> provideBinomialCoefficientsTestData() {
        return Stream.of(
                Arguments.of(0, 0, 1),
                Arguments.of(1, 0, 1),
                Arguments.of(2, 0, 1),
                Arguments.of(2, 1, 2),
                Arguments.of(2, 2, 1),
                Arguments.of(3, 0, 1),
                Arguments.of(3, 1, 3),
                Arguments.of(3, 2, 3),
                Arguments.of(3, 3, 1),
                Arguments.of(4, 0, 1),
                Arguments.of(4, 1, 4),
                Arguments.of(4, 2, 6),
                Arguments.of(4, 3, 4),
                Arguments.of(4, 4, 1),
                Arguments.of(5, 0, 1),
                Arguments.of(5, 1, 5),
                Arguments.of(5, 2, 10),
                Arguments.of(5, 3, 10),
                Arguments.of(5, 4, 5),
                Arguments.of(5, 5, 1),
                Arguments.of(20, 0, 1),
                Arguments.of(20, 10, 184756),
                Arguments.of(20, 20, 1)
        );
    }
}
