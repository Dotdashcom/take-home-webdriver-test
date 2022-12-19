package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage extends BasePage{
    public FileDownloadPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'File Downloader')]")
    public WebElement fileDownloadPageHeader;

    @FindBy(xpath = " //a[contains(.,'some-file.txt')]")
    public WebElement fileDownloadPageDownload;
    @FindBy(xpath = "//a[contains(.,'some-file.txt')]")
    public WebElement fileDownloadPageFile;

    public Boolean validatePageLanding(){
        fileDownloadPageHeader.isDisplayed();
        fileDownloadPageDownload.isDisplayed();
        return true;
    }

    public void clickDownload() throws InterruptedException {
        fileDownloadPageDownload.click();
        Thread.sleep(2000);
    }

    public Boolean checkDownloadFile(){
        driver.navigate().to("C:\\Users\\speed\\Downloads");
        fileDownloadPageFile.isDisplayed();
        return true;
    }
}
