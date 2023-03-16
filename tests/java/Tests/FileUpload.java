package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FileUpload {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void FileUpload(){
        Driver.getDriver().get("http://localhost:7080/upload");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        String file = "/Users/sashamac/Desktop/cherry.avif";
        Driver.getDriver().findElement(By.cssSelector("[id='file-upload']")).sendKeys(file);
        Driver.getDriver().findElement(By.id("file-submit")).click();
        assertTrue(Driver.getDriver().findElement(By.tagName("h3")).isDisplayed());
    }
}
