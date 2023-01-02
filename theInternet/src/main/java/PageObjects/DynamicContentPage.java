package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicContentPage extends SeleniumLibrary
{

    public DynamicContentPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy (how = How.XPATH , using = "(//a[normalize-space()='click here'])[1]")
    WebElement clickHereLink;


    public String dynamicContentActions()
    {
        return driver.getPageSource();
    }

    public void clickHereLink(){
        clickOnElement(clickHereLink);
    }
}
