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


@Listeners(UniversalVideoListener.class)
public class CheckBox {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openCheckBoxUrl();
    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void checkCheckbox() throws InterruptedException {
        click(By.xpath("//*[@id=\'checkboxes\']/input[1]"));
        Assert.assertEquals(isSelectedCheckbox(By.xpath("//*[@id=\'checkboxes\']/input[1]")),true);
    }
    @Test
    @Video
    public void uncheckCheckbox() throws InterruptedException {
        click(By.xpath("//*[@id=\'checkboxes\']/input[1]"));
        Assert.assertEquals(isSelectedCheckbox(By.xpath("//*[@id=\'checkboxes\']/input[1]")),false);
    }

}
