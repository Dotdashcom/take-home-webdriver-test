package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.UploadPage;

public class UploadPageTest extends TestConfiguration {
    @Test
    @Parameters({"baseUrl", "uploadUrl", "uploadPath", "uploadMessage"})
    public void file_Upload_Test(String baseUrl, String uploadUrl, String uploadPath, String uploadMessage) {
        UploadPage uploadPage = new UploadPage(driver);
        uploadPage.goToUrl(baseUrl , uploadUrl);

        uploadPage.uploadFile(uploadPath);
        uploadPage.clickSubmitButton();
        Assert.assertTrue(uploadPage.getMessage().equals(uploadMessage));
    }
}
