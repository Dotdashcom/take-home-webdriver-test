package tests;

import Utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;

public class FileDownLoadTest {

    @BeforeTest
    public void setup(){
        Driver.setupDriver();
        Driver.getDriver().navigate().to("http://localhost:7080/download");
    }

    @Test
    public void fileDownload() {
        WebElement fileLink = Driver.getDriver().findElement(By.linkText("file.txt"));
        String fileName = fileLink.getAttribute("href").split("/")[3];
        fileLink.click();
        File file = new File("path/to/downloads/" + fileName);
        Assert.assertTrue(file.exists());
    }


    @AfterTest
    public void done() {
        Driver.getDriver().quit();
    }
}
