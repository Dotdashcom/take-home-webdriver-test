package MarionelaTirsina;

import MarionelaTirsina.pages.FileUpload;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import utilities.ConfigurationReader;
import utilities.Driver;

import javax.swing.*;
import java.io.File;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    //    File Upload: http://localhost:7080/upload
    //    Test File Upload.
    FileUpload fileUpload=new FileUpload();
    @Before
    public void setUpMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url") + "/upload");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


    @Test
    public void fileUploadTest()  {

       String filePath= fileUpload.uploadFile("src/test/java/testData/competency-portfolio-learning.png");
fileUpload.uploadFileButton.sendKeys(filePath);
fileUpload.fileSubmitButton.click();

  String actual=   fileUpload.assertHeader.getText();
  String expected= "File Uploaded!";
  Assert.assertEquals(actual, expected);

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(2000);

    }
}
