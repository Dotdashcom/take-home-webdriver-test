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
import static Pages.All_Pages.getText;


@Listeners(UniversalVideoListener.class)
public class JSAlerts {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openJSALerrtsURL();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void JSAlerts() throws InterruptedException {
        click(By.xpath("//button[contains(text(),\'Click for JS Alert\')]"));
        Alert a = driver.switchTo().alert();
        a.dismiss();
        Assert.assertEquals(getText(By.id("result")), "You successfuly clicked an alert");
        click(By.xpath("//button[contains(text(),\'Click for JS Confirm\')]"));
        Alert b = driver.switchTo().alert();
        b.accept();
        Assert.assertEquals(getText(By.id("result")),"You clicked: Ok");
        click(By.xpath("//button[contains(text(),\'Click for JS Prompt\')]"));
        Alert c = driver.switchTo().alert();
        c.sendKeys("Automation");
        c.accept();
        Assert.assertEquals(getText(By.id("result")), "You entered: Hello");

          }



}
