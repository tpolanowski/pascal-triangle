package com.ig.interview.pascaltriangle.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleGeneratorTest {

    static Stream<Arguments> provideExpectedPascalTriangles() {
        return Stream.of(
                Arguments.of(1,
                        new int[][]{{1}}),

                Arguments.of(2,
                        new int[][]{{1},
                                {1, 1}}),

                Arguments.of(3,
                        new int[][]{{1},
                                {1, 1},
                                {1, 2, 1}}),

                Arguments.of(4,
                        new int[][]{{1},
                                {1, 1},
                                {1, 2, 1},
                                {1, 3, 3, 1}}),

                Arguments.of(5,
                        new int[][]{{1},
                                {1, 1},
                                {1, 2, 1},
                                {1, 3, 3, 1},
                                {1, 4, 6, 4, 1}}),

                Arguments.of(20,
                        new int[][]{{1},
                                {1, 1},
                                {1, 2, 1},
                                {1, 3, 3, 1},
                                {1, 4, 6, 4, 1},
                                {1, 5, 10, 10, 5, 1},
                                {1, 6, 15, 20, 15, 6, 1},
                                {1, 7, 21, 35, 35, 21, 7, 1},
                                {1, 8, 28, 56, 70, 56, 28, 8, 1},
                                {1, 9, 36, 84, 126, 126, 84, 36, 9, 1},
                                {1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1},
                                {1, 11, 55, 165, 330, 462, 462, 330, 165, 55, 11, 1},
                                {1, 12, 66, 220, 495, 792, 924, 792, 495, 220, 66, 12, 1},
                                {1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1},
                                {1, 14, 91, 364, 1001, 2002, 3003, 3432, 3003, 2002, 1001, 364, 91, 14, 1},
                                {1, 15, 105, 455, 1365, 3003, 5005, 6435, 6435, 5005, 3003, 1365, 455, 105, 15, 1},
                                {1, 16, 120, 560, 1820, 4368, 8008, 11440, 12870, 11440, 8008, 4368, 1820, 560, 120, 16, 1},
                                {1, 17, 136, 680, 2380, 6188, 12376, 19448, 24310, 24310, 19448, 12376, 6188, 2380, 680, 136, 17, 1},
                                {1, 18, 153, 816, 3060, 8568, 18564, 31824, 43758, 48620, 43758, 31824, 18564, 8568, 3060, 816, 153, 18, 1},
                                {1, 19, 171, 969, 3876, 11628, 27132, 50388, 75582, 92378, 92378, 75582, 50388, 27132, 11628, 3876, 969, 171, 19, 1},
                        })
        );
    }


    @ParameterizedTest(name = "{index} => should generate Pascals Triangle for depth={0}")
    @MethodSource("provideExpectedPascalTriangles")
    void shouldGenerateTriangle(int depth, int[][] expectedTriangle) {
        // given
        TriangleGenerator triangleGenerator = new TriangleGenerator(BinomialFactory.GUAVA.get());
        BigInteger[][] expectedResult = ofIntArray(expectedTriangle);
        // when
        BigInteger[][] generatedTriangle = triangleGenerator.generate(depth);
        // when
        assertEqualsTriangles(expectedResult, generatedTriangle);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionForNonPositiveDepth() {
        // given
        TriangleGenerator triangleGenerator = new TriangleGenerator(BinomialFactory.GUAVA.get());
        // when then
        assertThrows(IllegalArgumentException.class, () -> {
            triangleGenerator.generate(-5);
        });
    }

    private void assertEqualsTriangles(BigInteger[][] expectedResult, BigInteger[][] generatedTriangle) {
        for (int row = 0; row < expectedResult.length; row++) {
            for (int col = 0; col < expectedResult[row].length; col++) {
                assertEquals(expectedResult[row][col], generatedTriangle[row][col]);
            }
        }
    }

    private BigInteger[][] ofIntArray(int[][] array) {
        BigInteger[][] result = new BigInteger[array.length][];
        for (int row = 0; row < array.length; row++) {
            result[row] = new BigInteger[array[row].length];
            for (int col = 0; col < array[row].length; col++) {
                result[row][col] = BigInteger.valueOf(array[row][col]);
            }
        }
        return result;
    }


}