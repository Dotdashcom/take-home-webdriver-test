package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage {
    @FindBy(linkText = "some-file.txt")
    public WebElement file;
}
