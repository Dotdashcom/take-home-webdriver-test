package webdrivertestpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FileDownloader {
    WebDriver driver;
    @FindBy(xpath = "//a[@href='download/some-file.txt']")
    WebElement fileDownloader;

    public FileDownloader(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fileDownloader(){
        fileDownloader.click();
    }
}
