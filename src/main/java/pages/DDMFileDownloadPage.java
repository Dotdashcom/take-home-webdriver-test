package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.nio.file.Paths;
public class DDMFileDownloadPage extends DDMBasePage  {
    @FindBy(css = "#content > div > a:nth-child(2)")
    protected WebElement fileDownloadLink;
    public DDMFileDownloadPage(WebDriver driver)  {
        super(driver);
    }

    public void downloadFile()  {
        fileDownloadLink.click();
        waitInMilliSeconds(2000);
    }

    public boolean isFileDownloaded()  {
        String dir = Paths.get("test-files").toAbsolutePath().toString();
        String fileName = "some-file.txt";
        String fullPath = "";

        if(System.getProperty("os.name").toLowerCase().contains("windows"))  {
            fullPath = String.format("%s%s%s", dir, "\\", fileName);
        } else if(System.getProperty("os.name").toLowerCase().contains("mac os"))  {
            fullPath = String.format("%s%s%s", dir, "/", fileName);
        }

        File fileWithFullPath = new File(fullPath);
        return fileWithFullPath.exists();
    }
}