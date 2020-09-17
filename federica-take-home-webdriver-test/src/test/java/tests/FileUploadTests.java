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
        Driver.getDriver().findElement(By.cssSelector("#file-upload")).sendKeys(path);
        Driver.getDriver().findElement(By.cssSelector("#file-submit")).click();
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
