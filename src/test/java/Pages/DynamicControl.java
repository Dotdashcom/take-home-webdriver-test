package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicControl {
    public DynamicControl(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='Enable']")
    public WebElement enableDisableButton;

    @FindBy(xpath = "//*[contains(text(),'It's enabled!')]")
    public WebElement enabledMessage;
}
