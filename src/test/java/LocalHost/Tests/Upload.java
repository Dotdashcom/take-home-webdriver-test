package LocalHost.Tests;

import LocalHost.Pages.UploadPage;
import org.testng.annotations.Test;

public class Upload extends TestingBase{

    @Test(groups = "Upload")
    public void UploadFile(){
        UploadPage page = new UploadPage();
        page.UploadFile();
    }
}
