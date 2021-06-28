package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

public class NotificationMessagePage extends PageBase {
    @FindBy(xpath = "//a[@href='/notification_message']")
    protected WebElement notificationMessage;

    @FindBy(xpath = "//div[@id='flash']")
    WebElement message;

    public  void click(){
        notificationMessage.click();
        String actual = message.getText();
        BrowserUtils.notificationMessageAlert(message," Action successful");
    }

}
