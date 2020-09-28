package testcase;

import base.SingletonWebDriver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobject.HoverPage;
import pageobject.NotificationMessageRenderPage;

import java.util.Arrays;
import java.util.List;

public class NotificationMessageRenderTest {

    private WebDriver driver;
    private NotificationMessageRenderPage notificationMessageRenderPage;
    private final static List<String> messages = Arrays.asList("Action unsuccesful, please try again",
            "Action successful",
            "Action unsuccesful, please try again");

    @BeforeClass
    public void setup() {
        driver = SingletonWebDriver.getInstanceOfSingletonBrowser().getDriver();
        this.notificationMessageRenderPage = new NotificationMessageRenderPage(driver);
    }

    @AfterClass
    public void tearDown() {
        SingletonWebDriver.getInstanceOfSingletonBrowser().destroy();
    }

    @Test
    public void verifyExistedNotificationMessage() {
        Assert.assertTrue(notificationMessageRenderPage.verifyNotificationMessageRender(messages));

    }


}
