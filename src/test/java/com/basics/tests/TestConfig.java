package com.basics.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestConfig {

    @BeforeSuite
    public void testBeforeSuite(){
        System.out.println("testBeforeSuite");
    }

    @AfterSuite
    public void testAfterSuite(){
        System.out.println("testAfterSuite");
    }

    @BeforeTest
    public void testBeforeTest(){
        System.out.println("testBrforeTest");
    }

    @AfterTest
    public void testAfterTest(){
        System.out.println("testAfterTest");
    }
}
