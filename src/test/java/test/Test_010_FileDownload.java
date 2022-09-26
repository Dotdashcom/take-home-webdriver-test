package test;

import Utilities.CommonMethods;
import Utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_010_FileDownload extends CommonMethods {

    @BeforeMethod
    public void launchBrowser() {
        init_Driver(ConfigReader.getInput("browser"));
        getDriver().get("http://localhost:7080/download");
    }

    @Test
    public void TC001_fileDownloadTesting() {
        String fileName = fd.downLoadFile().getText();
        fd.downLoadFile().click();
        wait(2);
        Assert.assertTrue(verifyFile("/Users/thunpanchatsurachai/Downloads", fileName));
    }

    @AfterMethod
    public void destroy() {
        tearDown();
    }
}
