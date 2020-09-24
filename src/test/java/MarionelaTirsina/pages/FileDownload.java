package MarionelaTirsina.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownload extends BasePage {
    @FindBy(xpath = "//a[@href='download/some-file.txt']")
    public WebElement downloader;
}
