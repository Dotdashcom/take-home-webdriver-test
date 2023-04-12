package page_object_model.upload_file_page;

import base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilePage extends Base {
    public UploadFilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "file-upload")
    private WebElement choseFileButton;
    @FindBy(id = "file-submit")
    private WebElement uploadButton;
    @FindBy(xpath = "//h3[text()='File Uploaded!']")
    public static WebElement successMessage;


    public UploadFilePage choseFile() {
        choseFileButton.sendKeys("C:\\Users\\mahdi\\Downloads\\some-file.txt");
        return new UploadFilePage();
    }

    public void clickUploadButton() {
        clickOnElement(uploadButton);
    }

}
