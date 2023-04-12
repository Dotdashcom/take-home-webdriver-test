package upload_file_test;

import base.Base;
import org.testng.annotations.Test;
import page_object_model.upload_file_page.UploadFilePage;

import static org.testng.Assert.assertTrue;

public class UploadFileTest extends Base {

    @Test
    public void uploadFileTest(){
        UploadFilePage uploadFilePage = new UploadFilePage();
        uploadFilePage.choseFile().clickUploadButton();
        assertTrue(UploadFilePage.successMessage.isDisplayed());
    }
}
