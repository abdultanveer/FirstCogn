package com.abdul.firstcogn;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    public void testAdd() {
        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }
}