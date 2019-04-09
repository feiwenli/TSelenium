package com.basics.tests;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class TestGroup {

    @BeforeGroups
    public void setupA(){
        System.out.println("setupA");
    }

    @AfterGroups
    public void cleanA(){
        System.out.println("cleanA");
    }

    @Test(groups = "selenium-test")
    public void groupA001(){
        System.out.println("run selenium test 001");
    }

    @Test(groups = "selenium-test")
    public void groupA002(){
        System.out.println("run selenium test 002");
    }

    @Test(groups = "db")
    public void groupB001(){
        System.out.println("run db 001");
    }

    @Test(groups = "db")
    public void groupB002(){
        System.out.println("run db 002");
    }

    @Test(dependsOnGroups = {"selenium-test", "db"})
    public void groupAB(){
        System.out.println("run selenium-test and db");
    }
}
