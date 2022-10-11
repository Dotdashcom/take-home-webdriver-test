package assessment;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import util.Driver;

public class FileUpload extends Driver {

    FileUploadPage page = new FileUploadPage(Driver.getDriver());

    @Test
    public void file_upload_test() {
        Driver.getDriver().get("http://localhost:7080/upload");

        page.uploadFile("C:\\Users\\Jawal\\IdeaProjects\\dotdash\\src\\test\\resources\\uploadTestFile.txt");

        page.uploadButton.click();

        String expectedMsg = "File Uploaded!";

        if (!Driver.getWait().until(ExpectedConditions.textToBePresentInElement(page.message , expectedMsg))) {
            Assert.fail("file not uploaded");
        }
        Assert.assertEquals(page.message.getText() , expectedMsg , "file uploaded success message failure");
    }
}
