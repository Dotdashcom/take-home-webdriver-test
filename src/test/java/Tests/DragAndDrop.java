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
public class DragAndDrop {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openDragAndDrop();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void DragAndDropTest() throws InterruptedException {
        DragDropTest(By.id("column-a"), By.id("column-b"));
        Assert.assertEquals(getText(By.id("column-a")),"A");
        //Assert.assertEquals(getText(By.id("column-b")),"B");
    }



}
