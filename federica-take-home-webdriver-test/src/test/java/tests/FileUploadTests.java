package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.TestBase;

public class FileUploadTests extends TestBase {
    String url="upload";

    @Test
    public void fileUpload(){
        Driver.setUp(url);
        String path=System.getProperty("user.dir")+"/test.txt";
        driver.findElement(By.cssSelector("#file-upload")).sendKeys(path);
        driver.findElement(By.cssSelector("#file-submit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
