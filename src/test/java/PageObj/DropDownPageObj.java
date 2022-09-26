package PageObj;

import Utilities.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropDownPageObj extends CommonMethods {

    public DropDownPageObj() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='dropdown']")
    private WebElement dropDownBox;

    @FindBy(xpath = "//*[@id='dropdown']/option[2]")
    private WebElement opt1;

    @FindBy(xpath = "//*[@id='dropdown']/option[3]")
    private WebElement opt2;

    public WebElement DropDown() {
        return dropDownBox;
    }

    public WebElement option1() {
        return opt1;
    }

    public WebElement option2() {
        return opt2;
    }

}
