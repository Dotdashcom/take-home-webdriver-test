package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_011_FileUpLoad extends BaseClass
{
    @Test (priority=11) // Test case for file upload
    public void FileUpload() throws  InterruptedException
    {
       //Launching File Upload Url
        driver.get(BaseUrl+"upload");
        //Inspecting File Upload WEbElement
        WebElement Upload = driver.findElement(By.id("file-upload"));
        //Uploading file using SendKeys Method
        Upload.sendKeys("C:\\Users\\shahi\\Downloads\\some-file.txt");
        //Clicking on File upload Button
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
        //Assertion to check File Upload
        if(driver.getPageSource().contains("File Uploaded!"))
        {
            Assert.assertTrue(true);
            System.out.println("File Upload Assertion Pass");
        } else {
            Assert.assertTrue(false);
        }


    }
}
