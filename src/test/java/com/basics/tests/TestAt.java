package com.basics.tests;

import org.testng.annotations.Test;

public class TestAt {

    @Test
    public void runOtherTest1(){
        System.out.println("@Test - runOtherTest1");
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void runOtherTest2(){
        System.out.println("@Test - runOtherTest2");
    }
}
