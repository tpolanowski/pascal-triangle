package com.ig.interview.pascaltriangle.controller;

import com.ig.interview.pascaltriangle.controller.exception.IllegalInputException;
import com.ig.interview.pascaltriangle.model.TriangleGenerator;
import com.ig.interview.pascaltriangle.view.TrianglePrinter;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.Scanner;

@Slf4j
public class ApplicationController {

    private final TriangleGenerator triangleGenerator;
    private final TrianglePrinter trianglePrinter;
    private final InputParser inputParser;

    public ApplicationController(TriangleGenerator triangleGenerator, TrianglePrinter trianglePrinter, InputParser inputParser) {
        this.triangleGenerator = triangleGenerator;
        this.trianglePrinter = trianglePrinter;
        this.inputParser = inputParser;
    }

    public void processLinesFromStandardInput() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            try {
                int parsedInteger = inputParser.parse(nextLine);
                BigInteger[][] pascalTriangle = triangleGenerator.generate(parsedInteger);
                trianglePrinter.printMatrix(pascalTriangle);
            } catch (IllegalInputException illegalInputException) {
                System.out.println(illegalInputException.getMessage());
            }
        }
        scanner.close();
    }
}