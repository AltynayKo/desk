package service;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.time.Duration;

public abstract class BasePageService {
    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(100);
    protected WebDriverWait wait;
    protected WebDriver driver;

    protected abstract BasePage getPage();
    protected abstract String getPageUrl();

    public BasePageService (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
    }

}
