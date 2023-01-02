package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage
{
    @FindBy(xpath="//a")
    List<WebElement>   hyperLinks;
    SeleniumLibrary seleniumLibrary = new SeleniumLibrary();

    public HomePage(WebDriver driver)  {
        try {
            PageFactory.initElements(driver, this);
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
    public void clickOnLink(String key)
    {
     seleniumLibrary.clickOnElement(seleniumLibrary.selectAnWebElementFromList(hyperLinks, key));
    }
}

