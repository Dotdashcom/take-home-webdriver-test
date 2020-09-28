package LocalHost.Tests;

import LocalHost.Pages.DownloadPage;
import org.testng.annotations.Test;

public class Download extends TestingBase{

    @Test(groups = "Download")
    public void DownloadsText(){
        DownloadPage page = new DownloadPage();
        page.DownloadText();
    }
    @Test(groups = "Download")
    public void DownloadsPicture(){
        DownloadPage page = new DownloadPage();
        page.DownloadPic();
    }
    @Test(groups = "Download")
    public void DownloadsLogo(){
        DownloadPage page = new DownloadPage();
        page.DownloadLogo();
    }
}
