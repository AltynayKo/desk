package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;
import service.BasePageService;

public class JSExecutorUtil{
    public static JavascriptExecutor jsExecutor;
    public static void clickButtonUsingJS(WebDriver driver, WebElement clickElement) {
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", clickElement);
    }
}
