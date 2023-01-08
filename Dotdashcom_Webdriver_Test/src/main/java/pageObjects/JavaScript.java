package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScript
{
    public WebDriver driver;


    public JavaScript(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//div[@class='example']/ul/li[1]/button")
    WebElement click1;

    @FindBy(xpath="//div[@class='example']/ul/li[2]/button")
    WebElement click2;

    @FindBy(xpath="//div[@class='example']/ul/li[3]/button")
    WebElement click3;


    @FindBy(xpath="//p[@id='result']")
    WebElement result;





    public WebElement alertclick1()
    {
        return click1;
    }

    public WebElement alertclick2()
    {
        return click2;
    }

    public WebElement alertclick3()
    {
        return click3;
    }

    public WebElement endresult()
    {
        return result;
    }



}
