package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUpload;

public class FileUploadTest extends TestBase {
    @Test
    public void test() {
        driver.get("http://localhost:7080/upload");
        FileUpload upload = new FileUpload(driver);
        upload.file(driver);
        Assert.assertTrue(upload.isUpload());
    }
}
