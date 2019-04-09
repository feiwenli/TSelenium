package com.basics.tests;

import org.testng.annotations.Test;

public class TestIgnore {

    @Test
    public void test01(){
        System.out.println("run test01");
    }

    @Test(enabled = false)
    public void test02(){
        System.out.println("tun test02");
    }
}
