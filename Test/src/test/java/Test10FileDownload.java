
import org.testng.Assert;

import org.testng.annotations.Test;
import java.io.File;
import pageObject.FileDownloadPage;

public class Test10FileDownload extends TestBase{

    @Test
    public void test10FileDownload() throws InterruptedException{
        FileDownloadPage fileDownloadPage = new FileDownloadPage(webDriver);
        Thread.sleep(2000);
        fileDownloadPage.clickDownloadFile();
        Thread.sleep(2000);
        String homeDir = System.getProperty("user.home");
        File file = new File(homeDir+"/Downloads/some-file.txt");
        Assert.assertTrue(file.exists());
    }
}
