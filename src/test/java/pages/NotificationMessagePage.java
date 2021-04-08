package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


public class NotificationMessagePage {
    public NotificationMessagePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[text()='Click here']")
    public WebElement clickHere;

    @FindBy(id = "flash")
    public WebElement notificationText;
}
