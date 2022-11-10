package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.html.HTMLInputElement;

public class FileDownloadPage {

    @FindBy(tagName = "button")
    public WebElement startButton;

    @FindBy(id = "finish")
    public WebElement HelloWorld;
    public HTMLInputElement TextFile;

    public FileDownloadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}