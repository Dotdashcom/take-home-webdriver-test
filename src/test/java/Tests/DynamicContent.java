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
public class DynamicContent {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openRereshURL();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void RefreshTest() throws InterruptedException {
        refreshBrowser();
        String image1=getSRC(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"));
        refreshBrowser();
        String image2 = getSRC(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img"));
        Assert.assertNotSame(image1,image2);
    }



}
