package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import tests.TestBase;

public class FileDownloadPage extends TestBase {
    By downloadLink = By.cssSelector("a[href='download/some-file.txt']");

    public FileDownloadPage() {
        PageFactory.initElements(TestBase.getInstance().getDriver(), this);
    }
    /*@FindBy(css = "a[href='download/some-file.txt']")
     WebElement downloadLink;*/

    public By fileDownload() {
        return downloadLink;
    }

}
