package Tests;


import WebdriverFactory.WebDriverFactory;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static Pages.All_Pages.*;


@Listeners(UniversalVideoListener.class)
public class NotificationMsg {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openNotifications();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void Notification() throws InterruptedException {

        for (int i = 0; i <= 5; i++) {
            click(By.xpath("//a[contains(text(),\"Click here\")]"));
            String msg = getText(By.xpath("//*[@id='flash']"));
            Assert.assertTrue(msg.contains("Action successful") || msg.contains("Action unsuccesful, please try again") || msg.contains("Action Unsuccessful"));
        }


    }
}
