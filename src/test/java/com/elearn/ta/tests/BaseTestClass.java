package com.elearn.ta.tests;

import com.elearn.ta.driver.DriverSingleton;
import com.elearn.ta.util.ConfigReader;
import model.User;
import com.elearn.ta.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;

import static com.elearn.ta.driver.DriverSingleton.driver;
import static com.elearn.ta.driver.DriverSingleton.getDriver;

@Listeners(TestListener.class)
public class BaseTestClass {
    public Logger logger;
    public User currentUser;
    @BeforeClass
    @Parameters({"os", "browser"})
    public void setUp(String os, String browser) throws IOException {
        ConfigReader.loadProperties();
        logger = LogManager.getLogger(this.getClass());
        currentUser = ConfigReader.getUserData();

        if (ConfigReader.getExecutionEnvironment().equalsIgnoreCase("remote")) {
            DriverSingleton.getRemoteDriver(os, browser);
            logger.info("Running tests in REMOTE on {} with {}", os, browser);
        } else {
            DriverSingleton.getLocalDriver(browser);
            logger.info("Running tests LOCALLY with setup with {}:", browser);
        }
        getDriver().get(ConfigReader.getBaseUrl());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverSingleton.closeDriver();
        logger.info("Driver removed");
    }
}
