package service.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import page.home.HomePage;
import service.BasePageService;
import service.promo.PromoPageService;
import model.User;

import static org.openqa.selenium.Keys.ENTER;
import static util.ActionsUtil.*;
import static util.JSExecutorUtil.*;

public class HomePageService extends BasePageService {
    private final HomePage homePage;

    @Override
    protected HomePage getPage() {
        return homePage;
    }

    @Override
    protected String getPageUrl() {
        return null;
    }

    public HomePageService(WebDriver driver) {
        super(driver);
        this.homePage = new HomePage(driver);
    }

    public HomePageService loginWithEpamAccount(User user){
        wait.until(ExpectedConditions.visibilityOf(homePage.getUsernameInput()));
        homePage.getUsernameInput().sendKeys(user.getUsername());
        wait.until(ExpectedConditions.visibilityOf(homePage.getPasswordInput()));
        homePage.getPasswordInput().sendKeys(user.getPassword());
        homePage.getContinueBtn().click();

        return this;
    }
    public HomePageService repeatBookingPlace(){
        homePage.getCompletedTab().click();
        homePage.getMoreOptionsBtn().click();
        homePage.getRepeatOption().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'uui-fill-solid') and contains(@class, 'uui-color-green')]")));
        clickButtonUsingJS(driver, homePage.getCreateBtn());
        if (homePage.getStepModalContent().isDisplayed()){
            homePage.getBookNewBtn().click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uui-snackbar-item-self")));
        return this;
    }
    public PromoPageService logOut(){
        homePage.getNarrowBtn().click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("uui-dropdown-body")));
        homePage.getLogOutLink().click();
        return new PromoPageService(driver);
    }
    public String getHoverOverBtnText(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getAddColleaguesBtn()));
        return homePage.getTextOverHoverBtn().getText();
    }
    public boolean isPeopleSearchResultBlockDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getPeopleSearchResultBlock()));
        return homePage.getPeopleSearchResultBlock().isDisplayed();
    }
    public HomePageService hoverOverAddColleaguesBtn(){
        wait.until(ExpectedConditions.visibilityOf(homePage.getAddColleaguesBtn()));
        hoverOverElement(driver, homePage.getAddColleaguesBtn());
        return this;
    }
    public HomePageService searchPeople(String searchCriteria){
        wait.until(ExpectedConditions.visibilityOf(homePage.getSearchPeopleInput()));
        homePage.getSearchPeopleInput().sendKeys(searchCriteria);
        pressKeys(driver, ENTER);
        return this;
    }
    public boolean isLogoDisplayed(){
        return homePage.getLogo().isDisplayed();
    }
    public String getToastMessage(){
        return homePage.getToastElement().getText();
    }
}
