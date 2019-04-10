package com.basics.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Monitor {

    public static void waitForOperDone(WebDriver driver, WebElement element) throws InterruptedException {

        Callable call = () -> {
            element.sendKeys("");
            return driver;
        };

        FutureTask task = new FutureTask(call);
        new Thread(task).start();

        for(int i=0; i<10; i++){
            if(task.isDone()){
                break;
            }
            Thread.sleep(1000);
        }

        if(! task.isDone()){
            System.out.println("操作未完成！");
        }
    }
}
