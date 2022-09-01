package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicLoadPage {
    public DynamicLoadPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[.='Start']")
    public WebElement startButton;

    @FindBy(xpath = "//*[text()='Hello World!']")
    public WebElement helloMessage;
}
