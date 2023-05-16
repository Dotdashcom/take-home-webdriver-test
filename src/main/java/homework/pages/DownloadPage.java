package homework.pages;

import homework.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DownloadPage {

    public DownloadPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "some-file.txt")
    public WebElement file;

}
