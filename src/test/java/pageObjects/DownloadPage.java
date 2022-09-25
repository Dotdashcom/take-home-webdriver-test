package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;

public class DownloadPage extends BaseClass {

    public DownloadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='File Downloader']")
    public WebElement downloadPageHeader;

    @FindBy(xpath = "//a[text()='some-file.txt']")
    public WebElement downloadLink;

    @FindBy(xpath = "//div[@id='defaultDownloadPath']")
    public WebElement downloadPath;
}
