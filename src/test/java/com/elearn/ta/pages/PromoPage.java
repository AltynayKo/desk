package com.elearn.ta.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromoPage extends BasePage{

    private static final String PAGE_URL = "https://access.epam.com/auth/realms/plusx/protocol/openid-connect/logout?redirect_uri=https://desk.epam.com/promo";
    @FindBy(xpath = "//input[@value='Logout']")
    private WebElement logOutBtn;
    public PromoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public PromoPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }
}
