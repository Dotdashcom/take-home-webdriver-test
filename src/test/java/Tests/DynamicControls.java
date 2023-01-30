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

import static Pages.All_Pages.*;


@Listeners(UniversalVideoListener.class)
public class DynamicControls {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openDynamicCOntrolURL();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void DynamicControls() throws InterruptedException {

        click(By.xpath("//button[@type=\"button\" and contains(text(),\"Remove\")]"));
        Assert.assertTrue(isDisplayed(By.xpath("//button[normalize-space()='Add']")));
        Assert.assertTrue(isDisplayed(By.xpath("//input[@type=\"checkbox\"]")));
        click(By.xpath("//button[normalize-space()='Enable']"));
        Assert.assertTrue(isEnabled(By.xpath("//button[@type=\"button\" and @onclick=\"swapInput()\"]")));
        click(By.xpath("//button[@type=\"button\" and contains(text(),'Disable')]"));
        Assert.assertFalse(isEnabled(By.xpath("//input[@type=\"text\"]")));


    }
}
