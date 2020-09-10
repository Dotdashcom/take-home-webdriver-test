package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage  extends Functions {

    @FindBy(id = "file-upload")
    public WebElement chooseFileBtn;

    @FindBy(id = "file-submit")
    public WebElement uploadBtn;

    @FindBy(id = "uploaded-files")
    public WebElement uploadedFile;



    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public FileUploadPage() {

        PageFactory.initElements(driver, this);

    }
}
