package Main;

import Utilities.DriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPage {

    @FindBy(id="dropdown")
    public WebElement dropDownElement;

    public DropDownPage(){
        PageFactory.initElements(DriverHelper.getDriver(),this);
    }


}