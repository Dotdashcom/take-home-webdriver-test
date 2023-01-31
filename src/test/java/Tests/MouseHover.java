package Tests;


import WebdriverFactory.WebDriverFactory;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Pages.All_Pages.*;
import static Pages.All_Pages.mouseHoverTest;


@Listeners(UniversalVideoListener.class)
public class MouseHover {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openmouseHover();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void MousHover() throws InterruptedException {
        mouseHoverTest(By.xpath("//div[@class=\'figure\'][1]"));
        Assert.assertTrue(isDisplayed(By.xpath("//div[@class='figure'][1]")));
        mouseHoverTest(By.xpath("(//img[@alt='User Avatar'])[2]"));
        Assert.assertTrue(isDisplayed(By.xpath("(//img[@alt='User Avatar'])[2]")));
        mouseHoverTest(By.xpath("(//img[@alt='User Avatar'])[3]"));
        Assert.assertTrue(isDisplayed(By.xpath("(//img[@alt='User Avatar'])[3]")));
        mouseHoverTest(By.xpath("//h5[contains(text(),\'name: user3\')]"));

    }



}
