package Tests;


import WebdriverFactory.WebDriverFactory;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Pages.All_Pages.*;


@Listeners(UniversalVideoListener.class)
public class ContextMenu {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openContextBoxUrl();
    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void ContextMenu() throws InterruptedException {
        RightClick(By.id("hot-spot"));
        Alert context = driver.switchTo().alert();
        String actual = context.getText();
        String exp = "You selected a context menu";
        Assert.assertEquals(actual,exp,"The alert menu text did not match");

    }

}
