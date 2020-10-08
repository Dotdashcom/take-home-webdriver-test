package regression.ui.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


public final class FileDownloaderPage extends WebObject {
    public FileDownloaderPage(WebDriver driver) throws Exception {
        super(driver);
        this.waitForElementVisibility(By.xpath(this.xpathForPageTitle()));
    }

    public static FileDownloaderPage navigateToFileDownloaderPage(WebDriver driver, String baseUrl) throws Exception {
        String url = String.format("%s/download", baseUrl);
        driver.get(url);
        return new FileDownloaderPage(driver);
    }

    public String getPageTitle() {
        return driver.findElement(By.xpath(this.xpathForPageTitle())).getText();
    }

    public void clickFile() {
        driver.findElement(By.xpath(this.xpathForDownloadLink())).click();
    }

//    public boolean confirmFileDownload(String downloadPath, String fileName) throws InterruptedException {
//        return this.isFileDownloaded(downloadPath, fileName);
//    }

    public boolean isFileDownloaded(String downloadPath, String fileName) throws InterruptedException {
        String filepath = String.format("%s/%s", downloadPath, fileName);
        this.waitForFileToDownload(filepath);
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < Objects.requireNonNull(dir_contents).length; i++) {
            if (dir_contents[i].getName().equals(fileName))
                flag = true;
        }

        return flag;
    }

    private void waitForFileToDownload(String filePath) throws InterruptedException {
        int timeOut = 10;
        File file = new File(filePath);
        while (!file.exists() && timeOut > 0) {
            TimeUnit.SECONDS.sleep(1);
            timeOut--;
        }
    }

    private String xpathForPageTitle() {
        return "//h3";
    }

    private String xpathForDownloadLink() {
        return "//a[text()=\"some-file.txt\"]";
    }
}
