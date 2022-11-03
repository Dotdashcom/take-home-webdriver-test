package testcases;

import com.example.testautomation_dotdash.base.BaseTest;
import com.example.testautomation_dotdash.pages.FileUploadPage;
import org.junit.Test;

public class FileUploadTest extends BaseTest {

    public FileUploadTest(){
        super();
    }

    @Test
    public void ChooseAFileAndUpload(){

        FileUploadPage fileUploadPage = new FileUploadPage(driver);

        fileUploadPage.chooseFileToUpload(System.getProperty("user.dir") + "/src/main/resources/file_storage/upload-file.txt");
        fileUploadPage.clickUploadButton();
        fileUploadPage.assertFileWasUploaded();
    }




}
