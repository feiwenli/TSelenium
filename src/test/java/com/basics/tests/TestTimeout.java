package com.basics.tests;

import org.testng.annotations.Test;

public class TestTimeout {

    @Test(timeOut = 6000)
    public void inTime() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test(timeOut = 4000)
    public void outOfTime() throws InterruptedException {
        Thread.sleep(5000);
    }
}
