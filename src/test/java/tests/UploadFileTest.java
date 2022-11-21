package tests;

import com.qa.pages.BasePage;
import com.qa.pages.DirectoryPage;
import com.qa.pages.FileUpload;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileTest extends BasePage {

    FileUpload fa;

    @BeforeTest
    public void setUp()
    {
        webDriver_init("chrome");
        navigateToSite(DirectoryPage.fileUpload);
        fa=new FileUpload();
    }
    @Test
    public boolean downloadFile()
    {
        return fa.uploadfile(System.getProperty("User.Home")+"//Download//some-file.txt");
    }

    @AfterTest
    public void tearDown()
    {
        quit();
    }
}
