package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class DynamicLoading {
    public WebDriver driver;

    public Properties pr;


    public DynamicLoading(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath="//div[@id='start']/button")
    WebElement stbtn;

    @FindBy(xpath="//div[@id='finish']/h4")
    WebElement hellotext;


    public WebElement startbtn()
    {
        return stbtn;
    }

    public WebElement textmsg()
    {
        return hellotext;
    }




}