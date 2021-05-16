package com.ig.interview.pascaltriangle;

import com.ig.interview.pascaltriangle.controller.ApplicationController;
import com.ig.interview.pascaltriangle.controller.InputParser;
import com.ig.interview.pascaltriangle.model.BinomialFactory;
import com.ig.interview.pascaltriangle.model.TriangleGenerator;
import com.ig.interview.pascaltriangle.view.TrianglePrinter;

public class ConsoleApplicationRunner {
    private static final ApplicationController applicationController = new ApplicationController(
            new TriangleGenerator(BinomialFactory.MULTIPLICATIVE.get()),
            new TrianglePrinter(),
            new InputParser());

    public static void main(String[] args) {
        applicationController.processLinesFromStandardInput();
    }
}
