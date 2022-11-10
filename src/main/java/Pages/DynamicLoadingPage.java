package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {

    @FindBy(tagName = "button")
    public WebElement startButton;

    @FindBy(id = "finish")
    public WebElement HelloWorld;

    public DynamicLoadingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}