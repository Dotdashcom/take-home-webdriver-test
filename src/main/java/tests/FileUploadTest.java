package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.utils;

import java.io.File;


public class FileUploadTest {
    FileUploadPage fileUploadPage;

    public FileUploadTest() {
        fileUploadPage = new FileUploadPage();
    }

    @Test
    public void fileUploadTest() {
        WebDriver driver = TestBase.getInstance().getDriver();
        driver.get(utils.url + "/upload");

        String filePath = "./uploadFile/testfile.txt";
        String expectedMessage = "File Uploaded!";

        File file = new File(filePath);
        String path = file.getAbsolutePath();

        fileUploadPage.getUploadLink().sendKeys(path);
        fileUploadPage.getUploadBtn().click();

        String actualMessage = fileUploadPage.getUploadSuccessMessage().getText();

        try {
            Assert.assertEquals(actualMessage, expectedMessage);
            System.out.println("Actual: " + actualMessage + "\n" + "Expected: " + expectedMessage + "\n" + "passed");
        } catch (AssertionError e) {
            System.out.println(" failed");
            throw e;
        }
    }

    @AfterTest
    public void teardown() {
        TestBase.getInstance().getDriver().quit();
    }
}



