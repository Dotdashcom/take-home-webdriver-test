package Main;

import Utilities.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    @FindBy(tagName = "p")
    public WebElement text;

    public IframePage(){
        PageFactory.initElements(DriverHelper.getDriver(),this);
    }
}
