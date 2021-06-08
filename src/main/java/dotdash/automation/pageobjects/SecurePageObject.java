package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SecurePageObject extends BasePageObject {
    By flashMessage = By.id("flash");
    By subheader = By.className("subheader");

    public SecurePageObject(WebDriver driver)  {
       super(driver);
    }

    public String getFlashMessage() {
        return getDriver().findElement(flashMessage).getText();
    }

    public String getSubHeader(){
        return getDriver().findElement(subheader).getText();
    }

}
