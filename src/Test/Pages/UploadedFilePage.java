package Pages;

import Utils.Driver;
import Utils.HelpfulMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadedFilePage {
    public UploadedFilePage() {
        PageFactory.initElements(Driver.GetDriver(), this);
    }

    @FindBy(xpath = "//input[@id='file-upload']")
    private WebElement chooseFileButton;

    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement uploadButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFilesMessage;

    public void UploadFile(String fileName) {
        HelpfulMethods.clickWithWait(chooseFileButton);
        String path = "/Users/seraytugcu/" + fileName;
        chooseFileButton.sendKeys(path);
        uploadButton.click();

    }

    public String UploadFileVerification() {
        return uploadedFilesMessage.getText();
    }
}
