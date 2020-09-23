package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {

    @FindBy (xpath = "//a[text()='Click here']")
    public WebElement clickHereButton;

    @FindBy(id = "flash")
    public WebElement message;

}
