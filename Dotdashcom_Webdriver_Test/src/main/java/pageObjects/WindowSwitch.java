package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class WindowSwitch
{
    public WebDriver driver;

    public Properties pr;


    public WindowSwitch(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='example']/a")
    WebElement clickwind;





    public WebElement windowswi()
    {
        return clickwind;
    }



}
