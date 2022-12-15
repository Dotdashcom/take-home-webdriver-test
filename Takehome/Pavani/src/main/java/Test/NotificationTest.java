package Test;

import Utilities.DriverHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import Main.NotificationPage;

public class NotificationTest {

    NotificationPage message= new NotificationPage();

    @Test
    public void MessageTest() {

        DriverHelper.getDriver().get("http://localhost:7080/notification_message_rendered");

        DriverHelper.getDriver().manage().window().maximize();


        message.clickButton.click();

        Assert.assertEquals(message.Message.getText(),"Action unsuccesful, please try again\n" +
                "×");

        message.clickButton.click();

        Assert.assertEquals(message.Message.getText(),"Action successful\n" +
                "×");

        DriverHelper.closeDriver();
    }
}