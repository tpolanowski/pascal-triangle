package com.ig.interview.pascaltriangle.controller;

import com.ig.interview.pascaltriangle.controller.exception.IllegalInputException;
import com.ig.interview.pascaltriangle.model.TriangleGenerator;
import com.ig.interview.pascaltriangle.view.TrianglePrinter;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ApplicationControllerTest {
    private final TriangleGenerator triangleGenerator = mock(TriangleGenerator.class);
    private final TrianglePrinter trianglePrinter = new TrianglePrinter();
    private final InputParser inputParser = mock(InputParser.class);
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

    @Test
    @SneakyThrows
    void shouldPrintPascalsTriangleForGivenPositiveInteger() {
        // given
        String depthInputFromStdin = "3\r\n";
        String expectedOutput = "  1 \r\n"
                + " 1 1 \r\n"
                + "1 2 1 \r\n";

        when(triangleGenerator.generate(anyInt())).thenReturn(new BigInteger[][]{
                {BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(1)},
                {BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(1)}});

        when(inputParser.parse(anyString())).thenReturn(3);

        ApplicationController applicationController = new ApplicationController(triangleGenerator, trianglePrinter, inputParser);
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(depthInputFromStdin.getBytes()));
            // when
            applicationController.processLinesFromStandardInput();
            // then
            assertEquals(expectedOutput, outputStreamCaptor.toString());
        } finally {
            System.setIn(stdin);
        }
    }

    @Test
    @SneakyThrows
    void shouldPrintErrorMessageForInvalidInput() {
        // given
        String errorMessage = "error_message";
        String depthInputFromStdin = "INVALID_INPUT\r\n";
        when(inputParser.parse(anyString())).thenThrow(new IllegalInputException(errorMessage));
        ApplicationController applicationController = new ApplicationController(triangleGenerator, trianglePrinter, inputParser);
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(depthInputFromStdin.getBytes()));
            // when
            applicationController.processLinesFromStandardInput();
            // then
            assertEquals(errorMessage+"\r\n", outputStreamCaptor.toString());

        } finally {
            System.setIn(stdin);
        }
    }
}