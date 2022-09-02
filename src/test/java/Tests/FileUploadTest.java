package Tests;

import Pages.FileUploadPage;
import com.aventstack.extentreports.ExtentTest;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import utilities.TestLogics;

import static Tests.TestBase.extentReports;

public class FileUploadTest {

    @Test
    public void testFileDownload() {
        FileUploadPage fup = new FileUploadPage();
        ExtentTest extentTest;
        extentTest = extentReports.createTest("File Upload Test");
        fup.navigateTo(TestLogics.FILEUPLOAD);
        extentTest.info("Navigate to File Upload Page");
        fup.chooseFileLink.sendKeys("C:\\Users\\computer\\Desktop\\1.doc");
        extentTest.info("Uploading path is chosen and sent");

        fup.uploadButton.click();
        extentTest.info("Clicked to uploadButton");

        Assert.assertTrue(fup.uploadedMessage.isDisplayed());
        extentTest.info("Success Message is Displayed => "+fup.uploadedMessage.getText());

        Assert.assertTrue(fup.uploadedFileName.isDisplayed());
        extentTest.info("Uploaded File's Name is Displayed => "+fup.uploadedFileName.getText());
        extentTest.pass("File Upload Test is Successful");
    }
}
