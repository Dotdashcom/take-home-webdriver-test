package com.trudova.getInProj.step_definitions;

import com.trudova.getInProj.pages.FileDownloadPage;
import com.trudova.getInProj.utilities.BrowserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.awt.*;
import java.io.File;


public class US9_step_definition {
    private FileDownloadPage fileDownloadPage = new FileDownloadPage();

    @Given("navigate to File Downloader")
    public void navigate_to_file_downloader() {
        fileDownloadPage.fileDownload.click();
        BrowserUtility.sleep(5
        );
    }


    @When("down lode the file")
    public void down_lode_the_file() throws AWTException {
        fileDownloadPage.fileToDownload.click();
        BrowserUtility.sleep(3);
        File file = new File("/Users/liubovtrudova/Downloads/some-file.txt");
        boolean result = file.exists();
        Assert.assertTrue(result);
    }


}
