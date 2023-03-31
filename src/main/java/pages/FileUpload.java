package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class FileUpload {
    public FileUpload(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement chooseFile;
    @FindBy(xpath = "//input[@id='file-submit']")
    WebElement uploadButton;

    @FindBy(xpath = "//h3[.='File Uploaded!']")
    WebElement acceptMessage;

    public void file(WebDriver driver) {
        chooseFile.sendKeys("/Users/turmeegmail.com/Desktop");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        uploadButton.click();
    }

    public boolean isUpload() {
        return acceptMessage.isDisplayed();
    }
}
