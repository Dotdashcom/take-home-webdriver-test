import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.time.Instant;

public class FileDownloadPage extends PageObject{
    @FindBy(xpath = "//*[@id=\"content\"]/div/a")
    public WebElement Download_Link;
    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }
    public void DownloadFile()
    {
        String Filename = Download_Link.getText();

        Download_Link.click();

        String file_path ="C:\\Users\\Sushmitha Sajeev\\Downloads";
        Assert.assertTrue(isFileDownloaded(file_path, Filename,20), "Text file is not downloaded");

    }
    public boolean isFileDownloaded(String downloadPath, String fileName, int timeOut)
    {
        boolean flag = false;
        int waitime = timeOut;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        long waitUntil = Instant.now().getEpochSecond() + waitime;
        while (Instant.now().getEpochSecond() < waitUntil)
        {
            for (int i = 0; i < dir_contents.length; i++) {
                if (dir_contents[i].getName().equals(fileName))
                    return true;
            }

        }
        return flag;
    }
}
