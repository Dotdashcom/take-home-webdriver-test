package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.CommonMethods;
@Test
public class FileUploadTest extends CommonMethods {
    public static void main(String[]args){
        setUp("http://localhost:7080/upload");

        WebElement selectFile = driver.findElement(By.id("file-upload"));
        selectFile.sendKeys("/Users/artyomburenko/Desktop/Google.png");

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        //verifying if success message is displayed after uploading the file
        WebElement successMessage = driver.findElement(By.xpath("//h3[contains(text(), 'File Uploaded!')]"));
        boolean successMessageIsPresent = successMessage.isDisplayed();
        Assert.assertTrue(successMessageIsPresent, "Failed to upload the file");
        System.out.println("The test is passed. File is uploaded");

        tearDown();
    }
}
