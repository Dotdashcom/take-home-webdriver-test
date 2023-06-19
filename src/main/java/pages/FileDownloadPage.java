package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class FileDownloadPage {

    private WebDriver driver;

    public FileDownloadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='content']//a[text()='some-file.txt']")
    private WebElement fileField;

    public void clickOnFile() throws InterruptedException {
        fileField.click();
    }

    public boolean checkFileIsDownloaded(){
        File file=new File("C:\\Users\\piyub\\Downloads\\some-file.txt");
        return file.exists();
    }
}
