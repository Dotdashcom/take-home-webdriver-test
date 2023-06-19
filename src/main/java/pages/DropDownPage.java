package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage {

    private WebDriver driver;

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='dropdown']")
    private WebElement dropDownField;

    public void selectValueFromDropdown(String option) {
        Select select = new Select(dropDownField);
        select.selectByVisibleText(option);
    }

    public String getTextFromSelectedValueInDropdown() {
        Select select = new Select(dropDownField);
        return select.getFirstSelectedOption().getText();
    }

}
