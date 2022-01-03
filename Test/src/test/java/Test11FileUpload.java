
import org.testng.Assert;

import org.testng.annotations.Test;
import pageObject.FileUploadPage;

public class Test11FileUpload extends TestBase{

    @Test
    public void test11FileUpload() throws InterruptedException{
        FileUploadPage fileUploadPage = new FileUploadPage(webDriver);
        String fileDir = System.getProperty("user.dir")+"/src/main/uploadfile/some-file.txt";
        fileUploadPage.upload(fileDir);
        fileUploadPage.clickSubmitButton();
        Thread.sleep(2000);
        Assert.assertTrue(fileUploadPage.isUploaded());
    }
}
