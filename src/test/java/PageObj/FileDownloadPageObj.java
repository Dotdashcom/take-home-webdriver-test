package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPageObj extends CommonMethods {

    public FileDownloadPageObj(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(linkText = "some-file.txt")
    private WebElement someFile;

    public WebElement downLoadFile(){
        return someFile;
    }
}
