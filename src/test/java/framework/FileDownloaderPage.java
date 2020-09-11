package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloaderPage extends BasePage{

    @FindBy(xpath = "//a[contains(text(), '.txt')]")
    WebElement fileLink;


    public FileDownloaderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void testFileDownloader(WebDriver driver) {
        clickOnElement(driver, fileLink, "Success: Clicked on file link",
                "Failed: Unable to click on file link");
    }
}
