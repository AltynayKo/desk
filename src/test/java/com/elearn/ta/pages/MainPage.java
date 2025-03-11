package com.elearn.ta.pages;

import com.elearn.ta.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends BasePage{
    @FindBy(name ="username")
    private WebElement usernameInput;
    @FindBy(name ="password")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@id='kc-login' and @type='submit']")
    private WebElement continueBtn;
    @FindBy(xpath = "//*[text()='Completed']/parent::*")
    private WebElement completedTab;
    @FindBy(xpath = "//*[contains(text(), 'Active')]/parent::*")
    private WebElement activeTab;
    @FindBy(css = ".table-actions-toggle")
    private WebElement moreOptionsBtn;
    @FindBy(xpath = "//span[normalize-space()='Repeat']")
    private WebElement repeatOption;
    @FindBy(xpath = "//button[@class='uui-button-box uui-enabled -clickable KIwLfu VJ63bY uui-button uui-fill-solid uui-color-green uui-size-36']") //button[contains(@class, 'uui-fill-solid') and contains(@class, 'uui-color-green')]")
    private WebElement createBtn;
    @FindBy(xpath = "//span[normalize-space()='Cancel']")
    private WebElement cancelOption;
    @FindBy (className = "uui-modal-window")
    private WebElement stepModalContent;
    @FindBy(xpath = "//*[text()='Book new']/parent::*")
    private WebElement bookNewBtn;
    @FindBy(css = ".uui-snackbar-item-self")
    private WebElement toastElement;
    @FindBy(xpath = "//a[contains(@href, 'logout')]")
    private WebElement logOutLink;
    @FindBy(xpath = "//button[@class='_0vJ4b7 -clickable']//div//div[@class='ILgLN0 uui-icon uui-enabled']")
    private WebElement narrowBtn;
    @FindBy(id = "kc-content-wrapper")
    private WebElement loggingOutBlock;
    @FindBy(xpath = "//img[@alt='Main Menu Logo']")
    private WebElement logo;



    @FindBy(xpath = "//b[contains(text(), 'Type')]/following-sibling::*")
    private WebElement typeDropdown;
    @FindBy(xpath = "//div[@role='option']")
    private List<WebElement> typeDropdownOptions;


    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MainPage loginWithEpamAccount(User user){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        continueBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home")));
        return this;
    }
    public ActionsMainPage loginWithEpamAccountActPage(User user){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameInput.sendKeys(user.getUsername());
        passwordInput.sendKeys(user.getPassword());
        continueBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home")));
        return new ActionsMainPage(driver);
    }
    public MainPage repeatBookingPlace(){
        completedTab.click();
        moreOptionsBtn.click();
        repeatOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'uui-fill-solid') and contains(@class, 'uui-color-green')]")));
        if (createBtn.isDisplayed()){
            createBtn.click();
        }
        if (stepModalContent.isDisplayed()){
            bookNewBtn.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uui-snackbar-item-self")));
        return this;
    }
    public PromoPage logOut(){
        narrowBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uui-dropdown-body")));
        logOutLink.click();
        return new PromoPage(this.driver);
    }
    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }
    public String getToastMessage(){
        return toastElement.getText();
    }
}
