package pageObjects;

import baseClasses.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.Duration;

public class DownloadPage extends Base {
    WebDriver driver;

    By file = By.xpath(readValue("downloadPage.fileXp"));

    public void downloadFile() throws InterruptedException {
        driver.findElement(file).click();
        //wait some time to download the file successfully
        Thread.sleep(2000);
    }

    public boolean isFileDownloaded() {
        String home = System.getProperty(("user.home"));
        File path = new File(home + "\\Downloads");
        File[] dirContents = path.listFiles();
        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals("some-file.txt")) {
                return true;
            }
        }
        return false;
    }

    public DownloadPage(WebDriver driver) {
        this.driver = driver;
    }
}
