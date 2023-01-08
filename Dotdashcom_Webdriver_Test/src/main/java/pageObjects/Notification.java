package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Notification
{
    public WebDriver driver;

    public Notification(WebDriver dr)
    {
        this.driver=dr;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath= "//div[@class='example']/p/a")
    WebElement click_here;


    public WebElement ClickonLink()
    {
        return click_here;
    }


    @FindBy(xpath= "//div[@class='flash notice']")
    WebElement flash_msg;


    public WebElement flsmsg()
    {
        return flash_msg;
    }



}
