package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {

    @FindBy(linkText = "Click here")
    public WebElement clickHere;

    @FindBy(id = "flash")
    public WebElement message;
}
