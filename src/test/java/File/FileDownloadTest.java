package File;

import Pages.DynamicContentPage;
import Pages.FileDownloadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownloadTest extends TestBase {
    @BeforeClass
    public void loginUrl(){
        driver.get(TestBase.BASEURL.concat("/download"));
    }
    @Test
    public void FileDownloadtest() throws InterruptedException {

        FileDownloadPage fd=new FileDownloadPage();
        fd.file.click();
        Thread.sleep(3000);
        String floder=System.getProperty("user.home");
        String p=floder+"/downloads/some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(p)));

    }
}
