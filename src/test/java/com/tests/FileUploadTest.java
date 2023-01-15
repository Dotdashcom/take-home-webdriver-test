package com.tests;

import com.assignments.pages.FileDownloadPage;
import com.assignments.pages.FileUploadPage;
import com.assignments.pages.HomePage;
import org.testng.annotations.Test;

import static com.assignments.constants.FrameworkConstants.UPLOAD_IMAGE_PATH;
import static com.assignments.constants.LinkNameConstants.FILE_UPLOAD;
import static org.testng.Assert.assertTrue;

public final class FileUploadTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private FileUploadTest() {

    }

    @Test(description = "Validate File is Uploaded using Upload Button",
            testName = "File Upload Validation")
    public void validateFileUpload() {
        new HomePage().clickOnLink(FILE_UPLOAD);
        assertTrue(new FileUploadPage().clickOnChooseFileAndUpload(UPLOAD_IMAGE_PATH).isFileUploaded());
    }
}
