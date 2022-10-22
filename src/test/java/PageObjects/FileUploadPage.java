package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileUploadPage extends BasePage{

    @FindBy (id = "file-upload")
    public WebElement chooseFileBtn;

    @FindBy (id = "file-submit")
    public WebElement uploadBtn;

    @FindBy (xpath = "//*[@id=\"content\"]/div/h3")
    public WebElement successMessage;

}
