package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FileDownloaderPage extends PageObject {

    @FindBy(how = How.LINK_TEXT, using = "some-file.txt")
    private WebElement download;

    public FileDownloaderPage(WebDriver driver) {
        super(driver);
    }

    public void clickLinkToDownload() {
        download.click();
    }
}
