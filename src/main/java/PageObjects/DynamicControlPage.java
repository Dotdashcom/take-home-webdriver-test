package PageObjects;

import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicControlPage extends SeleniumLibrary
{

    public DynamicControlPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH , using = "(//button[normalize-space()='Remove'])[1]")
    WebElement removeButton;

    @FindBy(how = How.XPATH , using = "(//button[normalize-space()='Add'])[1]")
    WebElement addButton;

    @FindBy( how = How.ID , using = "checkbox")
    WebElement checkBox;

    @FindBy ( how = How.XPATH , using = "(//button[normalize-space()='Enable'])[1]")
    WebElement enableButton;

    @FindBy (how = How.XPATH , using = "(//input[@type='text'])[1]")
    WebElement textBox;


    @FindBy (how = How.XPATH , using = "(//button[normalize-space()='Disable'])[1]")
    WebElement disableButton;

    public boolean dynamicControlClickRemoveButton() throws InterruptedException {
        clickOnElement(removeButton);
       Thread.sleep(2000);
        return isElementDisplayed(checkBox);
    }

    public boolean dynamicControlClickAddButton() {
        clickOnElement(addButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  isElementDisplayed(checkBox);
    }

    public boolean dynamicControlEnableButton()
    {
        clickOnElement(enableButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return  isElementEnable(textBox);
    }

    public boolean dynamicControlDisableButton()
    {
        clickOnElement(disableButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return isElementEnable(textBox);
    }
}
