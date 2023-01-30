package Tests;


import WebdriverFactory.WebDriverFactory;
import com.automation.remarks.testng.UniversalVideoListener;
import com.automation.remarks.video.annotations.Video;
import junit.framework.Assert;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

import static Pages.All_Pages.*;


@Listeners(UniversalVideoListener.class)
public class FileDownload {

    public static WebDriver driver = null;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
        driver = WebDriverFactory.getDriver();
        openFileDwonloadRL();

    }

    @AfterTest
    public void closeBrowser() {
        WebDriverFactory.closeDriver();
    }

    @Test
    @Video
    public void filedownload() throws InterruptedException {
        String downloadPath = FileUtils.getUserDirectoryPath();
        File downloadDirectory = new File(downloadPath,"Downloads");
        click(By.xpath("//*[@id=\'content\']/div/a"));
        File filename = new File(downloadDirectory, getText(By.xpath("//*[@id=\'content\']/div/a")));
        System.out.println(filename.getAbsolutePath());
        Assert.assertTrue(filename.isFile());

    }



}
