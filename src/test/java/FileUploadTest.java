import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

public class FileUploadTest extends BaseTest {

    @Test
    public void FileUploadActionTest() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        FileUploadPage fileUploadPage = new FileUploadPage();

        boolean header = fileUploadPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        String result = fileUploadPage.fileUploadTest();
        Assert.assertEquals(result, "File Uploaded!", "validation is not successful");

    }

}
