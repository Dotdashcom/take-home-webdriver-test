package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileUploadPage extends BasicPage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"file-submit\"]")
    WebElement uploadButton;

    @FindBy(xpath = "//*[@id=\"file-upload\"]")
    WebElement fileInput;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://localhost:7080/upload");
        PageFactory.initElements(this.driver, this);
    }

    public void uploadByButton() {
        this.fileInput.sendKeys(new File("src/main/resources/test.jpg").getAbsolutePath());
        this.uploadButton.click();
    }

    public void assertFileUploadStatus() {
        WebDriverWait wait = new WebDriverWait(this.driver,20);
        WebElement uploadedFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"uploaded-files\"]")));
        Assert.assertEquals(uploadedFile.getText(), "test.jpg");
    }
}
