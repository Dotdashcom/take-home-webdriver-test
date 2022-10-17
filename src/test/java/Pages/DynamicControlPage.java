package Pages;

import Utilities.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlPage extends TestBase {

    public DynamicControlPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(xpath = "//div[@id='checkbox']")
    public WebElement checkBox;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(xpath = "//p[@id='message']")
    public WebElement messageForEnableAndDisable;

    @FindBy(xpath = "//form[@id='checkbox-example']//p[@id='message']")
    public WebElement messageForCheckBox;

}
