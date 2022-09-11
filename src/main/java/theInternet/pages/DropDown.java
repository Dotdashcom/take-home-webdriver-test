package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DropDown {

    public DropDown(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/dropdown']")
    WebElement dropDownPage;
    @FindBy(id = "dropdown")
    WebElement dropdownSelect;
    @FindBy(xpath = "//option[@value='1']")
    WebElement option1;




    public void dropDown(){

        dropDownPage.click();
        Select select = new Select(dropdownSelect);
        select.selectByValue("1");

        Assert.assertTrue(option1.isSelected());

    }
}
