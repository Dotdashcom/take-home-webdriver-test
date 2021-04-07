package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OpeninNewTabPage {
    public OpeninNewTabPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(linkText = "Click Here")
    public WebElement clicknewtab;

}
