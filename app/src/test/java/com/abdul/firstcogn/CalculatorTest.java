package com.abdul.firstcogn;

import android.util.Log;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class CalculatorTest extends TestCase {

    public static String TAG = CalculatorTest.class.getSimpleName();
    @BeforeClass
    void init(){
        //Log.i(TAG,"before class");
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        System.out.println("before class");

    }

    public void testAdd() {
       // Log.i(TAG,"in test add");
        System.out.println("test add");

        int expected = 40;
        int actual = Calculator.add(10,20);
        assertEquals(expected,actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        System.out.println("after class");

    }

    @AfterClass
    void cleanUp(){

        //Log.i(TAG,"after class");

    }
}