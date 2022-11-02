package com.takehomewebdrivertest;
import com.takehomewebdrivertest.dataprovider.ConfigFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class DownloadPage extends BasePage {

    public DownloadPage(WebDriver driver) {
        super(driver);
    }
    ConfigFileReader configFileReader;

    private final String URL = "/download";

    private final By pageTitle = By.cssSelector("h3");
    private final By downloadButton = By.cssSelector("a[href=\"download/some-file.txt\"]");

    public void navigateToDownloadPage() throws Exception {
        configFileReader= new ConfigFileReader();
        driver.get(configFileReader.getBaseUrl() + "/download");
        assertThat(getCurrentUrl()).contains(URL);
        String pageTitleText = driver.findElement(pageTitle).getText();
        assertThat(pageTitleText).contains("File Downloader");
    }

    public void clickOnDownloadBtn() throws Exception {
        click(downloadButton);
        threadSleep(5000);
    }

    public void verifyFileDownloaded() {
        configFileReader= new ConfigFileReader();
        isFileDownloaded(configFileReader.getDownloadPath(), "some-file.txt", true);
    }
}
