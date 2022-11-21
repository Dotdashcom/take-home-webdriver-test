package pages;

import configuration.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

public class DownloadPage extends BasePage {

    WebDriver driver;

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='some-file.txt']")
    public WebElement fileURL;

    public void clickOnDownloadFile() {
        fileURL.click();
    }

    public void checkIfFileIsDownloaded(String fileName) throws InterruptedException {
        Thread.sleep(3000);
        File tmpDir = new File("/Users/robertomancebo/Downloads/" + fileName);
        Assert.assertTrue(tmpDir.exists());
    }

}
