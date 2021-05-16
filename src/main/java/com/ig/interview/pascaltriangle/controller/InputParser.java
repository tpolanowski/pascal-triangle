package com.ig.interview.pascaltriangle.controller;

import com.ig.interview.pascaltriangle.controller.exception.IllegalInputException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InputParser {
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter a positive integer which indicates the depth of Pascal's Triangle.";

    public int parse(String input) throws IllegalInputException {
        int parsedInteger = parseIntegerFromString(input);
        parsePositiveInteger(parsedInteger);
        return parsedInteger;
    }

    private int parseIntegerFromString(String input) throws IllegalInputException {
        int parsedInteger;
        try {
            parsedInteger = Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            IllegalInputException exception = new IllegalInputException(INVALID_INPUT_MESSAGE);
            log.info("Parsed invalid input string: " + input, exception);
            throw exception;
        }
        return parsedInteger;
    }

    private void parsePositiveInteger(int parsedInteger) throws IllegalInputException {
        if (parsedInteger <= 0) {
            IllegalInputException exception = new IllegalInputException(INVALID_INPUT_MESSAGE);
            log.info("Parsed integer is not positive: " + parsedInteger, exception);
            throw exception;
        }
    }
}
