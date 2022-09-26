package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPageObj extends CommonMethods {

    public FileUploadPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(id = "file-upload")
    private WebElement chooseFileBtn;

    @FindBy(xpath = "//*[@class='button']")
    private WebElement uploadBtn;

    @FindBy(xpath = "//h3")
    private WebElement confirmText;

    public WebElement getChooseFileBtn(){
        return chooseFileBtn;
    }

    public WebElement uploadButton(){
        return uploadBtn;
    }

    public WebElement getConfirmText(){
        return confirmText;
    }

}
