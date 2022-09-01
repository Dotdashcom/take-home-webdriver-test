package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DynamicLoadingPage {
    public DynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(tagName = "button")
    public WebElement startButton;

    @FindBy(id = "finish")
    public WebElement finishText;
}
