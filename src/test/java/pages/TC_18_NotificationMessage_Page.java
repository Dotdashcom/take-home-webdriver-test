package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_18_NotificationMessage_Page {
    public TC_18_NotificationMessage_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "Notification Messages")
    public WebElement notificationMsgLink;
    @FindBy(xpath = "//a[.='Click here']")
    public WebElement clickHereButton;
    @FindBy(xpath = "//div[@class='large-12 columns']/div")
    public WebElement messages;
}
