import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NotificationMessagePage extends PageObject{
    @FindBy(xpath = "//a[contains(text(),\"Click here\")]")
    public WebElement link;
    @FindBy(css = ".flash.notice")
    public WebElement message;
    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }
    public void notificationMsg()
    {
        String msg1 = "Action successful";
        String msg2 = "Action unsuccesful, please try again";
        link.click();
        Assert.assertTrue(message.getText().contains(msg1)||message.getText().contains(msg2));

    }
}
