package MarionelaTirsina.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileUpload extends BasePage {
    @FindBy(id= "drag-drop-upload")
    public WebElement squareForm;
    @FindBy(id="file-upload")
public WebElement uploadFileButton;
    @FindBy(id = "file-submit")
    public WebElement fileSubmitButton;
@FindBy(xpath = "//h3")
public WebElement assertHeader;


    public String uploadFile(String filePath) {
        filePath = System.getProperty("user.dir") + "/" + filePath.replace("/", File.separator);
return filePath;

    }
}
