import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileDownloadPage;
import pages.HomePage;

import java.io.IOException;

public class FileDownloadTest extends BaseTest {

    @Test
    public void FileDownloadActionTest() throws IOException {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.VerifyHomePage(), "Home Page is not displayed");

        FileDownloadPage fileDownloadPage = new FileDownloadPage();

        boolean header = fileDownloadPage.navigateToPage().VerifyHeader();
        Assert.assertTrue(header, "page is not navigated");

        boolean result = fileDownloadPage.fileDownloadTest();
        Assert.assertTrue(result, "validation is not successful");

    }

}
