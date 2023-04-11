package com.framework.testcases;
import com.framework.pages.UploadPage;
import com.framework.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadPageTest extends TestBase {
    UploadPage uploadPage;

    @BeforeTest
    public void setup() {
        super.setup();
    }


    @Test(priority = 1, description = "User is on the file upload page")
    public void user_is_on_file_upload_page() {
        uploadPage = new UploadPage(driver);
        uploadPage.navigate();
        String actualURL = uploadPage.getCurrentURL();
        String expectedURL = "http://localhost:7080/upload";
        Assert.assertEquals(actualURL, expectedURL);
    }

    @Test(priority = 2, description = "User can upload file using Choose File button")
    public void user_can_upload_file_using_choose_file_button() {
        String fileName = "some-file.txt";
        uploadPage = new UploadPage(driver);
        uploadPage.navigate();
        String actualFileName = uploadPage.uploadFileUsingButton(fileName);
        String expectedFileName = fileName;
        Assert.assertEquals(actualFileName, expectedFileName);
    }

    @Test(priority = 3, description = "User can upload file using drag and drop field")
    public void user_can_upload_file_using_drag_and_drop() {
        String fileName = "some-file.txt";
        uploadPage = new UploadPage(driver);
        uploadPage.navigate();
        String actualFileName = uploadPage.uploadFileUsingDragAndDrop(fileName);
        String expectedFileName = fileName;
        Boolean doesFileNameExists = actualFileName.contains(expectedFileName);
        Assert.assertTrue(doesFileNameExists);
    }
	
    @AfterTest
    public void teardown() {
        super.cleanup();
    }

}
