package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class Mouseclick
{
    public WebDriver driver;

    public Mouseclick(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="hot-spot")
    WebElement Rclick;





    public WebElement clickonbox()
    {
        return Rclick;
    }



}
