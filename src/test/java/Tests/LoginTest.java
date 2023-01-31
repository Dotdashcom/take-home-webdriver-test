package Tests;


import WebdriverFactory.WebDriverFactory;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Pages.All_Pages.*;
import static Pages.All_Pages.verify;


@Listeners(UniversalVideoListener.class)
public class LoginTest {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() {
        driver = WebDriverFactory.getDriver();
    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void test_CheckLogin_successful() throws InterruptedException {

        login_correct();
        String text1=getText(By.id("flash"));
        System.out.println(text1);
        Assert.assertTrue(text1.contains("You logged into a secure"));
        logout();
    }
    @Test
    @Video
    public void test_CheckLogin_unsuccessful() throws InterruptedException {

        login_incorrect();
        String text2=getText(By.id("flash"));
        System.out.println(text2);
        Assert.assertTrue(text2.contains("Your password is invalid"));
           }
}
