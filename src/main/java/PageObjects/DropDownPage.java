package PageObjects;

import library.Constants;
import library.SeleniumLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DropDownPage extends SeleniumLibrary
{

    public DropDownPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID , using = "dropdown")
    WebElement dropdownButton;

    public void dropDownActions() throws InterruptedException {
        clickOnElement(dropdownButton);
       selectFromDropDown(dropdownButton, Constants.DropDownConstants.DROPDOWN_FIRSTINDEX);
    }

}
