package TakeHome.tests;

import TakeHome.pages.UploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTest extends TestBase {

    @Test(groups = "Upload")
    public void UploadFile(){
        UploadPage page = new UploadPage();
        page.uploadFile();
        Assert.assertEquals(page.getUploadSuccessMessage(), "File Uploaded!\n" +
                        "Group29.txt",
                "Successful file upload message is not displayed, " + page.getUploadSuccessMessage() + " is displayed instead");
    }
}
