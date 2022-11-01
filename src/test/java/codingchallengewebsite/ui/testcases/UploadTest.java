package codingchallengewebsite.ui.testcases;

import codingchallengewebsite.ui.UITest;
import codingchallengewebsite.ui.pageobjects.UploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends UITest {

    public UploadTest() { }

    @Test(description = "Upload a file")
    public void fileUpload() {
        UploadPage uploadPage = new UploadPage(this);

        // Validate page loaded
        Assert.assertTrue(uploadPage.isPageOpen(), "Page not open");

        // Validate file uploaded
        uploadPage.uploadFile();
        Assert.assertTrue(uploadPage.validateUploadedPageTitle(), "'File uploaded' page not loaded");
        Assert.assertTrue(uploadPage.validateUploadedFileName(), "Uploaded filename not showing");
    }
}