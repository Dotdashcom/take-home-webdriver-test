package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FileUploaderPage extends PageObject {
    @FindBy(how = How.ID, using = "file-upload")
    private WebElement fileInput;

    @FindBy(how = How.ID, using = "file-submit")
    private WebElement fileSubmit;

    public void uploadFile(String file) {
        fileInput.sendKeys(file);
        fileSubmit.click();
    }

    public boolean isUploaded() {
        WebElement uploadMessage = driver.findElement(By.tagName("h3"));
        if (uploadMessage.getText().equals("File Uploaded!"))
            return true;
        return false;
    }

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }
}
