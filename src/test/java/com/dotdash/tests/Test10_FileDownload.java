package com.dotdash.tests;

import com.dotdash.pages.DownloadPage;
import com.dotdash.utilities.ConfigurationReader;
import com.dotdash.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class Test10_FileDownload {

    /**
     * Test clicks on the file.
     * Test asserts that the file is downloaded.
     */

    //TODO change "download.path" to your directory path in configuration.properties if needed

    @Test
    public void fileDownloadTest() {

        DownloadPage downloadPage = new DownloadPage();

        String url = ConfigurationReader.getProperty("base.url") + "/download";
        Driver.getDriver().get(url);

        downloadPage.file.click();
        String path = ConfigurationReader.getProperty("download.path") + downloadPage.file.getText();
        File file = new File(path);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until((ExpectedCondition<Boolean>) f -> file.exists());

        Assert.assertTrue(file.exists());

        Driver.closeDriver();

    }

}
