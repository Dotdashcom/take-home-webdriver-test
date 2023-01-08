package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFile
{
    public WebDriver driver;

    public UploadFile(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@id='drag-drop-upload']")
    WebElement upl;

    public WebElement upload()
    {
        return upl;
    }


}
