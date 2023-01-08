package pageObjects;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage
{
    public WebDriver driver;

    public loginPage(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);

    }


    @FindBy(id="username")
    WebElement usrnm;

    @FindBy(id="password")
    WebElement pswd;

    @FindBy(xpath = "//i[@class='fa fa-2x fa-sign-in']")
    WebElement sbt;

    @FindBy(xpath= "//div[@class='flash success']")
    WebElement loginmsg;

    @FindBy(xpath = "//a[@class='button secondary radius']")
    WebElement logot;


    @FindBy(xpath="//div[@class='flash error']")
    WebElement loginfail;


    public WebElement enteruser()
    {
        return usrnm;
    }

    public WebElement entercreds()
    {
        return pswd;
    }


    public WebElement submit()
    {
        return sbt;
    }

    public WebElement loginmessage()
    {
        return loginmsg;
    }

    public WebElement logout()
    {
        return logot;
    }


    public WebElement loginfailed()
    {
        return loginfail;
    }

}
