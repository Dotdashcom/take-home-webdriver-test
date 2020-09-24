package MarionelaTirsina.pages;

import io.restassured.path.xml.XmlPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class FileUpload extends BasePage {
    @FindBy(id= "drag-drop-upload")
    public WebElement squareForm;

    @FindBy(xpath = "div[class='dz-preview dz-file-preview dz-processing dz-success dz-complete']")
    public WebElement textFile;
    public String uploadFile(String filePath) {
        filePath = System.getProperty("user.dir") + "/" + filePath.replace("/", File.separator);
return filePath;

    }
}
