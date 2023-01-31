package Tests;


import WebdriverFactory.WebDriverFactory;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import junit.framework.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Pages.All_Pages.*;


@Listeners(UniversalVideoListener.class)
public class iFrame {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openIframeURL();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void iFrame() throws InterruptedException {

        setTextInIframe(By.id("mce_0_ifr"),"");
        setTextInIframe(By.id("mce_0_ifr"),"Automation tests");
        Assert.assertEquals(getText(By.id("mce_0_ifr")),"Automation tests");
    }



}
