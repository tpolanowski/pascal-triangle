package com.ig.interview.pascaltriangle.controller.exception;

public class IllegalInputException extends Exception {
    public IllegalInputException(String errorMessage) {
        super(errorMessage);
    }
}
