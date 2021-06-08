package dotdash.automation.pageobjects;

import dotdash.automation.ui.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePageObject extends BasePageObject {
    @FindBy(id = "flash")
    private WebElement flash;
    @FindBy(linkText = "Click here")
    private WebElement clickHere;
    @FindBy(css="div[id='flash'] a")
    private WebElement close;

    public NotificationMessagePageObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(),this);
    }

    public String getMessage(){
        return flash.getText();
    }
    public String getClosetext(){
        return close.getText();
    }
    public NotificationMessagePageObject clickHere(){
        clickHere.click();
        return this;
    }
}
