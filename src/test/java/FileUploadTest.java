import framework.Pages.FileUploadPage;
import framework.Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.WebDriverWrapper;

public class FileUploadTest extends WebDriverWrapper{

    @Test
    public void validateFileUpload(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickFileUpload();
        FileUploadPage fileUploadPage = PageFactory.initElements(driver, FileUploadPage.class);
        fileUploadPage.uploadFile();
    }
}
