package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TC_06_DropDown_Page {
    public TC_06_DropDown_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(partialLinkText =  "Dropdown")
    public WebElement dropDownLink;
    @FindBy(xpath = "//select[@id='dropdown']")
    public WebElement optionButon;

    @FindBy(xpath = "//option[2]")
    public WebElement option1;

    @FindBy(xpath = "//option[3]")
    public WebElement option2;


}
