package tests;

import Pages.UploadFile_Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class UploadFileTest {
    public String Url_Upload="upload";
    WebDriver driverDotDash;
    UploadFile_Page uploadFile_page;
    @Before
    public void setUp() {
        uploadFile_page=new UploadFile_Page(driverDotDash);
        uploadFile_page.setChrome();
        uploadFile_page.setUrl(Url_Upload);
    }

    @Test
    public void uploadFile(){
        uploadFile_page.uploadFileAction();
    }

    @After
    public void tearDown(){
        uploadFile_page.closeAllWindows();
    }
}
