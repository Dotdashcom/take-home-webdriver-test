package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadPage {

    private WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='file-upload']")
    private WebElement chooseFile;

    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement uploadButton;

    @FindBy(xpath = "//div[@class='example']/h3")
    private WebElement uploadMessage;

    public void uploadFile() {
        String fileName = "C:\\Users\\piyub\\Downloads\\some-file.txt";
        chooseFile.sendKeys(fileName);
        uploadButton.click();
    }

    public String uploadMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(uploadMessage));
        return uploadMessage.getText();
    }
}
