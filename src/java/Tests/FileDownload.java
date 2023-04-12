package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DriverUtilities;

import java.io.File;


public class FileDownload extends DriverUtilities {
    @Before
    public void setUp(){
        createDriver();
        getDriver().navigate().to("http://localhost:7080/download");
    }
    @Test
    public void fileDownloadTest(){
        WebDriver driver = getDriver();
        WebElement downloadLink = driver.findElement(By.linkText("some-file.txt"));
        downloadLink.click();

        File file = new File("/Users/andrii/Downloads");
        Assert.assertTrue(file.exists());
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
