package pages;

import base.Functions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileDownloadPage extends Functions {

    @FindBy(xpath = "//a[contains(text(),'some-file.txt')]")
    public WebElement link;


    /**
     * Initialization all elements of LoginPage at once using PageFactory class method
     */
    public FileDownloadPage() {

        PageFactory.initElements(driver, this);

    }
}
