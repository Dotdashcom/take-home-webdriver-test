package task.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.utilities.BrowserUtils;
import task.utilities.Driver;

public class FileDownloadPage {

    public FileDownloadPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "some-file.txt")
    public WebElement file;


    public void downloadFile(){
        file.click();
        BrowserUtils.waitFor(5);
    }

}
