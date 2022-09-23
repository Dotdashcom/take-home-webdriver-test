package pages;

import core.AbstractWebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SecurePage extends AbstractWebPage {

    @FindBy(id = "flash")
    protected WebElement bannerElm;

    @FindBy(css = "#content > div > a")
    protected WebElement logoutButtonElm;

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public void doLogout() {
        logoutButtonElm.click();
    }

    public String getSuccessMessage() {
        WebElement errorMsgELm = driver.findElement(By.id("flash"));
        String errorMessage = errorMsgELm.getText().trim();
        return errorMessage;
    }

    public String getFlashBackgroundColor() {
        String backgroundColorValueInHex = bannerElm.getCssValue("background-color");
        return backgroundColorValueInHex;
    }
}
