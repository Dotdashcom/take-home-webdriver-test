package com.tests;

import com.assignments.pages.FileDownloadPage;
import com.assignments.pages.HomePage;
import com.assignments.pages.MouseHoverPage;
import org.testng.annotations.Test;

import static com.assignments.constants.FrameworkConstants.USERDIR;
import static com.assignments.constants.LinkNameConstants.FILE_DOWNLOAD;
import static org.testng.Assert.assertTrue;

public final class FileDownloadTest extends BaseTest {

    /**
     * Private constructor for avoiding external instantiation.
     */
    private FileDownloadTest() {

    }

    String DIRECTORY = System.getProperty("user.dir");

    @Test(description = "Validate File is Downloaded when clicked on the Link",
            testName = "File Download Validation")
    public void validateFileDownload() {
        new HomePage().clickOnLink(FILE_DOWNLOAD);
        assertTrue(new FileDownloadPage().clickOnFileLink().isFilePresent(USERDIR));
    }
}
