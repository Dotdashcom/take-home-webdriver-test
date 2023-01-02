package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContextPage extends SeleniumLibrary
{
    public ContextPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.CSS , using = "#hot-spot")
    WebElement hotspotArea;

    public void contextAction() throws InterruptedException {
        contextClickAction(hotspotArea);
        clickOkOnAlert();
        System.out.println("*******Successfully Handles Context Action and Alert ***************");
    }

}
