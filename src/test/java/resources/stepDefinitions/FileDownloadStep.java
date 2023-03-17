package resources.stepDefinitions;

import resources.utilities.BaseClass;
import resources.pages.FileDownloadPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;

public class FileDownloadStep extends BaseClass{

    @Given("User launches the file download page")
    public void userLaunchesTheFileDownload() {
        BaseClass tb= new BaseClass();
        String addPath="download ";
        tb.setupDownload(addPath);
    }
    @And("User download the file")
    public void fileDownload() {
        FileDownloadPages fd = new FileDownloadPages();
        fd.userfileDownload();
    }

    @And("User verifies the file is downloaded")
    public void verifyFileDownload() {
        FileDownloadPages fd = new FileDownloadPages();
        boolean fileExists=fd.userverifyfiledownload();
        Assert.assertTrue(fileExists);
        System.out.println(fileExists);
    }
}
