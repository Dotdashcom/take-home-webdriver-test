import framework.Pages.FileDownloadPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class FileDownloadTest extends WebDriverWrapper {

    @Test
    public void verifyDownload(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickFileDownload();
        FileDownloadPage fileDownloadPage = PageFactory.initElements(driver, FileDownloadPage.class);
        fileDownloadPage.downloadFileFromLink();
    }

}
