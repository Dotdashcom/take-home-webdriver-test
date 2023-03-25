package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class DownloadPage extends BasePage {
    private By fileLink = By.linkText("some-file.txt");

    public DownloadPage(WebDriver driver) {
        super(driver);
    }

    public void downLoadFile(){
        wait.until(ExpectedConditions.elementToBeClickable(fileLink));
        getElement(fileLink).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkFileDownloaded(String path){
        File downLoadedFile = new File(path);
        return downLoadedFile.exists();
    }

}
