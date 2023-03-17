package Pages;

import Tests.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterLoginPage {
    public AfterLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (id="flash")
    public WebElement flashNotice;
}
