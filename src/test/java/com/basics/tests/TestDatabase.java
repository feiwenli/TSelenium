package com.basics.tests;

import org.testng.annotations.Test;

public class TestDatabase {

    @Test(groups = "db")
    public void testConnectOracle(){
        System.out.println("testConnectOracle");
    }

    @Test(groups = "db")
    public void testConnectMySQL(){
        System.out.println("testConnectMySQL");
    }

    @Test(groups = "db-nosql")
    public void testConnecrNoSQL(){
        System.out.println("testConnectNoSQL");
    }

    @Test(groups = {"db", "brokenTests"})
    public void testConnectSQL(){
        System.out.println("testConnectSQL");
    }
}
