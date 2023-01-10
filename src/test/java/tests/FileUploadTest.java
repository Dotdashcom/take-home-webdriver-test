package tests;

import model.FileUploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class FileUploadTest extends BaseTest {

    @Test
    public void testUploadFileViaButton() {
        String expectedResult = new FileUploadPage(getDriver()).getFileNameToUpload();

        String actualResult = new FileUploadPage(getDriver())
                .getFileUploadPage()
                .createFileToUpload()
                .chooseUploadFile()
                .clickUploadButton()
                .getUploadedFileConfirmationText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testDragAndDropAddFileToUpload() {
        boolean actualResult = new FileUploadPage(getDriver())
                .getFileUploadPage()
                .createFileToUpload()
                .dragAndDropFile()
                .isFileToUploadAddedToDragAndDropArea();

        Assert.assertTrue(actualResult);
    }

    @Test
    public void testAddMultipleFilesDragAndDropToUpload() {
        boolean actualResult = new FileUploadPage(getDriver())
                .getFileUploadPage()
                .createFileToUpload()
                .areMultipleFileAddedToDragAndDropArea(10);

        Assert.assertTrue(actualResult);
    }
}