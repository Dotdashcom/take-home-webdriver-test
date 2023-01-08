package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class DynamicContent {
    public WebDriver driver;

    public Properties pr;


    public DynamicContent(WebDriver dr)
    {
        this.driver = dr;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//div[@class='large-10 columns']")
    WebElement dynam;



    public WebElement dynamic()
    {
        return dynam;
    }


}