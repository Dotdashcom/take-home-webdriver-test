package specs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NotificationPage;
import pages.WindowsPage;
import utils.CommonUtils;

import java.util.concurrent.TimeUnit;

public class DotDashNotificationTest {
    WebDriver driver;
    NotificationPage notificationPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", CommonUtils.getChromeDriverPath());
        driver = new ChromeDriver();
        notificationPage = new NotificationPage(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testNotifications() {
        notificationPage.validatePageTitle();
        notificationPage.verifyNotification();
    }

    @After
    public void close() {
        CommonUtils.tearDownAfterTest(driver);
    }
}
