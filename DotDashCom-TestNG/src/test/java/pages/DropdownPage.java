package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DropdownPage {
    public DropdownPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="dropdown")
    public WebElement dropdown;
}
