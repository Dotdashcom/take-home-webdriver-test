package Tests;

import Pages.BasePage;
import Pages.UploadedFilePage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UploadedFileVerification extends BasePage {
    UploadedFilePage uploadedPage = new UploadedFilePage();
    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/upload");
    }

    @Test
    public void TC1UploadFileVerification(){
        HelpfulMethods.staticWait(5);
        String filename = "untitled 6";
        uploadedPage.UploadFile(filename);
        Assert.assertEquals(uploadedPage.UploadFileVerification(),filename);
    }

}
