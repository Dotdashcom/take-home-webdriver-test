package webdrivertestcases;

import common.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import webdrivertestpages.FileUpload;

/*
 * For file upload I used the sendKeys() method where I have passed the path of the file I am
 * uploading as a parameter.
 *
 */

public class FileUploadTest extends Base {
    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = getDriver();
        driver.get("http://localhost:7080/upload");
    }

    @Test
    public void fileDownloadTest(){
        FileUpload fl = new FileUpload(driver);
        fl.fileUpload("/Users/miftahchowdhury/Desktop/Resume Miftah Chowdhury.docx");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
