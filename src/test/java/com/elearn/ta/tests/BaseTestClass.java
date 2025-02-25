package com.elearn.ta.tests;

import com.elearn.ta.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTestClass {
    protected WebDriver driver;
    private final String URL = "https://spbdev.cl1-default-lb.epm-osm-anthos.eu.gcp.cloudapp.epam.com";

    @BeforeClass
    public void setUp(){
        driver = DriverSingleton.getDriver();
        driver.get(URL);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverSingleton.closeDriver();
    }
}
