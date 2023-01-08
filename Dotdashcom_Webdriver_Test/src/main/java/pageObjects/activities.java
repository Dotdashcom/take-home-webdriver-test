package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class activities
{
    public WebDriver driver;

    public Properties pr;


    public activities(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//input[@type='checkbox'][1]")
    WebElement chkbx1;

    @FindBy(xpath="//input[@type='checkbox'][2]")
    WebElement chkbx2;

    @FindBy(id="hot-spot")
    WebElement rclick;



    public WebElement checkbox1()
    {
        return chkbx1;
    }

    public WebElement checkbox2()
    {
        return chkbx2;
    }

    public WebElement righclick()
    {
        return rclick;
    }





}
