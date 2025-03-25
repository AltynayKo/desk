package page.promo;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import page.BasePage;

@Getter
public class PromoPage extends BasePage {

    private static final String PAGE_URL = "https://access.epam.com/auth/realms/plusx/protocol/openid-connect/logout";
    @FindBy(xpath = "//input[@value='Logout']")
    private WebElement logOutBtn;

    public PromoPage(WebDriver driver) {
        super(driver);
    }
}
