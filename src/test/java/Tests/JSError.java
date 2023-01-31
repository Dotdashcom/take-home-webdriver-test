package Tests;


import WebdriverFactory.WebDriverFactory;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Pages.All_Pages.*;


@Listeners(UniversalVideoListener.class)
public class JSError {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openJSErrorURL();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void JSError() throws InterruptedException {
           Assert.assertEquals(getText(By.xpath("//p[contains(text(),'This page has a JavaScript error in the onload eve')]")),"This page has a JavaScript error in the onload event. This is often a problem to using normal Javascript injection techniques.");
    }



}
