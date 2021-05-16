package com.ig.interview.pascaltriangle.model;

import com.ig.interview.pascaltriangle.model.algorithm.FactorialBinomial;
import com.ig.interview.pascaltriangle.model.algorithm.GuavaBinomial;
import com.ig.interview.pascaltriangle.model.algorithm.MultiplicativeBinomial;
import com.ig.interview.pascaltriangle.model.algorithm.RecursiveBinomial;

public enum BinomialFactory {
    RECURSIVE {
        @Override
        public Binomial get() {
            return new RecursiveBinomial();
        }
    },
    MULTIPLICATIVE {
        @Override
        public Binomial get() {
            return new MultiplicativeBinomial();
        }
    },
    FACTORIAL {
        @Override
        public Binomial get() {
            return new FactorialBinomial();
        }
    },
    GUAVA {
        @Override
        public Binomial get() {
            return new GuavaBinomial();
        }
    };

    public abstract Binomial get();

}
