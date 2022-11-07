import org.testng.Assert;
import org.testng.annotations.Test;


public class FileUploadCases extends Hooks {

    @Test(dataProvider = "FileUpload")
    public  void FileDownload(String filePath) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.FileUpload.getOption());
        App.fileUploadPage.uploadDocument(filePath);
        App.fileUploadPage.clickUpload();
        Assert.assertTrue(App.fileUploadPage.validateFileUpload(filePath));

    }
}
