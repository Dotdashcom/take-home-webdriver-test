package pages;

import org.openqa.selenium.By;
import utilities.ConfigurationProp;
import utilities.DriverManager;
import utilities.UtilitiesManager;

import java.time.Duration;

public class FileUploadPage {
    private final By header = By.xpath("//h3[text()='File Uploader']");
    private final By fileUploadpath = By.id("file-upload");
    private final By fileUploadSubmit = By.xpath("//*[@id='file-submit']");
    private final By fileUploaded = By.xpath("//*[@id=\"content\"]/div/h3");

    public FileUploadPage navigateToPage() {
        DriverManager.getDriver().navigate().to(ConfigurationProp.getProp().getProperty("url") + "/upload");
        return this;
    }

    public boolean VerifyHeader() {
        return UtilitiesManager.FindElement(header).isDisplayed();
    }

    public String fileUploadTest() {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String filepath = System.getProperty("user.dir") + "/uploader.txt";
        UtilitiesManager.FindElement(fileUploadpath).sendKeys(filepath);
        UtilitiesManager.FindElement(fileUploadSubmit).click();
        return UtilitiesManager.FindElement(fileUploaded).getText();

    }
}
