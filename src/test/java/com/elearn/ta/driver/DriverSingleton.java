package com.elearn.ta.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if (driver==null){
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
