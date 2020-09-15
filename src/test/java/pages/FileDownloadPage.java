package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.BrowserUtils;

import java.io.IOException;

public class FileDownloadPage extends PageBase {

    @FindBy(xpath = "//a[contains(@href,'download')]")
    protected WebElement downloadLink;

    public void downloadFile() throws IOException {
        downloadLink.click();
        BrowserUtils.wait(5);

    }
}
