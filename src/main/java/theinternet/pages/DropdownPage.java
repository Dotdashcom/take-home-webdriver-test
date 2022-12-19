package theinternet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage{
    public DropdownPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h3[contains(.,'Dropdown List')]")
    public WebElement dropDownPageHeader;
    @FindBy(xpath = "//select[@id='dropdown']")
    public WebElement dropDownElement;
    public Boolean validatePageLanding() throws InterruptedException {
        dropDownPageHeader.isDisplayed();
        dropDownElement.isDisplayed();
        return true;
    }

    public DropdownPage selectDropDown(String option) {
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByVisibleText(option);
        return this;
    }

    public String getDropDownText() {
        Select dropDown = new Select(dropDownElement);
        String text = dropDown.getFirstSelectedOption().getText();
        return text;
    }
}
