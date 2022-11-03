package testsuite;

import actions.ActionHelper;
import base.BaseTestClass;
import constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FileUploadPage;

public class TestSuite_FileUpload extends BaseTestClass {

    @Test
    public void TC_FileUpload_001_ValidateFunctionality_FileUpload() {
        ActionHelper.openUrl(Constants.UPLOAD_PAGE_URL);
        FileUploadPage fileUploadPage = FileUploadPage.getInstance();
        fileUploadPage.chooseFileSendKeys(System.getProperty("user.dir") + "/some-file.txt");
        fileUploadPage.clickUpload();
        Assert.assertEquals(fileUploadPage.getHeaderText(), "File Uploaded!");
    }
}
