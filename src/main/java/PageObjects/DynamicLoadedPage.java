package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadedPage extends SeleniumLibrary
{
    public DynamicLoadedPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.XPATH , using = "(//button[normalize-space()='Start'])[1]")
    WebElement startButton;

    @FindBy ( how = How.CSS,using = "div[id='finish'] h4")
    WebElement textHelloWorld;
    public void  clickStartButton() throws InterruptedException
    {
        clickOnElement(startButton);
    }

    public String getTextforHelloWorld(){
        return  textHelloWorld.getText();
    }


}
