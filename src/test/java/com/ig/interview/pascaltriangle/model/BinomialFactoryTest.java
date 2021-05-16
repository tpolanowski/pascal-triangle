package com.ig.interview.pascaltriangle.model;

import com.ig.interview.pascaltriangle.model.algorithm.FactorialBinomial;
import com.ig.interview.pascaltriangle.model.algorithm.GuavaBinomial;
import com.ig.interview.pascaltriangle.model.algorithm.MultiplicativeBinomial;
import com.ig.interview.pascaltriangle.model.algorithm.RecursiveBinomial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinomialFactoryTest {

    @Test
    void shouldGetGuavaBinomial() {
        // when
        Binomial binomial = BinomialFactory.GUAVA.get();
        // then
        assertNotNull(binomial);
        assertTrue(binomial instanceof GuavaBinomial);
    }

    @Test
    void shouldGetMultiplicativeBinomial() {
        // when
        Binomial binomial = BinomialFactory.MULTIPLICATIVE.get();
        // then
        assertNotNull(binomial);
        assertTrue(binomial instanceof MultiplicativeBinomial);
    }

    @Test
    void shouldGetFactorialBinomial() {
        // when
        Binomial binomial = BinomialFactory.FACTORIAL.get();
        // then
        assertNotNull(binomial);
        assertTrue(binomial instanceof FactorialBinomial);
    }

    @Test
    void shouldGetRecursiveBinomial() {
        // when
        Binomial binomial = BinomialFactory.RECURSIVE.get();
        // then
        assertNotNull(binomial);
        assertTrue(binomial instanceof RecursiveBinomial);
    }
}