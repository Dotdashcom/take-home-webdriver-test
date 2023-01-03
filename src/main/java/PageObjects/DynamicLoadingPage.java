package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage extends SeleniumLibrary
{

public DynamicLoadingPage(WebDriver driver)
{
    PageFactory.initElements(driver,this);
}

@FindBy( how = How.XPATH , using = "(//a[normalize-space()='Example 1: Element on page that is hidden'])[1]")
    WebElement exampleHiddenElement;

@FindBy( how = How.XPATH , using = "(//a[normalize-space()='Example 2: Element rendered after the fact'])[1]")
    WebElement exampleRenderedElement;

public void clickHiddenElement()
{
    clickOnElement(exampleHiddenElement);
}

public void clickRenderedElement()
{
    clickOnElement(exampleRenderedElement);
}

}
