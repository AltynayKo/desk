package com.elearn.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(50);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }
    abstract BasePage openPage();

}
