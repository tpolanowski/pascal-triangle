package com.ig.interview.pascaltriangle.controller;

import com.ig.interview.pascaltriangle.controller.exception.IllegalInputException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    static Stream<Arguments> provideCorrectInputArguments() {
        return Stream.of(
                Arguments.of(String.valueOf(1)),
                Arguments.of(String.valueOf(2)),
                Arguments.of(String.valueOf(3)),
                Arguments.of(String.valueOf(10000)),
                Arguments.of(String.valueOf(Integer.MAX_VALUE))
        );
    }

    @ParameterizedTest(name = "{index} => should parse {0} as integer")
    @MethodSource("provideCorrectInputArguments")
    @SneakyThrows
    void shouldParsePositiveInteger(String expectedValue) {
        // given
        InputParser inputParser = new InputParser();
        // when
        int result = inputParser.parse(expectedValue);
        // then
        assertEquals(Integer.valueOf(expectedValue), result);
    }

    @Test
    void shouldThrowExceptionForInputLesserThanZero() {
        // given
        InputParser inputParser = new InputParser();
        // when then
        assertThrows(IllegalInputException.class, () -> {
            inputParser.parse(String.valueOf(-5));
        });
    }

    @Test
    void shouldThrowExceptionForInputEqualZero() {
        // given
        InputParser inputParser = new InputParser();
        // when then
        assertThrows(IllegalInputException.class, () -> {
            inputParser.parse(String.valueOf(0));
        });
    }

    @Test
    void shouldThrowExceptionForNonIntegerNumberInput() {
        // given
        InputParser inputParser = new InputParser();
        // when then
        assertThrows(IllegalInputException.class, () -> {
            inputParser.parse(String.valueOf(1.5));
        });
    }

    @Test
    void shouldThrowExceptionForNonIntegerStringInput() {
        // given
        InputParser inputParser = new InputParser();
        // when then
        assertThrows(IllegalInputException.class, () -> {
            inputParser.parse("TEST_STRING");
        });
    }
}