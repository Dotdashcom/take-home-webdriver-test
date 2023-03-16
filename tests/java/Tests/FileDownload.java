package Tests;

import Tests.Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileDownload {
    @BeforeTest
    public void setup(){
    }
    @AfterTest
    public void teardown() {
        Driver.closeDriver();
    }
    @Test
    public void FileDownload(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        Driver.getDriver().get("http://localhost:7080/download");
        WebElement file = Driver.getDriver().findElement(By.xpath("//a[text()='some-file.txt']"));
        wait.until(ExpectedConditions.visibilityOf(file));
        file.click();
    }
}
