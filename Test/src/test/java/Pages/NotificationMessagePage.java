package Pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotificationMessagePage extends PageBase {

    @FindBy(xpath = "//a[@href='/notification_message']")
    WebElement notificationMessage;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement message;

    public  void clickHere(){
        BrowserUtils.click(notificationMessage);
        BrowserUtils.getElementText(message);
        BrowserUtils.notificationMessageAlert(message," Action successful");
    }

}
