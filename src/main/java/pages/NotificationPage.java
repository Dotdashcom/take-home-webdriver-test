package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class NotificationPage extends TestBase {
    @FindBy(css = "a[href='/notification_message']")
    WebElement clickHereLink;
    @FindBy(id = "flash")
    WebElement notificationMessage;

    public NotificationPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }

    public void clickHereLink() {
        clickHereLink.click();
    }

    public WebElement getNotificationMessage() {
        return notificationMessage;
    }

}
