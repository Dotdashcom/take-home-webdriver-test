package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;


public class HomePage
{
    @FindBy(xpath="//a")
    List<WebElement>   hyperLinks;
    SeleniumLibrary seleniumLibrary = new SeleniumLibrary();

    public HomePage(WebDriver driver)  {
        PageFactory.initElements(driver, this);
    }
    public void clickOnLink(String key)
    {
     seleniumLibrary.clickOnElement(seleniumLibrary.selectAnWebElementFromList(hyperLinks, key));
    }
}

