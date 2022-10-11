package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends BasePage {

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Click here']")
    public WebElement clickHereLink;

    @FindBy(id = "flash")
    public WebElement notificationMsg;
}
