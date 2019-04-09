package com.basics.tests;

import com.basics.utils.RangeDatabyPOI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;

public class TestParameter {

    WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @DataProvider(name = "mooc")
    public Object [][] getData() throws IOException {
        String path = System.getProperty("user.dir")+"/test-classes/data/testdata.xls";
        Object [][] data = RangeDatabyPOI.poiRangeData(path, "Sheet1");

        return data;
    }

    @Parameters({"browser", "url"})
    @BeforeTest
    public void before(String browser, String url){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "test-classes/driver/chromedriver");
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "test-classes/driver/geckodriver-win64.exe");
            driver = new FirefoxDriver();
        }else{
            System.out.println("your broeser not supported");
        }
        driver.manage().window().maximize();
        driver.get(url);

    }

    @Test(dataProvider = "mooc")
    public void test01(String s1, String s2) throws InterruptedException {
        WebElement input = driver.findElement(By.id("kw"));
        input.clear();
        input.sendKeys(s1);
        Thread.sleep(1000);
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        input.clear();
        input.sendKeys(s2);
        Thread.sleep(1000);
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        logger.info("search success");

    }

    @AfterTest
    public void after(){
        driver.quit();
    }

}
