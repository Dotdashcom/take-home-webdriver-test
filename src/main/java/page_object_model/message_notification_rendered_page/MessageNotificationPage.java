package page_object_model.message_notification_rendered_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessageNotificationPage extends Base {
    public MessageNotificationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Click here']")
    private WebElement clickLink;
    @FindBy(xpath = "//div[@id='flash-messages']/div")
    public static WebElement notificationMessage;

    public void setClickLink() {
        clickOnElement(clickLink);
        clickOnElement(clickLink);
        clickOnElement(clickLink);
    }
}
