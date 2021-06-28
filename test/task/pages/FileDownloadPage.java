package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtils;
import utilities.Driver;

import java.io.IOException;

public class FileDownloadPage extends PageBase{
    @FindBy(xpath = "//a[contains(@href,'download')]")
    protected WebElement downloadLink;

    public void downloadFile() throws IOException {
        downloadLink.click();
        BrowserUtils.wait(5);

    }
}