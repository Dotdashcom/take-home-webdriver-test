package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FileUploadPage;
import testComponents.BaseTest;

public class FileUploadTest extends BaseTest {


    @Test
    public void fileUpload(){
        FileUploadPage fileUploadPage=new FileUploadPage(driver);
        fileUploadPage.goTo();
        fileUploadPage.uploadTheFile();
        String message=fileUploadPage.getMessage();
        Assert.assertEquals(message,"File Uploaded!");
    }
}
