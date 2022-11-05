package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_10_FileDownload_Page {
    public TC_10_FileDownload_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "File Download")
    public WebElement fileDownloadlink;

    @FindBy(partialLinkText ="some-file.txt")
    public WebElement downloadButton;
}
