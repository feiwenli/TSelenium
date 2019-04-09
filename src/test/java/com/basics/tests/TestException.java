package com.basics.tests;

import org.testng.annotations.Test;

public class TestException {

    /*
    运行时异常通过
     */
    @Test(expectedExceptions = ArithmeticException.class)
    public void exc(){
        int i = 10 / 0;
    }

}
