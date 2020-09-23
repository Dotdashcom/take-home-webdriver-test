package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends BasePage {

    @FindBy (xpath = "//a[text()='some-file.txt']")
    public WebElement file;
}
