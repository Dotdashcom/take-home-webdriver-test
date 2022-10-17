package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {


    @Test
    public void fileUploadTest() throws InterruptedException {

        driver.get(baseUrl+"/upload");

        WebElement chooseFileButton = driver.findElement(By.xpath("//form[@method='POST']//input[@id='file-upload']"));
        WebElement fileUploadButton = driver.findElement(By.xpath("//form[@method='POST']//input[@id='file-submit']"));

        chooseFileButton.sendKeys("C:\\Users\\semih\\Downloads\\some-file.txt");
        fileUploadButton.click();

        WebElement messageAfterUpload = driver.findElement(By.xpath("//div[@id='content']//h3"));

        Assert.assertEquals(messageAfterUpload.getText(),"File Uploaded!","File Upload Test FAILED!");
    }

}
