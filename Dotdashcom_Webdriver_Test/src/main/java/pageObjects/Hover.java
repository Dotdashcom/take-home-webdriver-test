package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class Hover
{
    public WebDriver driver;


    public Hover(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//div[@class='figure'][1]")
    WebElement fig1;

    @FindBy(xpath="//div[@class='figure'][2]")
    WebElement fig2;

    @FindBy(xpath="//div[@class='figure'][3]")
    WebElement fig3;


    @FindBy(xpath="//div[@class='figure'][1]")
    WebElement figcap1;

    @FindBy(xpath="//div[@class='figure'][2]")
    WebElement figcap2;

    @FindBy(xpath="//div[@class='figure'][3]")
    WebElement figcap3;





    public WebElement figure1()
    {
        return fig1;
    }

    public WebElement figure2()
    {
        return fig2;
    }

    public WebElement figure3()
    {
        return fig3;
    }

    public WebElement figure1cap()
    {
        return figcap1;
    }

    public WebElement figure2cap()
    {
        return figcap2;
    }

    public WebElement figure3cap()
    {
        return figcap3;
    }



}
