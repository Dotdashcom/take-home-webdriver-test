package TakeHome.pages;

import TakeHome.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NotificationMessagePage extends BasePage {

    public NotificationMessagePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//*[@href='/notification_message']")
    private WebElement button;

    @FindBy(id = "flash")
    private WebElement message;

    public String getNotificationText() {
        button.click();
        // There is a "×" in the messages shown which could be a bug. The solution below could fix but changes the actual outcome
        return message.getText().replaceAll("×","").trim();
    }

    public void testMessage1() {
        button.click();
        // There is a "×" in the messages shown which could be a bug. The solution below could fix but changes the actual outcome
        String fakemessage=message.getText().replaceAll("×","").trim();
        try {
            Assert.assertEquals(fakemessage, "Action successful");
            Assert.assertEquals(message.getText(), "Action successful");
            return;
        }catch (AssertionError e){
            try {
                Assert.assertEquals(fakemessage, "Action unsuccesful, please try again");
               Assert.assertEquals(message.getText(), "Action unsuccesful, please try again");
                return;
            }catch (Exception a){
                Assert.assertEquals(fakemessage, "Action Unsuccessful");
                Assert.assertEquals(message.getText(), "Action Unsuccessful");
                return;
            }
        }
    }
}
