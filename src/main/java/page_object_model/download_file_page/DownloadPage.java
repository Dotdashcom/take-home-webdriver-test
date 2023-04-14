package page_object_model.download_file_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DownloadPage extends Base {

    public DownloadPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='some-file.txt']")
    private WebElement file;

    public void downloadFile() {
        clickOnElement(file);
    }

    public Boolean checkFileDownloaded() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "C:\\Users\\mahdi\\Downloads");
        options.setExperimentalOption("prefs", prefs);

        File downloadedFile = new File("C:\\Users\\mahdi\\Downloads\\some-file.txt");
            Thread.sleep(2000);
        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully!");
            return true;
        } else {
            System.out.println("File not downloaded!");
            return false;
        }
    }
}
