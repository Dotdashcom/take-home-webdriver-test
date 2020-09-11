package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Click here')]")
    WebElement clickHereButton;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement notificationMessage;

    public NotificationMessagePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean testNotificationMessage(WebDriver driver) {
        boolean isNotifPresent = false;
        clickOnElement(driver, clickHereButton, "Success: Clicked on Click here button",
                "Failed: Unable to click on Click here button");
        if (isElementPresent(driver, notificationMessage)) {
            isNotifPresent = true;
            System.out.println("Notification is present: " + notificationMessage.getText());
        }
        return isNotifPresent;
    }
}
