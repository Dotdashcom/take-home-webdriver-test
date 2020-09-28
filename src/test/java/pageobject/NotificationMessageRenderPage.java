package pageobject;

import base.EndPointPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NotificationMessageRenderPage extends BasePage {

    @FindBy(xpath = "//a[@href='/notification_message']")
    private WebElement loadMessageLink;

    @FindBy(id = "flash")
    private WebElement notificationMessageText;

    public NotificationMessageRenderPage(WebDriver driver) {
        super(driver, EndPointPath.NOTIFICATION_MESSAGE_RENDERED);

    }


    public boolean verifyNotificationMessageRender(List<String> messages) {
        for (int i = 0; i < 3; i++) {
            loadMessageLink.click();
            String message = notificationMessageText.getText().replace("\n×", "");
            if (!messages.contains(message)) {
                return false;
            }
        }
        return true;
    }
}



