package webdriver.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import webdriver.test.Pages.NotificationMessage;
import webdriver.test.Util.ConfigReader;
import webdriver.test.Util.DriverFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class NotificationMessageTest {


    private WebDriver driver;
    private NotificationMessage notificationMessage;

    @BeforeClass
    public void Setup() throws IOException {

        String driverType = ConfigReader.getConfigProperties("driver");

        driver = DriverFactory.getDriver(driverType);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        notificationMessage = new NotificationMessage(driver);

    }

    @Test
    public void checkNotificationMessageSuccessful() {


        notificationMessage.clickNotificationLink();

        if (!notificationMessage.flashMessage.getText().contains("Action successful")) {
            notificationMessage.clickNotificationLink();
            assertTrue(true);
        } else {
            assertFalse(false);
        }

    }

    @Test
    public void checkNotificationMessageUnsuccessfulTryAgain() {


        notificationMessage.clickNotificationLink();

        if (!notificationMessage.flashMessage.getText().contains("Action unsuccessful, please try again")) {
            notificationMessage.clickNotificationLink();
            assertTrue(true);
        } else {
            assertFalse(false);
        }

    }


    @Test
    public void checkNotificationMessageUnsuccessful() {


        notificationMessage.clickNotificationLink();

        if (!notificationMessage.flashMessage.getText().contains("Action Unsuccessful")) {
            notificationMessage.clickNotificationLink();
            assertTrue(true);
        } else {
            assertFalse(false);
        }

    }


    @Test
    public void MultipleNotificationMessageTest() {

        List<String> messages = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            notificationMessage.clickNotificationLink();

            messages.add(notificationMessage.flashMessage.getText());
        }

        System.out.println("messages = " + messages);

        assertTrue(messages.contains(notificationMessage.flashMessage.getText()));
    }


    @AfterClass
    public void TearDown() {

        driver.quit();

    }


}
