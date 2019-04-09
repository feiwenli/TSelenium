package com.basics.tests;

import org.testng.annotations.Test;

public class TestDependOn {

    @Test
    public void methodBase(){
        System.out.println("this is method base");
//        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"methodBase"})
    public void method(){
        System.out.println("this is method");
    }


}
