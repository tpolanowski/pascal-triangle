package com.ig.interview.pascaltriangle.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrianglePrinterTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    static Stream<Arguments> provideExpectedPascalTriangles() {
        return Stream.of(
                Arguments.of(new int[][]{{1}}, "1 \r\n"),

                Arguments.of(new int[][]{{1},
                                {1, 1}},
                                " 1 \r\n" +
                                "1 1 \r\n"),

                Arguments.of(new int[][]{{1},
                                {1, 1},
                                {1, 2, 1}},
                                "  1 \r\n" +
                                " 1 1 \r\n" +
                                "1 2 1 \r\n"),

                Arguments.of(new int[][]{{1},
                                {1, 1},
                                {1, 2, 1},
                                {1, 3, 3, 1}},
                                "   1 \r\n" +
                                "  1 1 \r\n" +
                                " 1 2 1 \r\n" +
                                "1 3 3 1 \r\n"),

                Arguments.of(new int[][]{{1},
                                {1, 1},
                                {1, 2, 1},
                                {1, 3, 3, 1},
                                {1, 4, 6, 4, 1}},
                                "    1 \r\n" +
                                "   1 1 \r\n" +
                                "  1 2 1 \r\n" +
                                " 1 3 3 1 \r\n" +
                                "1 4 6 4 1 \r\n"),

                Arguments.of(new int[][]{{1},
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
                        {1, 14, 91, 364, 1001, 2002, 3003, 3432, 3003, 2002, 1001, 364, 91, 14, 1}},
                        "                            1 \r\n" +
                        "                           1 1 \r\n" +
                        "                          1 2 1 \r\n" +
                        "                         1 3 3 1 \r\n" +
                        "                        1 4 6 4 1 \r\n" +
                        "                      1 5 10 10 5 1 \r\n" +
                        "                     1 6 15 20 15 6 1 \r\n" +
                        "                   1 7 21 35 35 21 7 1 \r\n" +
                        "                  1 8 28 56 70 56 28 8 1 \r\n" +
                        "               1 9 36 84 126 126 84 36 9 1 \r\n" +
                        "           1 10 45 120 210 252 210 120 45 10 1 \r\n" +
                        "         1 11 55 165 330 462 462 330 165 55 11 1 \r\n" +
                        "       1 12 66 220 495 792 924 792 495 220 66 12 1 \r\n" +
                        "   1 13 78 286 715 1287 1716 1716 1287 715 286 78 13 1 \r\n" +
                        "1 14 91 364 1001 2002 3003 3432 3003 2002 1001 364 91 14 1 \r\n"
                )
        );
    }

    @ParameterizedTest(name = "{index} => should print provided array with Pascals Triangle")
    @MethodSource("provideExpectedPascalTriangles")
    void shouldPrintTriangle(int[][] givenTriangle, String expectedTriangle) {
        // given
        TrianglePrinter trianglePrinter = new TrianglePrinter();
        // when
        trianglePrinter.printMatrix(ofIntArray(givenTriangle));
        // when
        assertEquals(expectedTriangle, outputStreamCaptor.toString());
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