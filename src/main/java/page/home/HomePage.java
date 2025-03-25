package page.home;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasePage;


@Getter
public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath ="//input[@id='username']")
    public WebElement usernameInput;
    @FindBy(xpath ="//input[@id='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//input[@id='kc-login' and @type='submit']")
    public WebElement continueBtn;
    @FindBy(xpath = "//*[text()='Completed']/parent::*")
    public WebElement completedTab;
    @FindBy(xpath = "//*[contains(text(), 'Active')]/parent::*")
    private WebElement activeTab;
    @FindBy(css = ".table-actions-toggle")
    public WebElement moreOptionsBtn;
    @FindBy(xpath = "//span[normalize-space()='Repeat']")
    public WebElement repeatOption;
    @FindBy(xpath = "//button[@class='uui-button-box uui-enabled -clickable KIwLfu VJ63bY uui-button uui-fill-solid uui-color-green uui-size-36']") //button[contains(@class, 'uui-fill-solid') and contains(@class, 'uui-color-green')]")
    public WebElement createBtn;
    @FindBy(xpath = "//span[normalize-space()='Cancel']")
    private WebElement cancelOption;
    @FindBy (className = "uui-modal-window")
    public WebElement stepModalContent;
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
    @FindBy(xpath = "//div[contains(@class, 'uui-dropdown-body')]")
    private WebElement searchOption;


    //---------------FOR ACTIONS---------------------//

    @FindBy(xpath = "//*[text()='Add favorite places']")
    private WebElement addColleaguesBtn;
    @FindBy(xpath = "//input[@placeholder='Search people']")
    private WebElement searchPeopleInput;
    @FindBy(xpath = "//div[contains(@class, 'uui-dropdown-body')]")
    private WebElement peopleSearchResultBlock;
    @FindBy(xpath = "//div[@class='uui-tooltip-body']")
    private WebElement textOverHoverBtn;

}
