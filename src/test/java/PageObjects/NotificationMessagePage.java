package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {

    @FindBy (xpath = "//a[@href='/notification_message']")
    public WebElement clickHereBtn;

    @FindBy (id = "flash")
    public WebElement notificationMessage;
}
