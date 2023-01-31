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

import java.util.ArrayList;
import java.util.List;

import static Pages.All_Pages.*;


@Listeners(UniversalVideoListener.class)
public class NewTab {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openNewTab();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void NewTabTest() throws InterruptedException {


        click(By.xpath("//a[@href=\"/windows/new\"]"));
        driver.getWindowHandles();
        List<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(1));
        String Title = driver.getTitle();
        String exp = "New Window";
        Assert.assertEquals(Title, exp);
    }



}
