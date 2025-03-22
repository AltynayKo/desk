package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.BasePage;

import static org.openqa.selenium.Keys.ENTER;

public class ActionsMainPage extends BasePage {
    private Actions actions;

    @FindBy(xpath = "//*[text()='Add favorite places']")
    private WebElement addColleaguesBtn;
    @FindBy(xpath = "//input[@placeholder='Search people']")
    private WebElement searchPeopleInput;
    @FindBy(xpath = "//div[contains(@class, 'uui-dropdown-body')]")
    private WebElement peopleSearchResultBlock;
    @FindBy(xpath = "//div[@class='uui-tooltip-body']")
    private WebElement textOverHoverBtn;

    public ActionsMainPage(WebDriver driver){
        super(driver);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
    private void hoverOverElement(WebElement element){
        actions.moveToElement(element).perform();
    }
    private void pressKeys(Keys key){
        actions.keyDown(key).perform();
    }
    public String getHoverOverBtnText(){
        return textOverHoverBtn.getText();
    }
    public boolean isPeopleSearchResultBlockDisplayed(){
        return peopleSearchResultBlock.isDisplayed();
    }
    public ActionsMainPage hoverOverAddColleaguesBtn(){
         hoverOverElement(addColleaguesBtn);
         return this;
    }
    public ActionsMainPage searchPeople(String searchCriteria){
        searchPeopleInput.sendKeys(searchCriteria);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class, 'uui-dropdown-body')]")));
        pressKeys(ENTER);
        return this;
    }
}
