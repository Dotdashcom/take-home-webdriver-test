import Pages.NotificationPage;
import Utils.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessageTest {

    NotificationPage message= new NotificationPage();

    @Test
    public void MessageTest() {

        Driver.getDriver().get("http://localhost:7080/notification_message_rendered");

        Driver.getDriver().manage().window().maximize();

        message.clickButton.click();

        Assert.assertEquals(message.Message.getText(),"Action unsuccesful, please try again\n" +
                "×");

        message.clickButton.click();

        Assert.assertEquals(message.Message.getText(),"Action successful\n" +
                "×");

        Driver.closeDriver();
    }
}