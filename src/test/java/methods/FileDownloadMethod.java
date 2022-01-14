package methods;

import model.FileDownloadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class FileDownloadMethod extends GeneralTestMethod{
    private final String fileDownloadURL = "http://localhost:7080/download";
    FileDownloadPage fileDownloadPage;

    public void startFileDownloadTest() throws InterruptedException {
        driver.get(fileDownloadURL);
        fileDownloadPage = new FileDownloadPage(driver);
        download(fileDownloadPage.downloadComponent());
    }

    public void download(WebElement webElement) throws InterruptedException {
        webElement.click();
        Thread.sleep(10000);
    }

    public boolean isFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

}
