package MarionelaTirsina;

import MarionelaTirsina.pages.NotificationMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.*;

import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.concurrent.TimeUnit;

public class NotificationMessageTest {
    /**
     * //    Notification Message: http://localhost:7080/notification_message_rendered Test notification Message.
     */
    NotificationMessage notificationMessage= new NotificationMessage();
    @Before
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/notification_message_rendered");
        Driver.getDriver().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    @Test
    public void notificationMessageTest(){

        WebElement clickHere =notificationMessage.clickHereButton;
        clickHere.click();

        String actualNotification = notificationMessage.notification.getText();


        Assert.assertTrue(actualNotification.contains("Action successful") || actualNotification.contains("Action unsuccesful, please try again"));


    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);

    }
}
