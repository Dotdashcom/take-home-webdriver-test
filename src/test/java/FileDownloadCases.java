import org.testng.Assert;
import org.testng.annotations.Test;


public class FileDownloadCases extends Hooks {

    @Test(dataProvider = "FileDownload")
    public  void FileDownload(String path, String file) throws InterruptedException {
        App.homePage.clickOptionFromMenu(HomeOptions.FileDownload.getOption());
        App.fileDownloadPage.downloadDocument(file);
        Assert.assertTrue(App.fileDownloadPage.validateFileDownload(path,file));

    }
}
