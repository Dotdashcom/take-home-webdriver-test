package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationMessagePage {
    public NotificationMessagePage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(linkText = "Click here")
    private WebElement ClickHereLink;

    @FindBy(xpath = "//div[@class='flash notice']")
    private WebElement notificationMessage;

    public void ClickLink(){
        ClickHereLink.click();
    }
    public String NotificationMessage(){
        return notificationMessage.getText();
    }
}
