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
public class DynamicLoading {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openDynamicLoading();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void DynamicLoading() throws InterruptedException {

        click(By.xpath("//button"));
        Assert.assertTrue(isDisplayed(By.xpath("//div[@id=\'finish\']/child::h4[contains(text(),\'Hello World!\')]")));
    }



}
