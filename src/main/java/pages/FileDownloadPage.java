package pages;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;


public class FileDownloadPage extends BasicPage {
    WebDriver driver;
    String downloadPath;

    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    WebElement fileLink;

    public FileDownloadPage(WebDriver driver, String downloadPath) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/download");
        PageFactory.initElements(this.driver, this);
        this.downloadPath = downloadPath;
    }

    public void clickFileDownloadLink() {
        fileLink.click();
    }

    public void assertFileDownloadStatus(String filename) {
        File[] dirFiles = new File(this.downloadPath).listFiles();
        for (File file:dirFiles) {
            if(file.getName().equals(filename)) {
                return;
            }
        }
        Assert.fail();
    }
}
