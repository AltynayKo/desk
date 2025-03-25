package service.promo;

import org.openqa.selenium.WebDriver;
import page.BasePage;
import page.promo.PromoPage;
import service.BasePageService;

public class PromoPageService extends BasePageService {
    public PromoPage promoPage;
    @Override
    public PromoPage getPage() {
        return promoPage;
    }

    @Override
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public PromoPageService(WebDriver driver) {
        super(driver);
    }

    public PromoPageService openPage(){
        driver.navigate().to(getPageUrl());
        return this;
    }
}
