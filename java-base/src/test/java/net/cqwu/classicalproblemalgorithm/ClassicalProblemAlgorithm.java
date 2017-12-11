package net.cqwu.classicalproblemalgorithm;

import org.junit.Before;
import org.junit.Test;

/**
 * CopyRright (c)2018-0000:   net.cqwu
 * Project:               java
 * Module ID:   00001
 * Comments:
 * JDK version used:      JDK1.8
 * Namespace:           net.cqwu.classicalproblemalgorithm
 * Author：             Administrator
 * Create Date：  2017-12-11
 * Modified By：   Administrator
 * Modified Date:  2017-12-11
 * Why & What is modified
 * Version:        V1.0
 */
public class ClassicalProblemAlgorithm {
    private FibonacciSequence fibonacciSequence;
    private Prime prime;
    private Narcissus narcissus;

    @Before
    public void init() {
        fibonacciSequence = new FibonacciSequence();
        prime = new Prime();
        narcissus = new Narcissus();
    }

    @Test
    public void testFibonacciSequence() {
        narcissus.findNarcissus();
    }
}
