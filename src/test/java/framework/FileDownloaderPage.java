package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloaderPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), '.txt')]")
    WebElement fileLink;


    public FileDownloaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void testFileDownloader(WebDriver driver) {
        clickOnElement(driver, fileLink, "Success: Clicked on file link",
                "Failed: Unable to click on file link");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                return true;
            }
        }
        return false;
    }
}
