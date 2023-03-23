package steps;

import org.testng.Assert;
import pages.UploadPage;

public class UploadSteps {

    UploadPage uploadPage = new UploadPage();

    public void uploadFile(String filePath, String fileName){
        uploadPage.chooseFile(filePath+fileName);
        uploadPage.uploadFile();
        Assert.assertEquals(uploadPage.getUploadedFileName(), fileName);
    }

}
