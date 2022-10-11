package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.Objects;

public class FileDownloadedPage extends BasePage {

    public FileDownloadedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='some-file.txt']")
    public WebElement fileLink;

    public String directory = "C:\\Users\\Jawal\\Downloads";
    // if I was working with java 12 I would use Files.mismatch() but here I am using apache commons IO
    public boolean fileDownload(String fileName) throws InterruptedException {
        File dir = new File(directory);
        File[] dirContents = dir.listFiles();
        try {
            for (int i = 0; i < dirContents.length; i++) {
                if (dirContents[i].getName().equals(fileName)) {
                    dirContents[i].delete();
                    return true;
                }
            }
        } catch (NullPointerException e) {
            Assert.fail("check download directory path, the directory being used is empty and download is not there");
        }
        return false;
    }
}
