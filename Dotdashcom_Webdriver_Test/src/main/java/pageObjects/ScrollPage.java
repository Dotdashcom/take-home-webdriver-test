package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class ScrollPage
{
    public WebDriver driver;

    public Properties pr;


    public ScrollPage(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='scroll large-10 columns large-centered']")
    WebElement page;

    @FindBy(xpath="//div[@id='menu']")
    WebElement floatmnenu;





    public WebElement scroll()
    {
        return page;
    }

    public WebElement floating()
    {
        return floatmnenu;
    }



}
