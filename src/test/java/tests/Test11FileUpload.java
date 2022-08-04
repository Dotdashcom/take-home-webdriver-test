package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Test11FileUpload extends GenericTest {

    @Test
    public void Test11FileUpload() throws InterruptedException {
        String url = "http://localhost:7080/upload";
        String filePath = "/Users/" + System.getProperty("user.name") + "/Downloads/some-file.txt";
        driver.get(url);

        By uploadInputXpath = By.xpath("//input[@id='file-upload']");
        By uploadButtonXpath = By.xpath("//input[@class='button']");
        By uploadedLabelXpath = By.xpath("//div[@id='uploaded-files']");
        driver.findElement(uploadInputXpath).sendKeys(filePath);
        driver.findElement(uploadButtonXpath).click();
        Assert.assertTrue(driver.findElement(uploadedLabelXpath).isDisplayed());
    }

}