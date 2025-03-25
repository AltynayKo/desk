package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.home.HomePage;
import service.BasePageService;

import static org.openqa.selenium.Keys.ENTER;

public class ActionsUtil {

    public static Actions actions;

    public static void hoverOverElement(WebDriver driver, WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public static void pressKeys(WebDriver driver, Keys key){
        actions = new Actions(driver);
        actions.keyDown(key).perform();
    }
}
