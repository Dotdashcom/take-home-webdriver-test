package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class JavascriptError
{
    public WebDriver driver;

    public Properties pr;


    public JavascriptError(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//p")
    WebElement errormsg;





    public WebElement erromsg()
    {
        return errormsg;
    }



}
