package Pages;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IFramePage {

    @FindBy(tagName = "p")
    public WebElement text;

    public IFramePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}