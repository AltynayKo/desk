package com.elearn.ta.util;

import com.elearn.ta.driver.DriverSingleton;
import com.elearn.ta.tests.BaseTestClass;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener, IInvokedMethodListener {
    private static final String DELIMITER = "=========================================================================";
    private final Logger log = LogManager.getRootLogger();
    public void onTestFailure(ITestResult iTestResult){
        saveScreenshot();
    }
    private void saveScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    "//target/screenshots/"
                    + getCurrentTimeAsString() + ".png"));
        } catch (IOException e){
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            log.info(DELIMITER);
            log.info("{} {}", "Start executing", method.getTestMethod());
            log.info("Description: " + method.getTestMethod().getDescription());
            log.info(DELIMITER);
        }
    }
}
