package scenarios;

import base.BaseTest;
import constants.FilePaths;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.FileUploadPage;

public class FileUploadTest extends BaseTest {
    private FileUploadPage fileUploadPage;

    @BeforeMethod
    public void setup() {
        fileUploadPage = homePage.gotoFileUploadPage();
    }

    @Test
    public void fileUploadTest() {
        String filename = "some-file.txt";
        String uploadedFileName = fileUploadPage.enterFilePath(FilePaths.TEST_DATA + filename)
                .clickUploadButton()
                .getUploadedFilePanelText();

        Assert.assertEquals(uploadedFileName, filename);
    }
}