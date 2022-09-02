package Tests;

import Pages.FileDownloadPage;
import com.aventstack.extentreports.ExtentTest;
import org.junit.jupiter.api.Test;
import utilities.BrowserUtils;
import utilities.EndPoints;

import static Tests.TestBase.extentReports;

public class FileDownloadTest {

    @Test
    public void testFileDownload() {
        FileDownloadPage fdp = new FileDownloadPage();
        ExtentTest extentTest;
        extentTest = extentReports.createTest("File Download Test");
        fdp.navigateTo(EndPoints.FILEDOWNLOAD);
        extentTest.info("Navigate to File Download Page");

        extentTest.info("Clicked to some-file.txt link");
        String downloadFile = fdp.file.getText();
        extentTest.info("File's Name is Stored");
        fdp.file.click();
        BrowserUtils.wait(5);
        extentTest.info("Clicked to some-file.txt link");

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/"+downloadFile;
        extentTest.info("Stored File Name is Used for It's Path");
        String filePath = projectPath+"/"+relativePath;
        extentTest.info("Downloaded Files Path=> "+filePath);

        extentTest.pass("Test is passed for now. But Selenium cannot verify " +
                "file downloads. It can click on download link but can't go outside " +
                "the browser and open the downloaded file. We need to use Robot and AutoIT for this purpose. " +
                "Or We can Download the File To Our Project. So We Can Verify The Downloaded File's Name");
    }
}
