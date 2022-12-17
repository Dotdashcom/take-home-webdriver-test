package Tests;

import Pages.BasePage;
import Pages.DownLoadFilePage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DownLoadFileVerification extends BasePage {
    DownLoadFilePage downLoadPage = new DownLoadFilePage();

    @BeforeClass
    public void SetUp() {
        Driver.GetDriver().get("http://localhost:7080/download");
    }

    @Test
    public void DownLoadVerification() throws IOException {
        downLoadPage.DownLoad();
        HelpfulMethods.getDownloadedFile("some-file.txt");
        HelpfulMethods.takeScreenShot("DownloadVerification");

    }
}
